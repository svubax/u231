package ru.web.service;

import ru.web.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();
    void addUser(User user);
    void deleteUser(int id);
    public void updateUser(User user);
    User getUser(int id);
}
