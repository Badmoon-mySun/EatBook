package ru.itis.eatbook.services;

import ru.itis.eatbook.models.User;

import java.util.List;

public interface UsersService {
    List<User> getAllUsers();
    void saveUser(User user);
//    List<UserDto> getAllUser(int page, int size);
//    void addUser(UserDto userDto);
}
