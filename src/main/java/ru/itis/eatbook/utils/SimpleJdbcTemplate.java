package ru.itis.eatbook.utils;

import ru.itis.eatbook.mappers.RowMapper;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SimpleJdbcTemplate {
    private DataSource dataSource;

    public SimpleJdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void update(String sql, Object ... args) {
        try {
            preparedStatementWithArgs(sql, args).executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public <T> List<T> queryForList(String sql, RowMapper<T> rowMapper, Object... args) {
        try {
            List<T> result = new ArrayList<>();
            PreparedStatement preparedStatement = preparedStatementWithArgs(sql, args);
            ResultSet resultSet = preparedStatement.executeQuery();

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
            PreparedStatement preparedStatement = preparedStatementWithArgs(sql, args);
            ResultSet resultSet = preparedStatement.executeQuery();
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
            PreparedStatement preparedStatement = preparedStatementWithArgs(sql, args);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                result = rowMapper.mapRow(resultSet);
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private PreparedStatement preparedStatementWithArgs(String sql, Object[] args) {
        try {
            PreparedStatement preparedStatement = dataSource.getConnection().prepareStatement(sql);
            int position = 1;
            for (Object arg : args) {
                preparedStatement.setObject(position, arg);
                position++;
            }
            return preparedStatement;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
