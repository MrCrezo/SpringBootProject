package com.example.SpringBootProject.Dao;

import com.example.SpringBootProject.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUserList() {
        return entityManager.createQuery("from User").getResultList();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user, int id) {
        User updateUser = entityManager.find(User.class, id);

        updateUser.setName(user.getName());
        updateUser.setAge(user.getAge());
        updateUser.setEmail(user.getEmail());
    }

    @Override
    public void deleteUser(int id) {
        entityManager.remove(entityManager.find(User.class, id));
    }
}
