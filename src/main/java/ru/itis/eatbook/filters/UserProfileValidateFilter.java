package ru.itis.eatbook.filters;

import ru.itis.eatbook.utils.ValidateParams;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserProfileValidateFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        if (httpRequest.getMethod().equals("POST")) {
            String name = request.getParameter("username");
            String age = request.getParameter("age");
            String phone = request.getParameter("phone");
            String gender = request.getParameter("gender");

            String error = null;
            if (name == null || !ValidateParams.usernameValid(name)) {
                error = "Incorrect email";
            } else if (phone == null || !ValidateParams.phoneValid(phone)) {
                error = "Incorrect phone";
            } else if (age != null && !ValidateParams.ageValidate(age)) {
                error = "Incorrect age";
            } else if (gender != null && !ValidateParams.genderValidate(gender)) {
                error = "Incorrect gender";
            }

            if (error != null) {
                request.setAttribute("error", error);
                httpRequest.getRequestDispatcher("/WEB-INF/pages/profile-edit.ftl")
                        .forward(request, response);
                return;
            }
        }

        chain.doFilter(request, response);
    }
}
