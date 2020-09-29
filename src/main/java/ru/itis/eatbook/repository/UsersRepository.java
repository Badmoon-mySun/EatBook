package ru.itis.eatbook.repository;

import ru.itis.eatbook.model.User;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User> {
    Optional<User> findByEmail(String email);
}
