package ru.itis.eatbook.services.interfaces;

import ru.itis.eatbook.models.User;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<User> getAllUsers();
    void saveUser(User user);
    void updateUser(User user);
    Optional<User> getUserById(Long id);
    Optional<User> getUserByUuid(String uuid);
    Optional<User> getUserByEmail(String email);
    User authorize(String email, String password);
    void logout(ServletRequest request, ServletResponse response);
    void setSession(User user, ServletRequest request);
    void setCookie(User user, ServletResponse response);
}
