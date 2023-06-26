package com.HuanYou.service.impl;

import com.HuanYou.model.User;
import com.HuanYou.service.UserService;
import com.HuanYou.dao.UserDao;

import java.util.List;

public class UserServiceImpl  implements UserService {
    UserDao userDao = new UserDao();
    @Override
    public int UserAdd(User user) {
        return userDao.insert(user);
    }

    public User getUser(String username, String password) {
        return userDao.select(username,password);
    }

    @Override
    public int UserEdit(User user) {
        return userDao.update(user);
    }
    public List<User> findAllUser(){
        return userDao.findAll();
    }

    public int userDelete(int id){
        return userDao.Delete(id);
    }

}
