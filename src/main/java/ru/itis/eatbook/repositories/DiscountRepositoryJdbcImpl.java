package ru.itis.eatbook.repositories;

import ru.itis.eatbook.repositories.interfaces.OrganizationRepository;
import ru.itis.eatbook.repositories.interfaces.UsersRepository;
import ru.itis.eatbook.repositories.mappers.DiscountMapper;
import ru.itis.eatbook.repositories.mappers.UserMapper;
import ru.itis.eatbook.models.Discount;
import ru.itis.eatbook.repositories.interfaces.DiscountRepository;
import ru.itis.eatbook.repositories.templates.SimpleJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class DiscountRepositoryJdbcImpl implements DiscountRepository {

    private OrganizationRepository organizationRepository;
    private SimpleJdbcTemplate jdbcTemplate;

    //language=SQL
    private final String SQL_FIND_ALL = "SELECT * FROM discount";
    //language=SQL
    private final String SQL_FIND_BY_ID = "SELECT * FROM discount WHERE id = ?";
    //language=SQL
    private final String SQL_SAVE =
            "INSERT INTO discount(organisation_id, title, info, image, date) VALUES (?, ?, ?, ?, ?)";


    public DiscountRepositoryJdbcImpl(DataSource dataSource) {
        organizationRepository = new OrganizationRepositoryJdbcImpl(dataSource);
        jdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public void save(Discount entity) {
        jdbcTemplate.update(SQL_SAVE, entity.getOrganization().getId(),
                entity.getTitle(), entity.getInfo(), entity.getImage(), entity.getDate());
    }

    @Override
    public void delete(Discount entity) {

    }

    @Override
    public void update(Discount entity) {

    }

    @Override
    public Optional<Discount> findById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(
                SQL_FIND_BY_ID, new DiscountMapper(organizationRepository)));
    }

    @Override
    public List<Discount> findAll() {
        return jdbcTemplate.queryForList(SQL_FIND_ALL, new DiscountMapper(organizationRepository));
    }
}
