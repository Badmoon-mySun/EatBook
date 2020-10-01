package ru.itis.eatbook.repositories;

import ru.itis.eatbook.mappers.UserMapper;
import ru.itis.eatbook.models.User;
import ru.itis.eatbook.utils.SimpleJdbcTemplate;

import javax.sql.DataSource;
import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private SimpleJdbcTemplate jdbcTemplate;

    //language=SQL
    private final String FIND_ALL = "SELECT * FROM USER";
    //language=SQL
    private final String FIND_BY_ID = "SELECT * FROM USER WHERE id = ?";
    //language=SQL
    private final String FIND_BY_EMAIL = "SELECT * FROM USER WHERE email = ?";
    //language=SQL
    private final String FIND_BY_UUID = "SELECT * FROM USER WHERE uuid = ?";
    //language=Sql
    private final String SAVE = "INSERT INTO user(name, avatar, age, email,phone, password, uuid) VALUES (?, ?, ?, ?, ?, ?, ?)";

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        jdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update(SAVE, entity.getName(), entity.getAvatar(),
                entity.getAge(), entity.getEmail(), entity.getPhone(),
                entity.getPassword(), entity.getUuid());
    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.queryForList(FIND_ALL, new UserMapper());
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_ID, new UserMapper(), id));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_EMAIL, new UserMapper(), email));
    }

    @Override
    public Optional<User> findByUuid(String uuid) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_UUID, new UserMapper(), uuid));
    }
}
