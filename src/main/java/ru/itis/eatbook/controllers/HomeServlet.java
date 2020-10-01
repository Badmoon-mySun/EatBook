package ru.itis.eatbook.controllers;

import ru.itis.eatbook.dto.UserDto;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object user = req.getSession().getAttribute("user");
        if (user != null) {
            req.setAttribute("username", ((UserDto) user).getName());
        }
        req.getRequestDispatcher("/WEB-INF/pages/home.ftl").forward(req, resp);
    }
}
