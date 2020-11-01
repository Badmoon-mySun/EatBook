package ru.itis.eatbook.filters;

import ru.itis.eatbook.models.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AdminCheckFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;

        User user = (User) servletRequest.getSession().getAttribute("user");
        if (!user.getRole().equals("admin")) {
            servletResponse.sendRedirect("/home");
            return;
        }

        chain.doFilter(request, response);
    }
}
