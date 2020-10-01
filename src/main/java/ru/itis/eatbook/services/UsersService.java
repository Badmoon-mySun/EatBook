package ru.itis.eatbook.services;

import com.sun.corba.se.spi.activation.Server;
import org.omg.CORBA.ServerRequest;
import ru.itis.eatbook.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<User> getAllUsers();
    void saveUser(User user);
    Optional<User> getUserById(Long id);
    Optional<User> getUserByUuid(String uuid);
    Optional<User> getUserByEmail(String email);
}
