package ru.itis.eatbook.repositories.mappers;

import ru.itis.eatbook.models.Organization;
import ru.itis.eatbook.models.Table;
import ru.itis.eatbook.models.User;
import ru.itis.eatbook.repositories.interfaces.OrganizationRepository;
import ru.itis.eatbook.repositories.interfaces.UsersRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class TableMapper implements RowMapper<Table> {
    private OrganizationRepository organizationRepository;
    private UsersRepository usersRepository;

    // Bad practice, the mapper should not work with the repository!!!
    public TableMapper(OrganizationRepository organizationRepository, UsersRepository usersRepository) {
        this.organizationRepository = organizationRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public Table mapRow(ResultSet resultSet) throws SQLException {
        Optional<Organization> optionalOrganization =
                organizationRepository.findById(resultSet.getLong("organization"));
        Optional<User> optionalUser = usersRepository.findById(resultSet.getLong("user"));

        return Table.builder()
                .id(resultSet.getLong("id"))
                .organization(optionalOrganization.orElse(null))
                .user(optionalUser.orElse(null))
                .number(resultSet.getInt("number"))
                .seats(resultSet.getInt("seats"))
                .dateOf(resultSet.getString("date_of"))
                .dateTo(resultSet.getString("date_to"))
                .prise(resultSet.getInt("prise"))
                .build();
    }
}
