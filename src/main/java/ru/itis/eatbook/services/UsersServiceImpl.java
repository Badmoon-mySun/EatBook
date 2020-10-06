package ru.itis.eatbook.services;

import ru.itis.eatbook.models.User;
import ru.itis.eatbook.repositories.UsersRepository;
import ru.itis.eatbook.utils.HashingPassword;

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
    public void updateUser(User user) {
        usersRepository.update(user);
    }

    public void setSession(User user, ServletRequest request) {
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        HttpSession session = httpRequest.getSession();
        session.setAttribute("user", user);
    }

    public void setCookie(User user, ServletResponse response) {
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        Cookie authCookie = new Cookie("session", user.getUuid());
        httpResponse.addCookie(authCookie);
    }

    @Override
    public User authorize(String email, String password) {
        Optional<User> optionalUser = getUserByEmail(email);
        User user = null;

        if (optionalUser.isPresent()) {
            String hashPassword = HashingPassword.hashing(password);
            if (optionalUser.get().getPassword().equals(hashPassword)) {
                user = optionalUser.get();
            }
        }

        return user;
    }

    @Override
    public void logout(ServletRequest request, ServletResponse response) {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession session =  httpRequest.getSession();
        session.setAttribute("user", null);
        session.setMaxInactiveInterval(1);
        for (Cookie cookie : httpRequest.getCookies()) {
            if (cookie.getName().equals("session")) {
                cookie.setValue("null");
                cookie.setMaxAge(1);
                httpResponse.addCookie(cookie);
            }
        }
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
