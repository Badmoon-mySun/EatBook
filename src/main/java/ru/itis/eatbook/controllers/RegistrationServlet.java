package ru.itis.eatbook.controllers;

import ru.itis.eatbook.models.User;
import ru.itis.eatbook.services.HashingPasswordService;
import ru.itis.eatbook.services.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("uri", req.getRequestURI());
        req.getRequestDispatcher("/WEB-INF/pages/registration.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        UsersService usersService = (UsersService) getServletContext().getAttribute("usersService");

        HashingPasswordService hashPassword =
                (HashingPasswordService) getServletContext().getAttribute("hashingPassword");
        String password = hashPassword.hashing(req.getParameter("password"));

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
