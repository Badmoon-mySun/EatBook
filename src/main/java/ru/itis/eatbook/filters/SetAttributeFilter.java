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
            User user = (User) session.getAttribute("user");
            if (user != null) {
                httpRequest.setAttribute("username", user.getName());
                httpRequest.setAttribute("userAvatar", user.getAvatar());
                httpRequest.setAttribute("userAge", user.getAge());
                httpRequest.setAttribute("userGender", user.getGender());
                httpRequest.setAttribute("userEmail", user.getEmail());
                httpRequest.setAttribute("userPhone", user.getPhone());
            }
        }
        chain.doFilter(request, response);
    }
}
