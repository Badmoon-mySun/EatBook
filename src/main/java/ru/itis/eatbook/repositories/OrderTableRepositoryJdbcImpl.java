package ru.itis.eatbook.repositories;

import ru.itis.eatbook.models.OrderTable;
import ru.itis.eatbook.repositories.interfaces.OrderTableRepository;
import ru.itis.eatbook.repositories.interfaces.OrganizationRepository;
import ru.itis.eatbook.repositories.interfaces.TableRepository;
import ru.itis.eatbook.repositories.interfaces.UsersRepository;
import ru.itis.eatbook.repositories.mappers.OrderTableMapper;
import ru.itis.eatbook.repositories.mappers.RowMapper;
import ru.itis.eatbook.repositories.templates.SimpleJdbcTemplate;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class OrderTableRepositoryJdbcImpl implements OrderTableRepository {
    private RowMapper<OrderTable> rowMapper;
    private SimpleJdbcTemplate jdbcTemplate;

    //language=SQL
    private final String SQL_FIND_BY_ID = "SELECT * FROM ordertable WHERE id = ?";
    //language=SQL
    private final String SQL_FIND_ALL_BY_TABLE_ID = "SELECT * FROM ordertable WHERE `table` = ?";

    public OrderTableRepositoryJdbcImpl(DataSource dataSource, TableRepository tableRep, UsersRepository userRep) {
        rowMapper = new OrderTableMapper(tableRep, userRep);
        jdbcTemplate = new SimpleJdbcTemplate(dataSource);
    }

    @Override
    public void save(OrderTable entity) {

    }

    @Override
    public void delete(OrderTable entity) {

    }

    @Override
    public void update(OrderTable entity) {

    }

    @Override
    public Optional<OrderTable> findById(Long id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject(SQL_FIND_BY_ID, rowMapper, id));
    }

    @Override
    public List<OrderTable> findAll() {
        return null;
    }

    @Override
    public List<OrderTable> findAllOrdersByTableId(Long id) {
        return jdbcTemplate.queryForList(SQL_FIND_ALL_BY_TABLE_ID, rowMapper, id);
    }
}
