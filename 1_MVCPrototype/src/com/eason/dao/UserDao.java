package com.eason.dao;

import com.eason.domain.User;

import java.util.List;

public interface UserDao {

    public User userlogin(User loginUser);

    public List<User> findAll();

    boolean addUser(User addUser);

    boolean delSeletedUser(int i);

    User findUser(int id);

    void updateUser(User updateUser);

    int findTotalCount();

    List<User> findUsersByPage(int pageBegin, int row);
}
