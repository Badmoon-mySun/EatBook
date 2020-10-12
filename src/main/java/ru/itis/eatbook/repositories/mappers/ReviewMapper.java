package ru.itis.eatbook.repositories.mappers;

import ru.itis.eatbook.models.Organization;
import ru.itis.eatbook.models.Review;
import ru.itis.eatbook.models.Table;
import ru.itis.eatbook.models.User;
import ru.itis.eatbook.repositories.interfaces.OrganizationRepository;
import ru.itis.eatbook.repositories.interfaces.UsersRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class ReviewMapper implements RowMapper<Review> {
    private OrganizationRepository organizationRepository;
    private UsersRepository usersRepository;

    // Bad practice, the mapper should not work with the repository!!!
    public ReviewMapper(OrganizationRepository organizationRepository, UsersRepository usersRepository) {
        this.organizationRepository = organizationRepository;
        this.usersRepository = usersRepository;
    }

    @Override
    public Review mapRow(ResultSet resultSet) throws SQLException {
        Optional<Organization> optionalOrganization =
                organizationRepository.findById(resultSet.getLong("organization"));
        Optional<User> optionalUser = usersRepository.findById(resultSet.getLong("user"));

        return Review.builder()
                .id(resultSet.getLong("id"))
                .user(optionalUser.orElse(null))
                .organization(optionalOrganization.orElse(null))
                .text(resultSet.getString("text"))
                .date(resultSet.getString("date"))
                .build();
    }
}
