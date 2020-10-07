package ru.itis.eatbook.repositories.mappers;

import ru.itis.eatbook.models.Discount;
import ru.itis.eatbook.models.Organization;
import ru.itis.eatbook.repositories.interfaces.OrganizationRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class DiscountMapper implements RowMapper<Discount> {
    private OrganizationRepository organizationRepository;

    // Bad practice, the mapper should not work with the repository!!!
    public DiscountMapper(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    @Override
    public Discount mapRow(ResultSet resultSet) throws SQLException {
        Optional<Organization> orgOptional =
                organizationRepository.findById(resultSet.getLong("organization"));
        Organization organization = orgOptional.orElse(null);
        return Discount.builder()
                .id(resultSet.getLong("id"))
                .organization(organization)
                .title(resultSet.getString("title"))
                .info(resultSet.getString("info"))
                .image(resultSet.getString("image"))
                .date(resultSet.getString("date"))
                .build();
    }
}
