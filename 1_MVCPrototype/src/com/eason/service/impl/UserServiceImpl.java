package com.eason.service.impl;

import com.eason.dao.impl.UserDaoImpl;
import com.eason.domain.PageBean;
import com.eason.domain.User;
import com.eason.service.UserService;

import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private UserDaoImpl userDao = new UserDaoImpl();

    @Override
    public User login(User user) {
        return userDao.userlogin(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public boolean addUser(User addUser) {
        return userDao.addUser(addUser);
    }

    @Override
    public boolean delSelectedUser(String[] ids) {
        boolean flag = false;

        for (String id : ids) {
            int i = Integer.parseInt(id);
            flag = userDao.delSeletedUser(i);
        }
        return flag;
    }

    @Override
    public void deleteUser(String id) {
        userDao.delSeletedUser(Integer.parseInt(id));
    }

    @Override
    public User findUser(String id) {
        return userDao.findUser(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User updateUser) {
        userDao.updateUser(updateUser);
    }

    @Override
    public PageBean<User> findUsersByPage(String _currentPage, String _row, Map<String, String[]> conditions) {

        int currentPage = Integer.parseInt(_currentPage);
        int row = Integer.parseInt(_row);

        int totalCount = userDao.findTotalCount(conditions);
        int totalPage = totalCount % row == 0 ? totalCount / row : totalCount / row + 1;

        if(currentPage <= 0) {currentPage = 1;}
        if (currentPage >= totalPage) {
            if(totalPage == 0)
                currentPage = 1;
            if(totalPage != 0)
                currentPage = totalPage;
        }

        int pageBegin = (currentPage - 1) * row;

        List<User> usersByPage = userDao.findUsersByPage(pageBegin, row, conditions);

        PageBean pb = new PageBean();

        pb.setTotalCount(totalCount);
        pb.setTotalPage(totalPage);
        pb.setCurrentPage(currentPage);
        pb.setList(usersByPage);
        pb.setRow(row);

        return pb;
    }
}


