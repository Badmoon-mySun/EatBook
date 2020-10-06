package ru.itis.eatbook.filters;

import ru.itis.eatbook.services.UsersService;
import ru.itis.eatbook.utils.ValidateParams;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistrationValidateFilter implements Filter {
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
            if (name == null || !ValidateParams.usernameValid(name)) {
                error = "Invalid name";
            } else if (email == null || !ValidateParams.emailValid(email)) {
                error = "Invalid email";
            } else if (usersService.getUserByEmail(email).isPresent()) {
                error = "A user with this email already exists";
            } else if (phone == null || !ValidateParams.phoneValid(phone)) {
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
