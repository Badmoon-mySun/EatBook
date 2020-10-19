package ru.itis.eatbook.repositories;

import ru.itis.eatbook.models.Table;
import ru.itis.eatbook.repositories.interfaces.OrganizationRepository;
import ru.itis.eatbook.repositories.interfaces.TableRepository;
import ru.itis.eatbook.repositories.mappers.RowMapper;
import ru.itis.eatbook.repositories.mappers.TableMapper;
import ru.itis.eatbook.repositories.templates.SimpleJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class TableRepositoryJdbcImpl implements TableRepository {
    private SimpleJdbcTemplate jdbcTemplate;
    private RowMapper<Table> rowMapper;

    //language=SQL
    private final String SQL_FIND_BY_ID = "SELECT * FROM `table` WHERE id = ?";
    //language=SQL
    private final String SQL_FIND_ALL_BY_ORGANIZATION = "SELECT * FROM `table` WHERE organization = ?";

    public TableRepositoryJdbcImpl(DataSource dataSource, OrganizationRepository orgRep) {
        jdbcTemplate = new SimpleJdbcTemplate(dataSource);
        rowMapper = new TableMapper(orgRep);
    }

    @Override
    public void save(Table entity) {

    }

    @Override
    public void delete(Table entity) {

    }

    @Override
    public void update(Table entity) {

    }

    @Override
    public Optional<Table> findById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_FIND_BY_ID, rowMapper, id));
    }

    @Override
    public List<Table> findAll() {
        return null;
    }

    @Override
    public List<Table> findAllTablesByOrganizationId(Long id) {
        return jdbcTemplate.queryForList(SQL_FIND_ALL_BY_ORGANIZATION, rowMapper, id);
    }
}
