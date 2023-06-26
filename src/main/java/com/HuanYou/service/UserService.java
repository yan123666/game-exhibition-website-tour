package com.HuanYou.service;

import com.HuanYou.dao.UserDao;
import com.HuanYou.model.User;
import java.util.*;

public interface UserService {

    public int UserAdd(User user);

    public User getUser(String username,String password);

    public int UserEdit(User user);

    public List<User> findAllUser();

    public int userDelete(int id);

    /*public int UserDelete(User user);

    public int UserEdit(User user);

    public User getUser(String username,String password);*/

}
