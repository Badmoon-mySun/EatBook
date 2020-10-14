package ru.itis.eatbook.filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class IdValidateFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String idStr = request.getParameter("id");

        try {
            Long.parseLong(idStr);
        } catch (NumberFormatException | NullPointerException e) {
            return;
        }

        chain.doFilter(request, response);
    }
}
