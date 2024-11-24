package com.example.SpringBootProject.service;


import com.example.SpringBootProject.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    User getUser(int id);

    void saveUser(User user);

    void updateUser(User user, int id);

    void deleteUser(int id);
}
