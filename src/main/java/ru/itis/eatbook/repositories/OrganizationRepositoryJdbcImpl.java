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
    private final String SQL_FIND_BY_ID = "SELECT * FROM organization WHERE id = ?";

    public OrganizationRepositoryJdbcImpl(DataSource dataSource) {
        jdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public void save(Organization entity) {

    }

    @Override
    public void delete(Organization entity) {

    }

    @Override
    public void update(Organization entity) {

    }

    @Override
    public Optional<Organization> findById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_FIND_BY_ID, new OrganizationMapper(), id));
    }

    @Override
    public List<Organization> findAll() {
        return null;
    }
}
