package com.eason.dao.impl;

import com.eason.dao.UserDao;
import com.eason.domain.User;
import com.eason.util.JDBCUtils;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


public class UserDaoImpl implements UserDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());


    @Override
    public User userlogin(User loginUser) {
        try {
            String sql ="select * from mvc where username = ? and password = ?";
            User user = template.queryForObject(sql,
                    new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();//record log
            return null;
        }

    }

    @Override
    public List<User> findAll() {

        String sql="select * from mvc";
        List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
        return users;
    }

}
