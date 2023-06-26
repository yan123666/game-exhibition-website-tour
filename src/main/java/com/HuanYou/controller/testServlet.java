package com.HuanYou.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import com.HuanYou.service.impl.UserServiceImpl;
import com.HuanYou.service.UserService;
import com.HuanYou.model.User;

import  com.HuanYou.dao.test;
@WebServlet(name = "testServlet",value = "/testServlet")
public class testServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = null;

        user = userService.getUser("azirkxs","123456");
        System.out.println(user.getLoved());
    }
}
