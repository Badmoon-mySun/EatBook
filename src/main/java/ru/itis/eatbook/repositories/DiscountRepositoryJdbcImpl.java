package ru.itis.eatbook.repositories;

import ru.itis.eatbook.repositories.interfaces.OrganizationRepository;
import ru.itis.eatbook.repositories.mappers.DiscountMapper;
import ru.itis.eatbook.models.Discount;
import ru.itis.eatbook.repositories.interfaces.DiscountRepository;
import ru.itis.eatbook.repositories.mappers.RowMapper;
import ru.itis.eatbook.repositories.templates.SimpleJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class DiscountRepositoryJdbcImpl implements DiscountRepository {

    private RowMapper<Discount> rowMapper;
    private SimpleJdbcTemplate jdbcTemplate;

    //language=SQL
    private final String SQL_FIND_ALL = "SELECT * FROM discount";
    //language=SQL
    private final String SQL_FIND_BY_ID = "SELECT * FROM discount WHERE id = ?";
    //language=SQL
    private final String SQL_SAVE =
            "INSERT INTO discount(organization, title, info, date) VALUES (?, ?, ?, ?)";
    //language=SQL
    private  final String SQL_DELETE = "DELETE FROM discount WHERE id = ?";
    //language=SQL
    private  final String SQL_UPDATE = "UPDATE discount " +
            "SET organization = ?, title = ?, info = ?, image = ?, date = ? WHERE id = ?";

    public DiscountRepositoryJdbcImpl(DataSource dataSource, OrganizationRepository organizationRepository) {
        rowMapper = new DiscountMapper(organizationRepository);
        jdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public void save(Discount entity) {
        jdbcTemplate.update(SQL_SAVE, entity.getOrganization().getId(),
                entity.getTitle(), entity.getInfo(), entity.getDate().getTime());
    }

    @Override
    public void delete(Discount entity) {
        jdbcTemplate.update(SQL_DELETE, entity.getId());
    }

    @Override
    public void update(Discount entity) {
        jdbcTemplate.update(SQL_UPDATE, entity.getOrganization().getId(), entity.getTitle(),
                entity.getInfo(), entity.getImage(), entity.getDate().getTime(), entity.getId());
    }

    @Override
    public Optional<Discount> findById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(
                SQL_FIND_BY_ID, rowMapper, id));
    }

    @Override
    public List<Discount> findAll() {
        return jdbcTemplate.queryForList(SQL_FIND_ALL, rowMapper);
    }
}
