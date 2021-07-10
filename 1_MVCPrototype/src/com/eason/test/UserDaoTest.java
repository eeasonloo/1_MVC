package com.eason.test;


import com.eason.dao.UserDao;
import com.eason.domain.User;
import org.junit.Test;

public class UserDaoTest {

    @Test
    public void loginTest(){

        User loginUser = new User("admin","admin");

        UserDao userDao = new UserDao();
        User user = userDao.userLogin(loginUser);

        System.out.println(user.getUsername()+user.getPassword());



    }
}
