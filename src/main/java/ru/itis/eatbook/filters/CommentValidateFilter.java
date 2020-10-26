package ru.itis.eatbook.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CommentValidateFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;

        if (servletRequest.getMethod().equals("POST")) {
            String comment = request.getParameter("review_text");
            HttpSession session = servletRequest.getSession(false);

            if (comment == null || comment.isEmpty()
                    || session == null || session.getAttribute("user") == null) {
                servletResponse.sendRedirect(servletRequest.getRequestURI());
                return;
            }
        }

        chain.doFilter(request, response);
    }
}
