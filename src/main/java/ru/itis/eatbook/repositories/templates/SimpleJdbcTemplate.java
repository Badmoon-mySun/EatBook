package ru.itis.eatbook.repositories.templates;

import ru.itis.eatbook.repositories.mappers.RowMapper;

import javax.sql.DataSource;
import java.sql.Connection;
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

    public int update(String sql, Object ... args) {
        try (Connection connection = dataSource.getConnection()) {
            PreparedStatement statement = preparedStatementWithArgs(connection, sql, args);
            return statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    public <T> List<T> queryForList(String sql, RowMapper<T> rowMapper, Object... args) {
        try (Connection connection = dataSource.getConnection()) {
            List<T> result = new ArrayList<>();
            PreparedStatement statement = preparedStatementWithArgs(connection, sql, args);
            ResultSet resultSet = statement.executeQuery();

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

    public <T> T queryForObject(String sql, RowMapper<T> rowMapper, Object... args) {
        try (Connection connection = dataSource.getConnection()) {
            T result = null;
            PreparedStatement statement = preparedStatementWithArgs(connection, sql, args);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                result = rowMapper.mapRow(resultSet);
            }
            return result;
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }

    private PreparedStatement preparedStatementWithArgs(Connection connection, String sql, Object[] args) {
        PreparedStatement preparedStatement;

        try {
            preparedStatement = connection.prepareStatement(sql);

            int position = 1;
            for (Object arg : args) {
                preparedStatement.setObject(position, arg);
                position++;
            }
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
        return preparedStatement;
    }
}
