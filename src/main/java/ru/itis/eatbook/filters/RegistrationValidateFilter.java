package ru.itis.eatbook.filters;

import ru.itis.eatbook.services.UsersService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

public class RegistrationValidateFilter implements Filter {
    Pattern nameParent = Pattern.compile("^[А-Яа-яЁёA-Za-z]+$");
    Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");
    Pattern phoneParent = Pattern.compile("(\\+7)+[0-9]{10}");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        UsersService usersService = (UsersService) httpRequest.getServletContext().getAttribute("usersService");

        if (httpRequest.getMethod().equals("POST")) {
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");
            String password2 = request.getParameter("password2");

            String error = null;
            if (name == null || !nameParent.matcher(name).matches()) {
                error = "Invalid name";
            } else if (email == null || !emailPattern.matcher(email).matches()) {
                error = "Invalid email";
            } else if (usersService.getUserByEmail(email).isPresent()) {
                error = "A user with this email already exists";
            } else if (phone == null || !phoneParent.matcher(phone).matches()) {
                error = "Invalid phone";
            } else if (password == null || !password.equals(password2)) {
                error = "Passwords do not match";
            }

            if (error != null) {
                httpRequest.setAttribute("error", error);
                httpRequest.setAttribute("name", name);
                httpRequest.setAttribute("phone", phone);
                httpRequest.setAttribute("email", email);
                httpRequest.getRequestDispatcher("/WEB-INF/pages/registration.ftl")
                        .forward(httpRequest, httpResponse);
                return;
            }
        }
        chain.doFilter(request, response);

    }
}
