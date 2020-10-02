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
    void setSession(UserDto user, ServletRequest request);
    void setCookie(UserDto user, ServletResponse response);
    UserDto authorize(String email, String password);
    void logout(ServletRequest request, ServletResponse response);
    Optional<User> getUserById(Long id);
    Optional<User> getUserByUuid(String uuid);
    Optional<User> getUserByEmail(String email);
}
