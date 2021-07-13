package com.eason.test;


import com.eason.dao.impl.UserDaoImpl;
import com.eason.domain.User;
import org.junit.Test;

import java.util.List;

public class UserDaoImplTest {

    @Test
    public void loginTest(){

        User loginUser = new User();

        loginUser.setUsername("admin");
        loginUser.setPassword("admin");

        UserDaoImpl userDaoImpl = new UserDaoImpl();
        User user = userDaoImpl.userlogin(loginUser);

        System.out.println(user.getUsername()+user.getPassword());

    }

    @Test
    public void findAll(){
        UserDaoImpl userDao = new UserDaoImpl();
        List<User> users = userDao.findAll();

        for (User user : users) {
            System.out.println(user.getName());
        }
    }

    @Test
    public void addUser(){
        UserDaoImpl userDao = new UserDaoImpl();
        User addUser = new User();
        addUser.setName("testing");
        addUser.setGender("male");
        userDao.addUser(addUser);
    }
}
