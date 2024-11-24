package com.example.SpringBootProject.Dao;

import com.example.SpringBootProject.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    List<User> getUserList();

    User getUser(int id);

    void saveUser(User user);

    void updateUser(User user, int id);

    void deleteUser(int id);
}
