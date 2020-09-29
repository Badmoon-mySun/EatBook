package ru.itis.eatbook.repository;

import ru.itis.eatbook.mappers.UserMapper;
import ru.itis.eatbook.model.User;
import ru.itis.eatbook.utils.SimpleJdbcTemplate;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private SimpleJdbcTemplate jdbcTemplate;
    private Connection connection;

    //language=SQL
    private final String FIND_ALL = "SELECT * FROM USER";
    //language=SQL
    private final String FIND_BY_ID = "SELECT * FROM USER WHERE id = ?";
    //language=SQL
    private final String FIND_BY_EMAIL = "SELECT * FROM USER WHERE email = ?";

    public UsersRepositoryJdbcImpl(Connection connection) {
        jdbcTemplate = new SimpleJdbcTemplate(connection);
        this.connection = connection;
    }

    @Override
    public void save(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, new UserMapper(), id));
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.queryForList(FIND_ALL, new UserMapper());
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_EMAIL, new UserMapper(), email));
    }
}
