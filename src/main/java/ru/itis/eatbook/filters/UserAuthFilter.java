package ru.itis.eatbook.filters;

import ru.itis.eatbook.models.User;
import ru.itis.eatbook.services.interfaces.UsersService;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

public class UserAuthFilter implements Filter {
    UsersService usersService;

    @Override
    public void init(FilterConfig filterConfig) {
        usersService = (UsersService) filterConfig.getServletContext().getAttribute("usersService");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        HttpSession session = httpRequest.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            for (Cookie cookie : httpRequest.getCookies()) {
                if (cookie.getName().equals("session")) {
                    Optional<User> userOptional = usersService.getUserByUuid(cookie.getValue());
                    if (userOptional.isPresent()) {
                        usersService.setSession(userOptional.get(), request);
                        break;
                    }
                }
            }
        }

        chain.doFilter(request, response);
    }
}
