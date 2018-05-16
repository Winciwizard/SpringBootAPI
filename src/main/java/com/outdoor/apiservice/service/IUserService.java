package com.outdoor.apiservice.service;

import com.outdoor.apiservice.entity.User;

import java.util.List;

public interface IUserService {

    List<User> getAllUsers();

    User getUserById(int id);

    boolean addUser(User user);

    void updateUser(User user);

    void deleteUser(int id);

}
