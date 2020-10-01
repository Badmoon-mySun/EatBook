package ru.itis.eatbook.services;

import com.sun.corba.se.spi.activation.Server;
import org.omg.CORBA.ServerRequest;
import ru.itis.eatbook.dto.UserDto;
import ru.itis.eatbook.models.User;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.List;
import java.util.Optional;

public interface UsersService {
    List<User> getAllUsers();
    void saveUser(User user);
    void authorizeUser(User user, ServletRequest request, ServletResponse response);
    void authorizeUser(UserDto userdto, ServletRequest request, ServletResponse response);
    Optional<User> getUserById(Long id);
    Optional<User> getUserByUuid(String uuid);
    Optional<User> getUserByEmail(String email);
}
