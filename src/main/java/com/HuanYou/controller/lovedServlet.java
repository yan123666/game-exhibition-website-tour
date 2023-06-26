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

@WebServlet(name = "lovedServlet",value = "/lovedServlet")
public class lovedServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String loved = request.getParameter("loved");
        HttpSession session = request.getSession();

        User user = (User) session.getAttribute("user");
        user.setLoved(loved);
        userService.UserEdit(user);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
