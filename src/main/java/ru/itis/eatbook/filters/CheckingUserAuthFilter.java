package ru.itis.eatbook.filters;

import ru.itis.eatbook.models.User;
import ru.itis.eatbook.services.interfaces.UsersService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

public class CheckingUserAuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;

        HttpSession session = servletRequest.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            servletResponse.sendRedirect("/login");
            return;
        }

        chain.doFilter(request, response);
    }
}
