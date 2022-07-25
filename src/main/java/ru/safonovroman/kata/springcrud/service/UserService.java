package ru.safonovroman.kata.springcrud.service;

import ru.safonovroman.kata.springcrud.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    User getUser(Long id);
    List<User> listUsers();
    void update(User user);
    void delete(Long id);
}
