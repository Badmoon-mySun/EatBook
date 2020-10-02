package ru.itis.eatbook.controllers;

import ru.itis.eatbook.services.UsersService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        UsersService usersService = (UsersService) getServletContext().getAttribute("usersService");

        usersService.logout(req, resp);

        resp.sendRedirect("/home");
    }
}
