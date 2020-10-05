package ru.itis.eatbook.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Pattern;

public class LoginValidateFilter implements Filter {
    Pattern emailPattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (httpRequest.getMethod().equals("POST")) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            String error = null;
            if (email == null || !emailPattern.matcher(email).matches()) {
                error = "Invalid email";
            } else if (password == null) {
                error = "Invalid password";
            }

            if (error != null) {
                httpRequest.setAttribute("error", error);
                httpRequest.setAttribute("email", email);
                httpRequest.getRequestDispatcher("/WEB-INF/pages/login.ftl")
                        .forward(httpRequest, httpResponse);
                return;
            }
        }
        chain.doFilter(request, response);
    }
}
