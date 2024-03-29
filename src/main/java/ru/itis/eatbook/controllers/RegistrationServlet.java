package ru.itis.eatbook.controllers;

import ru.itis.eatbook.models.User;
import ru.itis.eatbook.services.interfaces.UsersService;
import ru.itis.eatbook.utils.HashingPassword;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/registration.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

        UsersService usersService = (UsersService) getServletContext().getAttribute("usersService");

        String password = HashingPassword.hashing(req.getParameter("password"));

        User user = User.builder()
                .name(req.getParameter("name"))
                .email(req.getParameter("email"))
                .phone(req.getParameter("phone"))
                .password(password)
                .uuid(UUID.randomUUID().toString())
                .build();

        usersService.saveUser(user);
        resp.sendRedirect("/login");
    }
}
