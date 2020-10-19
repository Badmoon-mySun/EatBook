package ru.itis.eatbook.services;

import ru.itis.eatbook.models.Table;
import ru.itis.eatbook.repositories.interfaces.TableRepository;
import ru.itis.eatbook.services.interfaces.TablesService;

import java.util.List;
import java.util.Optional;

public class TablesServiceImpl implements TablesService {
    private TableRepository repository;

    public TablesServiceImpl(TableRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Table> getAllTablesByOrganizationId(Long id) {
        return repository.findAllTablesByOrganizationId(id);
    }

    @Override
    public Optional<Table> getTableById(Long id) {
        return repository.findById(id);
    }
}
