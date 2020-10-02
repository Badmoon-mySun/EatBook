package ru.itis.eatbook.controllers;

import lombok.SneakyThrows;
import ru.itis.eatbook.dto.UserDto;
import ru.itis.eatbook.services.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("uri", req.getRequestURI());
        req.getRequestDispatcher("/WEB-INF/pages/login.ftl").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String remember = req.getParameter("remember");

        UsersService usersService = (UsersService) getServletContext().getAttribute("usersService");

        UserDto user = usersService.authorize(email, password);

        if (user != null) {
            if (remember != null) {
                usersService.setCookie(user, resp);
            }
            usersService.setSession(user, req);
            resp.sendRedirect("home");
        } else {
            req.setAttribute("email", email);
            req.setAttribute("error", "The username or password you entered is incorrect");
            doGet(req, resp);
        }
    }
}
