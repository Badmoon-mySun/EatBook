package ru.itis.eatbook.utils;

import ru.itis.eatbook.mappers.RowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleJdbcTemplate {
    private Connection connection;

    public SimpleJdbcTemplate(Connection connection) {
        this.connection = connection;
    }

    public <T> List<T> queryForList(String sql, RowMapper<T> rowMapper, Object... args) {
        try {
            List<T> result = new ArrayList<>();;
            ResultSet resultSet;

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int position = 1;
            for (Object arg : args) {
                preparedStatement.setObject(position, arg);
                position++;
            }
            resultSet = preparedStatement.executeQuery();

            if (resultSet != null) {
                while (resultSet.next()) {
                    result.add(rowMapper.mapRow(resultSet));
                }
            }

            return result;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
