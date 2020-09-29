//package ru.itis.eatbook.filter;
//
//import ru.itis.eatbook.model.User;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebFilter("/home")
//public class TestFilter implements Filter {
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest httpRequest = (HttpServletRequest) request;
//        HttpServletResponse httpResponse = (HttpServletResponse) response;
//
//        User user = (User) httpRequest.getSession().getAttribute("user");
//        if (user == null) {
//            httpResponse.sendRedirect("/EatBook_war_exploded/login");
//        }
//    }
//}
