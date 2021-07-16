package com.eason.service.impl;

import com.eason.dao.impl.UserDaoImpl;
import com.eason.domain.PageBean;
import com.eason.domain.User;
import com.eason.service.UserService;

import java.util.List;

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
        boolean flag =false;

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
    public int findTotalCount(String _currentPage, String _row) {

        int currentPage = Integer.parseInt(_currentPage);
        int row = Integer.parseInt(_row);

        if(currentPage < 1){ currentPage =1;}

        int totalCount = userService.findTotalCount(currentPage,row);
        int totalPage = totalCount%row==0?totalCount/row:totalCount/row+1;

        if(currentPage > totalPage){
            currentPage = totalPage;
        }
        int pageBegin= (currentPage-1)*row;

        List<User> usersByPage = userService.findUsersByPage(pageBegin,row);

        PageBean pb = new PageBean();

        pb.setTotalCount(totalCount);
        pb.setTotalPage(totalPage);
        pb.setCurrentPage(currentPage);
        pb.setList(usersByPage);
        pb.setRow(row);

        return userDao.findTotalCount(currentPage,row);
    }

    @Override
    public List<User> findUsersByPage(int pageBegin, int row) {
        return userDao.findUsersByPage(pageBegin,row);
    }


}
