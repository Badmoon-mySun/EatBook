package ru.itis.eatbook.repositories.interfaces;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    void save(T entity);
    void delete(T entity);
    void update(T entity);
    Optional<T> findById(Long id);
    List<T> findAll();
}
