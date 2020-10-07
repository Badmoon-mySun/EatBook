package ru.itis.eatbook.controllers;

import ru.itis.eatbook.models.User;
import ru.itis.eatbook.services.interfaces.FileService;
import ru.itis.eatbook.services.interfaces.UsersService;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.util.UUID;

@MultipartConfig
public class UserAvatarUploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Part part = req.getPart("avatar");
        String filename = UUID.randomUUID().toString() + part.getSubmittedFileName();

        FileService fileService =
                (FileService) getServletContext().getAttribute("fileService");

        String path = (String) getServletContext().getAttribute("IMAGE_DIR");

        fileService.upload(part, path, filename);

        UsersService usersService = (UsersService) getServletContext().getAttribute("usersService");
        User user = (User) req.getSession().getAttribute("user");
        user.setAvatar(filename);
        usersService.updateUser(user);

        resp.sendRedirect("/profile");
    }
}
