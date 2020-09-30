package ru.itis.eatbook.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.regex.Pattern;

@WebFilter("/registration")
public class RegistrationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        Pattern nameParent = Pattern.compile("^[А-Яа-яЁёA-Za-z]+$");
        Pattern mailPattern = Pattern.compile("(\\+7)+[0-9]{10}");
        Pattern phoneParent = Pattern.compile("[-.;()/\":'a-zA-Zа-яА-Я]");

        if (request1.getMethod().equals("POST")) {
            try {
                String name = request.getParameter("name");
                String mail = request.getParameter("email");
                String phone = request.getParameter("phone");
                String password = request.getParameter("password");
                String password2 = request.getParameter("password2");

                if (nameParent.matcher(name).matches()
                        && mailPattern.matcher(mail).matches()
                        && phoneParent.matcher(phone).matches()
                        && password.equals(password2)) {

                    chain.doFilter(request, response);
                }
            } catch (NumberFormatException ignore) { }
            return;
        }
        chain.doFilter(request, response);

    }
}
