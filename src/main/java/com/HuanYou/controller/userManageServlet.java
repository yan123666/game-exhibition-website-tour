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

@WebServlet(name = "userManageServlet",value = "/userManageServlet")
public class userManageServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out =response.getWriter();

        String userID = request.getParameter("userID");
        int resultNumber = userService.userDelete(Integer.parseInt(userID));
        System.out.println(userID);
        out.print(resultNumber);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        List<User> userList= userService.findAllUser();

        PrintWriter out =response.getWriter();
        ObjectMapper mapper = new ObjectMapper(); //Jackson的核心类
        String json = mapper.writeValueAsString(userList);

        out.print(json);




    }
}
