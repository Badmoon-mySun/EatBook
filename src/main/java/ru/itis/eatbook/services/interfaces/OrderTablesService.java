package ru.itis.eatbook.services.interfaces;

import ru.itis.eatbook.models.OrderTable;

import java.util.List;

public interface OrderTablesService {
    List<OrderTable> getAllOrdersByTableId(Long id);

    void newOrderTable(OrderTable orderTable);
}
