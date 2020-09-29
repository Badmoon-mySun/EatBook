package ru.itis.eatbook.repository;

import ru.itis.eatbook.model.User;

import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcImpl implements UsersRepository {
    @Override
    public void save(User entity) {

    }

    @Override
    public void delete(User entity) {

    }

    @Override
    public void update(User entity) {

    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
