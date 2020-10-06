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
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        if (httpRequest.getMethod().equals("POST")) {
            String name = httpRequest.getParameter("username");
            String age = httpRequest.getParameter("age");
            String phone = httpRequest.getParameter("phone");
            String gender = httpRequest.getParameter("gender");

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
                httpRequest.setAttribute("error", error);
                httpRequest.getRequestDispatcher("/WEB-INF/pages/profile-edit.ftl")
                        .forward(httpRequest, httpResponse);
                return;
            }
        }

        chain.doFilter(request, response);
    }
}
