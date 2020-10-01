package ru.itis.eatbook.repositories;

import ru.itis.eatbook.models.User;

import java.util.Optional;

public interface UsersRepository extends CrudRepository<User> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUuid(String uuid);
}
