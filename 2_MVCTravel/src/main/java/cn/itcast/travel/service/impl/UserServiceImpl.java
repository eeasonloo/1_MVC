package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao= new UserDaoImpl();
    @Override
    public boolean register(User user) {
        // Check Username Exist or not
        System.out.println(user.toString());
        User u = userDao.findByUsername(user.getUsername());

        if(u != null){
            return false;

        }

        // Insert User Info
//        Boolean flag = userDao.registerUser(user);
        return true;
    }
}
