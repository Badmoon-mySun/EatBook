package ru.itis.eatbook.repositories;

import ru.itis.eatbook.models.Review;
import ru.itis.eatbook.repositories.interfaces.OrganizationRepository;
import ru.itis.eatbook.repositories.interfaces.ReviewRepository;
import ru.itis.eatbook.repositories.interfaces.UsersRepository;
import ru.itis.eatbook.repositories.mappers.ReviewMapper;
import ru.itis.eatbook.repositories.mappers.RowMapper;
import ru.itis.eatbook.repositories.templates.SimpleJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class ReviewRepositoryJdbcImpl implements ReviewRepository {
    private SimpleJdbcTemplate jdbcTemplate;
    private RowMapper<Review> rowMapper;

    //language=SQL
    private final String SQL_FIND_ALL = "SELECT * FROM review";
    //language=SQL
    private final String SQL_FIND_BY_ID = "SELECT * FROM review WHERE id = ?";
    //language=SQL
    private final String SQL_SAVE =
            "INSERT INTO review(user, organization, text, date) VALUES (?, ?, ?, ?)";
    //language=SQL
    private  final String SQL_DELETE = "DELETE FROM review WHERE id = ?";
    //language=SQL
    private  final String SQL_UPDATE = "UPDATE review " +
            "SET user = ?, organization = ?, text = ?, date = ? WHERE id = ?";
    //language=SQL
    private final String SQL_FIND_BY_ORGANIZATION_ID = "SELECT * FROM review WHERE organization = ?";

    public ReviewRepositoryJdbcImpl(DataSource dataSource, OrganizationRepository orgRep, UsersRepository userRep) {
        jdbcTemplate = new SimpleJdbcTemplate(dataSource);
        rowMapper = new ReviewMapper(orgRep, userRep);
    }

    @Override
    public void save(Review entity) {
        jdbcTemplate.update(SQL_SAVE, entity.getUser().getId(),
                entity.getOrganization().getId(), entity.getText(), entity.getDate());
    }

    @Override
    public void delete(Review entity) {
        jdbcTemplate.update(SQL_DELETE, entity.getId());
    }

    @Override
    public void update(Review entity) {
        jdbcTemplate.update(SQL_UPDATE, entity.getUser().getId(),
                entity.getOrganization().getId(), entity.getText(), entity.getDate(), entity.getId());
    }

    @Override
    public Optional<Review> findById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_FIND_BY_ID, rowMapper, id));
    }

    @Override
    public List<Review> findReviewsByOrganizationId(Long id) {
        return jdbcTemplate.queryForList(SQL_FIND_BY_ORGANIZATION_ID, rowMapper,id);
    }

    @Override
    public List<Review> findAll() {
        return jdbcTemplate.queryForList(SQL_FIND_ALL, rowMapper);
    }
}
