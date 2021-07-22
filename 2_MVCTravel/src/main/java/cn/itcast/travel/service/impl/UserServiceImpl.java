package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {

    private UserDao userDao= new UserDaoImpl();
    @Override
    public boolean register(User user) {
        // Check Username Exist or not
        User u = userDao.findByUsername(user.getUsername());

        if(u != null){
            return false;
        }

        // Insert User Info
        user.setCode(UuidUtil.getUuid());
        user.setStatus("N");

       /* String content ="<a href ='http://localhost/travel/user/active?code='" + user.getCode() + "> click this link to activate </a>";
        MailUtils.sendMail(user.getEmail(),content, "Activation Mail");*/

        System.out.println("http://localhost/travel/user/active?code=" + user.getCode());

        Boolean flag = userDao.registerUser(user);

        return true;
    }
}
