package ru.itis.eatbook.repositories.interfaces;

import ru.itis.eatbook.models.OrderTable;

import java.util.List;

public interface OrderTableRepository extends CrudRepository<OrderTable> {
    List<OrderTable> findAllOrdersByTableId(Long id);
}
