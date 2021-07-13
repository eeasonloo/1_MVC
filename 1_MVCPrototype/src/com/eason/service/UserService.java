package com.eason.service;

import com.eason.domain.User;

import java.util.List;

public interface UserService {

    public User login(User user);

    public List<User> findAll();

    boolean addUser(User addUser);
}
