package ru.itis.eatbook.repositories;

import ru.itis.eatbook.mappers.UserMapper;
import ru.itis.eatbook.models.User;
import ru.itis.eatbook.utils.SimpleJdbcTemplate;

import javax.sql.DataSource;
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
    //language=SQL
    private final String SAVE = "INSERT INTO user(name, email, phone, password, uuid) VALUES (?, ?, ?, ?, ?)";
    //language=SQL
    private  final String DELETE = "DELETE FROM user WHERE id = ?";
    //language=SQL
    private  final String UPDATE = "UPDATE user " +
            "SET name = ?, avatar = ?, age = ?, gender = ?, email = ?, phone = ?, password = ?, uuid = ? WHERE id = ?";

    public UsersRepositoryJdbcImpl(DataSource dataSource) {
        jdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public void save(User entity) {
        jdbcTemplate.update(SAVE, entity.getName(), entity.getEmail(),
                entity.getPhone(), entity.getPassword(), entity.getUuid());
    }

    @Override
    public void delete(User entity) {
        jdbcTemplate.update(DELETE, entity.getId());
    }

    @Override
    public void update(User entity) {
        jdbcTemplate.update(UPDATE, entity.getName(), entity.getAvatar(), entity.getAge(), entity.getGender(),
                entity.getEmail(), entity.getPhone(), entity.getPassword(), entity.getUuid(), entity.getId());
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
