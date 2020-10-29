package ru.itis.eatbook.repositories.mappers;

import ru.itis.eatbook.models.OrderTable;
import ru.itis.eatbook.models.Table;
import ru.itis.eatbook.models.User;
import ru.itis.eatbook.repositories.interfaces.TableRepository;
import ru.itis.eatbook.repositories.interfaces.UsersRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.Optional;

public class OrderTableMapper implements RowMapper<OrderTable> {
    private TableRepository tableRepository;
    private  UsersRepository usersRepository;

    // Bad practice, the mapper should not work with the repository!!!
    public OrderTableMapper(TableRepository tableRepository, UsersRepository usersRepository) {
        this.tableRepository = tableRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public OrderTable mapRow(ResultSet resultSet) throws SQLException {
        Optional<Table> optionalTable = tableRepository.findById(resultSet.getLong("table"));
        Optional<User> optionalUser = usersRepository.findById(resultSet.getLong("user"));

        return OrderTable.builder()
                .id(resultSet.getLong("id"))
                .table(optionalTable.orElse(null))
                .user(optionalUser.orElse(null))
                .dateOf(new Date(resultSet.getLong("dateOf")))
                .dateTo(new Date(resultSet.getLong("dateTo")))
                .prise(resultSet.getInt("prise"))
                .build();
    }

}
