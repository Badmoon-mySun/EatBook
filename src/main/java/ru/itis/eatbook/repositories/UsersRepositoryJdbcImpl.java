package ru.itis.eatbook.repositories;

import ru.itis.eatbook.repositories.mappers.RowMapper;
import ru.itis.eatbook.repositories.mappers.UserMapper;
import ru.itis.eatbook.models.User;
import ru.itis.eatbook.repositories.interfaces.UsersRepository;
import ru.itis.eatbook.repositories.templates.SimpleJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {

    private SimpleJdbcTemplate jdbcTemplate;
    private RowMapper<User> rowMapper;

    //language=SQL
    private final String SQL_FIND_ALL = "SELECT * FROM USER";
    //language=SQL
    private final String SQL_FIND_BY_ID = "SELECT * FROM USER WHERE id = ?";
    //language=SQL
    private final String SQL_FIND_BY_EMAIL = "SELECT * FROM USER WHERE email = ?";
    //language=SQL
    private final String SQL_FIND_BY_UUID = "SELECT * FROM USER WHERE uuid = ?";
    //language=SQL
    private final String SQL_SAVE = "INSERT INTO user(name, email, phone, password, uuid) VALUES (?, ?, ?, ?, ?)";
    //language=SQL
    private  final String SQL_DELETE = "DELETE FROM user WHERE id = ?";
    //language=SQL
    private  final String SQL_UPDATE = "UPDATE user " +
            "SET name = ?, avatar = ?, age = ?, gender = ?, email = ?, phone = ?, password = ?, uuid = ? WHERE id = ?";

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        jdbcTemplate = new SimpleJdbcTemplate(dataSource);
        rowMapper = new UserMapper();
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update(SQL_SAVE, entity.getName(), entity.getEmail(),
                entity.getPhone(), entity.getPassword(), entity.getUuid());
    }

    @Override
    public void delete(User entity) {
        jdbcTemplate.update(SQL_DELETE, entity.getId());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update(SQL_UPDATE, entity.getName(), entity.getAvatar(), entity.getAge(), entity.getGender(),
                entity.getEmail(), entity.getPhone(), entity.getPassword(), entity.getUuid(), entity.getId());
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.queryForList(SQL_FIND_ALL, rowMapper);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_FIND_BY_ID, rowMapper, id));
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_FIND_BY_EMAIL, rowMapper, email));
    }

    @Override
    public Optional<User> findByUuid(String uuid) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_FIND_BY_UUID, rowMapper, uuid));
    }
}
