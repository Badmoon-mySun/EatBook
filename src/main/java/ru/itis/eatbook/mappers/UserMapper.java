package ru.itis.eatbook.mappers;

import ru.itis.eatbook.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet) throws SQLException {
        return null;
    }
}
