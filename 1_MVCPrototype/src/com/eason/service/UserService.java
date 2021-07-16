package com.eason.service;

import com.eason.domain.PageBean;
import com.eason.domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    public User login(User user);

    public List<User> findAll();

    boolean addUser(User addUser);

    boolean delSelectedUser(String[] ids);

    void deleteUser(String id);

    User findUser( String id);

    void updateUser(User updateUser);

    PageBean<User> findUsersByPage(String _currentPage, String _row, Map<String, String[]> conditions);
}
