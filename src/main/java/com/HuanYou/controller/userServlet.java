package com.HuanYou.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.HuanYou.service.impl.UserServiceImpl;
import com.HuanYou.service.UserService;
import com.HuanYou.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(name = "userServlet",value = "/userServlet")
public class userServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        int resultNumber = 0;
        PrintWriter out = response.getWriter();
        String nickname = request.getParameter("nickname");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String profile = request.getParameter("profile");
        String head =request.getParameter("head");
        System.out.println(nickname);
        if(nickname != null){
            user.setNickname(nickname);
            user.setGender(gender);
            user.setBirthday(birthday);
            user.setProfile(profile);
        }
        else{
            user.setHead(head);
        }
        resultNumber=userService.UserEdit(user);
        out.print(resultNumber);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");

        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper(); //Jackson的核心类
        String json = mapper.writeValueAsString(user);
        out.print(json);
    }
}
