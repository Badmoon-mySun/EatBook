package ru.itis.eatbook.services;

import ru.itis.eatbook.models.Organization;
import ru.itis.eatbook.repositories.interfaces.OrganizationRepository;
import ru.itis.eatbook.services.interfaces.OrganizationsService;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class OrganizationServiceImpl implements OrganizationsService {
    private OrganizationRepository repository;

    public OrganizationServiceImpl(OrganizationRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Organization> getOrganizationById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Organization> getAllOrganization() {
        return repository.findAll();
    }
}
