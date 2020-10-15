package ru.itis.eatbook.services.interfaces;

import ru.itis.eatbook.models.OrderTable;

import java.util.List;

public interface OrderTablesService {
    List<OrderTable> getTablesByOrganizationId(Long id);
}
