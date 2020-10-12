package ru.itis.eatbook.repositories;

import ru.itis.eatbook.models.Table;
import ru.itis.eatbook.repositories.interfaces.TableRepository;

import java.util.List;
import java.util.Optional;

public class TableRepositoryJdbcImpl implements TableRepository {
    @Override
    public void save(Table entity) {

    }

    @Override
    public void delete(Table entity) {

    }

    @Override
    public void update(Table entity) {

    }

    @Override
    public Optional<Table> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Table> findAll() {
        return null;
    }
}
