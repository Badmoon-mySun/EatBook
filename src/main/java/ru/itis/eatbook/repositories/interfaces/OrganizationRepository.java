package ru.itis.eatbook.repositories.interfaces;

import ru.itis.eatbook.models.Organization;

import java.util.List;

public interface OrganizationRepository extends CrudRepository<Organization> {
    List<Organization> findAllByNameAndType(String name, String type);
}
