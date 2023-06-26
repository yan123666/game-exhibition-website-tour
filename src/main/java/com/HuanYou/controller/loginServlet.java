package com.HuanYou.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;

import com.HuanYou.service.impl.UserServiceImpl;
import com.HuanYou.service.UserService;
import com.HuanYou.model.User;

@WebServlet(name = "loginServlet", value = "/loginServlet")
public class loginServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        PrintWriter out = response.getWriter();
        User user =userService.getUser(username,password);
        HttpSession session =  request.getSession();
        if(username==""){
            out.print("用户名不能为空");
        }
        else if(password==""){
            out.print("密码不能为空");
        }
        else if(user==null){
            out.print("用户名或密码错误");
        }else{
            out.print("登录成功");
            session.setAttribute("user",user);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

}



