package ru.itis.eatbook.controllers;

import ru.itis.eatbook.models.User;
import ru.itis.eatbook.services.UsersService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ProfileEditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/pages/profile-edit.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String age = req.getParameter("age");
        String phone = req.getParameter("phone");
        String gender = req.getParameter("gender");

        UsersService usersService = (UsersService) getServletContext().getAttribute("usersService");
        User user = (User) req.getSession().getAttribute("user");

        user.setName(name);
        user.setPhone(phone);
        user.setGender(gender);
        if (age != null && !age.equals("")) {
            user.setAge(Integer.parseInt(age));
        }

        usersService.updateUser(user);

        resp.sendRedirect("/profile");
    }
}
