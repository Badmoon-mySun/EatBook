package ru.itis.eatbook.repositories.mappers;

import ru.itis.eatbook.models.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet) throws SQLException {
        return User.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .avatar(resultSet.getString("avatar"))
                .age(resultSet.getInt("age"))
                .email(resultSet.getString("email"))
                .phone(resultSet.getString("phone"))
                .password(resultSet.getString("password"))
                .uuid(resultSet.getString("uuid"))
                .build();
    }
}
