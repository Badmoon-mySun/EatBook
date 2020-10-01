package ru.itis.eatbook.services;

import ru.itis.eatbook.dto.UserDto;
import ru.itis.eatbook.models.User;
import ru.itis.eatbook.repositories.UsersRepository;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

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

    @Override
    public void authorizeUser(User user, ServletRequest request, ServletResponse response) {
        authorizeUser(UserDto.castToUserDto(user), request, response);
    }

    @Override
    public void authorizeUser(UserDto user, ServletRequest request, ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        Cookie authCookie = new Cookie("session", user.getUuid());
        httpResponse.addCookie(authCookie);

        HttpSession session = httpRequest.getSession();
        session.setAttribute("user", user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return usersRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByUuid(String uuid) {
        return usersRepository.findByUuid(uuid);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }
}
