package ru.itis.eatbook.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CommentValidateFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        if (servletRequest.getMethod().equals("POST")) {
            String comment = request.getParameter("review_text");

            if (comment == null || comment.isEmpty()) {
                servletResponse.sendRedirect(servletRequest.getRequestURI());
                return;
            }
        }

        chain.doFilter(request, response);
    }
}
