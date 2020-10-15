package ru.itis.eatbook.services.interfaces;

import ru.itis.eatbook.models.Table;

import java.util.List;

public interface TablesService {
    List<Table> getAllTablesByOrganizationId(Long id);
}
