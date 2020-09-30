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

    public void update(String sql, Object ... args) {
        getResultSet(sql, args);
    }

    public <T> List<T> queryForList(String sql, RowMapper<T> rowMapper, Object... args) {
        try {
            List<T> result = new ArrayList<>();
            ResultSet resultSet = getResultSet(sql, args);

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

    public <T> T queryForObject(String sql, Class<T> requiredType, Object... args) {
        try {
            T result = null;
            ResultSet resultSet = getResultSet(sql, args);
            if (resultSet != null) {
                resultSet.next();
                result = resultSet.getObject(1, requiredType);
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object... args) {
        try {
            T result = null;
            ResultSet resultSet = getResultSet(sql, args);
            if (resultSet.next()) {
                result = rowMapper.mapRow(resultSet);
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private ResultSet getResultSet(String sql, Object[] args) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            int position = 1;
            for (Object arg : args) {
                preparedStatement.setObject(position, arg);
                position++;
            }
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
