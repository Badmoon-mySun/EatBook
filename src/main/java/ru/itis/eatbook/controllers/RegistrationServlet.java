package ru.itis.eatbook.controllers;

import ru.itis.eatbook.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("uri", req.getRequestURI());
        req.getRequestDispatcher("/WEB-INF/pages/registration.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] bytes = md5.digest(req.getParameter("password").getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b : bytes) {
                builder.append(String.format("%02X", b));
            }

            System.out.println(builder.toString());

            User user = User.builder()
                    .name(req.getParameter("name"))
                    .email(req.getParameter("email"))
                    .phone(req.getParameter("phone"))
                    .password(builder.toString())
                    .build();

        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException(e);
        }


    }
}
