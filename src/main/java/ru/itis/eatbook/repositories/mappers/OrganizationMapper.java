package ru.itis.eatbook.repositories.mappers;

import ru.itis.eatbook.models.Organization;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrganizationMapper implements RowMapper<Organization> {

    @Override
    public Organization mapRow(ResultSet resultSet) throws SQLException {
        return Organization.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .type(resultSet.getString("type"))
                .address(resultSet.getString("address"))
                .image(resultSet.getString("image"))
                .description(resultSet.getString("description"))
                .build();
    }
}
