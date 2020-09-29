package ru.itis.eatbook.controller;

import ru.itis.eatbook.factory.DataSourceFactory;
import ru.itis.eatbook.model.User;
import ru.itis.eatbook.repository.UsersRepositoryJdbcImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@WebServlet("/newhome")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter writer = resp.getWriter();
        DataSource dataSource = DataSourceFactory.getMySQLDataSource();
        UsersRepositoryJdbcImpl usersRep;

        try {
            usersRep = new UsersRepositoryJdbcImpl(dataSource.getConnection());
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }

        Optional<User> optionalUser = usersRep.findByEmail("anvar00755@mail.ruq");
        User user = new User();
        if (optionalUser.isPresent()) {
            user = optionalUser.get();
        }
        writer.print(user.getName() + "12");
        writer.println("13");
        writer.print("14");
        writer.print("15");

        List<User> users = usersRep.findAll();
        for (User user1 : users) {
            writer.print(user1.getName() + " - ");
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
