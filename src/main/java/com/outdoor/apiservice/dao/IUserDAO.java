package com.outdoor.apiservice.dao;

import com.outdoor.apiservice.entity.User;

import java.util.List;

public interface IUserDAO {

    List<User> getAllUsers();

    User getUserById(int id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

}
