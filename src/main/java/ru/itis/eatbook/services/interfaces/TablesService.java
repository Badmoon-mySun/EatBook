package ru.itis.eatbook.services.interfaces;

import ru.itis.eatbook.models.Table;

import java.util.List;
import java.util.Optional;

public interface TablesService {
    List<Table> getAllTablesByOrganizationId(Long id);

    Optional<Table> getTableById(Long id);
}
