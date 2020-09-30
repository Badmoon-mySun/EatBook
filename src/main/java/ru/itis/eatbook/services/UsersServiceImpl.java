package ru.itis.eatbook.services;

import ru.itis.eatbook.models.User;
import ru.itis.eatbook.repositories.UsersRepository;

import java.util.List;

public class UsersServiceImpl implements UsersService {

    private UsersRepository usersRepository;

    public UsersServiceImpl(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void saveUser(User user) {
        usersRepository.save(user);
    }
}
