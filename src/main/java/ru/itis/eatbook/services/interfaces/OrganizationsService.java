package ru.itis.eatbook.services.interfaces;

import ru.itis.eatbook.models.Organization;

import java.util.List;
import java.util.Optional;

public interface OrganizationsService {
    Optional<Organization> getOrganizationById(Long id);

    List<Organization> getAllOrganization();

    List<Organization> getOrganizationsByName(String name, String type);

    void updateOrganization(Organization organization);

    void deleteOrganization(Organization organization);

    void saveOrganization(Organization organization);
}
