package ru.itis.eatbook.controller;

import lombok.SneakyThrows;
import ru.itis.eatbook.dao.UserDAOImpl;
import ru.itis.eatbook.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/jsp/LoginPage.jsp").forward(req, resp);
    }

    @SneakyThrows
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println(username + " " + password);

        PrintWriter printWriter = resp.getWriter();

        UserDAOImpl userDAO = new UserDAOImpl();
        User user = userDAO.findByName(username);

        if (user != null) {
            if (user.getPassword().equals(password)) {
                printWriter.write("SUCCESS");
                req.getSession().setAttribute("user", user);
            } else {
                printWriter.write("PASSWORD DONT RIGHT");
            }
        } else {
            printWriter.write("USER DONT FOUND");
        }
    }
}