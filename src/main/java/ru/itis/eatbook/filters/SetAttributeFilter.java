package ru.itis.eatbook.filters;

import ru.itis.eatbook.models.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SetAttributeFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        httpRequest.setAttribute("uri", httpRequest.getRequestURI());

        HttpSession session = httpRequest.getSession(false);
        if (session != null) {
            httpRequest.setAttribute("user", session.getAttribute("user"));
        }

        chain.doFilter(request, response);
    }
}
