//package ru.itis.eatbook.repository;
//
//import ru.itis.eatbook.factory.DataSourceFactory;
//import ru.itis.eatbook.model.User;
//
//import javax.sql.DataSource;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class UserDAOImpl implements UserDAO {
//
//    private DataSource dataSource = DataSourceFactory.getMySQLDataSource();
//    private Connection connection;
//
//    public List<User> findAll() throws SQLException {
//        PreparedStatement statement = connection.prepareStatement(SQL_FIND_ALL);
//        ResultSet rs = statement.executeQuery();
//
//        return findBySomething(rs);
//    }
//
//    public User findById(Long id) throws SQLException {
//        PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_ID);
//        statement.setLong(1, id);
//        ResultSet rs = statement.executeQuery();
//
//        List<User> list = findBySomething(rs);
//
//        return !list.isEmpty() ? list.get(0) : null;
//    }
//
//    @Override
//    public User findByName(String username) throws SQLException {
//        PreparedStatement statement = connection.prepareStatement(SQL_FIND_BY_NAME);
//        statement.setString(1, username);
//        ResultSet rs = statement.executeQuery();
//
//        List<User> list = findBySomething(rs);
//
//        return !list.isEmpty() ? list.get(0) : null;
//    }
//
//    private List<User> findBySomething(ResultSet resultSet) throws SQLException {
//        List<User> result = new ArrayList<User>();
//
//        connection = dataSource.getConnection();
//
//        if (resultSet.next()) {
//            User user = new User();
//            user.setId(resultSet.getLong(User.ID_COLUMN));
//            user.setUsername(resultSet.getString(User.NAME_COLUMN));
//            user.setPassword(resultSet.getString(User.PASSWORD_COLUMN));
//
//            result.add(user);
//        }
//
//        connection.close();
//
//        return result;
//    }
//
//    public void insert(User item) {
//
//    }
//
//    public void update(User item) throws SQLException {
//        throw new SQLException("Looool");
//    }
//
//    public void delete(User item) throws SQLException {
//        throw new SQLException("Looool");
//    }
//}
