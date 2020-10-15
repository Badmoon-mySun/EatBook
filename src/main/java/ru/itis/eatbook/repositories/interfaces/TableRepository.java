package ru.itis.eatbook.repositories.interfaces;

import ru.itis.eatbook.models.Table;

import java.util.List;

public interface TableRepository extends CrudRepository<Table> {
    List<Table> findAllTablesByOrganizationId(Long id);
}
