package com.eason.service.impl;

import com.eason.dao.impl.UserDaoImpl;
import com.eason.domain.User;
import com.eason.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<User> findAll() {
        UserDaoImpl userDao = new UserDaoImpl();
        return userDao.findAll();
    }
}
