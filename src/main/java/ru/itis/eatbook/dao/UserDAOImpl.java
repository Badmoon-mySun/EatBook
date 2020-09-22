package ru.itis.eatbook.dao;

import ru.itis.eatbook.factory.DataSourceFactory;
import ru.itis.eatbook.model.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    DataSource dataSource;

    {
        try {
            dataSource = DataSourceFactory.getMySQLDataSource();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> findAll() throws SQLException {
        List<User> result = new ArrayList<User>();
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong(User.ID_COLUMN));
                user.setUsername(rs.getString(User.NAME_COLUMN));
                result.add(user);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return result;
    }

    public User findById(Long id) throws SQLException {
        User user = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getLong(User.ID_COLUMN));
                user.setUsername(rs.getString(User.NAME_COLUMN));
                user.setPassword(rs.getString(User.PASSWORD_COLUMN));
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return user;
    }

    @Override
    public User findByName(String username) throws SQLException {
        User user = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getLong(User.ID_COLUMN));
                user.setUsername(rs.getString(User.NAME_COLUMN));
                user.setPassword(rs.getString(User.PASSWORD_COLUMN));
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
        return user;
    }
    private User buildUser(ResultSet resultSet) throws SQLException {
        User user = null;
        if (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getLong(User.ID_COLUMN));
            user.setUsername(resultSet.getString(User.NAME_COLUMN));
            user.setPassword(resultSet.getString(User.PASSWORD_COLUMN));
        }

        return user;
    }

    public void insert(User item) {

    }

    public void update(User item) throws SQLException {
        throw new SQLException("Looool");
    }

    public void delete(User item) throws SQLException {
        throw new SQLException("Looool");
    }
}
