package com.outdoor.apiservice.service;

import com.outdoor.apiservice.dao.IUserDAO;
import com.outdoor.apiservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IUserService{

    @Autowired
    private IUserDAO userDAO;

    @Override
    public User getUserById(int id) {
        User objet = userDAO.getUserById(id);
        return objet;
    }

    @Override
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public synchronized boolean addUser(User user){
        userDAO.addUser(user);
        return true;
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
