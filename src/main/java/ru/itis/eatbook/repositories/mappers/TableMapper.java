package ru.itis.eatbook.repositories.mappers;

import ru.itis.eatbook.models.Organization;
import ru.itis.eatbook.models.Table;
import ru.itis.eatbook.repositories.interfaces.OrganizationRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class TableMapper implements RowMapper<Table> {
    private OrganizationRepository organizationRepository;

    // Bad practice, the mapper should not work with the repository!!!
    public TableMapper(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Table mapRow(ResultSet resultSet) throws SQLException {
        Optional<Organization> optionalOrganization =
                organizationRepository.findById(resultSet.getLong("organization"));

        return Table.builder()
                .id(resultSet.getLong("id"))
                .organization(optionalOrganization.orElse(null))
                .number(resultSet.getInt("number"))
                .seats(resultSet.getInt("seats"))
                .prise(resultSet.getInt("prise"))
                .build();
    }
}
