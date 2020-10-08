package ru.itis.eatbook.repositories;

import ru.itis.eatbook.models.Organization;
import ru.itis.eatbook.repositories.interfaces.OrganizationRepository;
import ru.itis.eatbook.repositories.mappers.OrganizationMapper;
import ru.itis.eatbook.repositories.templates.SimpleJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class OrganizationRepositoryJdbcImpl implements OrganizationRepository {
    private SimpleJdbcTemplate jdbcTemplate;

    //language=SQL
    private final String SQL_FIND_ALL = "SELECT * FROM USER";
    //language=SQL
    private final String SQL_FIND_BY_ID = "SELECT * FROM organization WHERE id = ?";
    //language=SQL
    private final String SQL_SAVE =
            "INSERT INTO organization(name, type, address, image, description) VALUES (?, ?, ?, ?, ?)";
    //language=SQL
    private  final String SQL_DELETE = "DELETE FROM organization WHERE id = ?";
    //language=SQL
    private  final String SQL_UPDATE = "UPDATE organization " +
            "SET name = ?, type = ?, address = ?, image = ?, description = ? WHERE id = ?";


    public OrganizationRepositoryJdbcImpl(DataSource dataSource) {
        jdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public void save(Organization entity) {
        jdbcTemplate.update(SQL_SAVE, entity.getName(), entity.getType(),
                entity.getAddress(), entity.getImage(), entity.getDescription());
    }

    @Override
    public void delete(Organization entity) {
        jdbcTemplate.update(SQL_DELETE, entity.getId());
    }

    @Override
    public void update(Organization entity) {
        jdbcTemplate.update(SQL_UPDATE, entity.getName(), entity.getType(),
                entity.getAddress(), entity.getImage(), entity.getDescription(), entity.getId());
    }

    @Override
    public Optional<Organization> findById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new OrganizationMapper(), id));
    }

    @Override
    public List<Organization> findAll() {
        return jdbcTemplate.queryForList(SQL_FIND_ALL,  new OrganizationMapper());
    }
}
