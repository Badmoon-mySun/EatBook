package ru.itis.eatbook.services;

import ru.itis.eatbook.models.OrderTable;
import ru.itis.eatbook.repositories.interfaces.OrderTableRepository;
import ru.itis.eatbook.services.interfaces.OrderTablesService;

import java.util.List;

public class OrderTablesServiceImpl implements OrderTablesService {
    private OrderTableRepository repository;

    public OrderTablesServiceImpl(OrderTableRepository repository) {
        this.repository = repository;
    }

    public List<OrderTable> getAllOrdersByTableId(Long id) {
        return repository.findAllOrdersByTableId(id);
    }
}
