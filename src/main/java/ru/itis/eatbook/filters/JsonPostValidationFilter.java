package ru.itis.eatbook.filters;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

public class JsonPostValidationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest servletRequest = (HttpServletRequest) request;

        if (servletRequest.getMethod().equals("POST")) {
            String strJson = request.getReader().lines().collect(Collectors.joining());
            try {
                JSONObject jsonObject = new JSONObject(strJson);
                request.setAttribute("jsonObj", jsonObject);
            } catch (JSONException e) {
                return;
            }
        }

        chain.doFilter(request, response);
    }
}
