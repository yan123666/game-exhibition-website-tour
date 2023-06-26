package com.HuanYou.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.HuanYou.service.impl.UserServiceImpl;
import com.HuanYou.service.UserService;
import com.HuanYou.model.User;

@WebServlet(name = "registerServlet",value = "/registerServlet")
public class registerServlet extends HttpServlet {
    UserService userService = new UserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        String Cusername = request.getParameter("Cusername");
        String Cpassword = request.getParameter("Cpassword");
        String Cpassword2 = request.getParameter("Cpassword2");
        PrintWriter out = response.getWriter();
        System.out.println(Cpassword);
        System.out.println(Cpassword2);
        User user =new User();
        int resultNumber=0;
        String result1 = Pusername(Cusername);
        String result2 = Ppassword(Cpassword);
        System.out.println(result1);
        if(Cusername==""){
            out.print("用户名不能为空");
        }
        else if(Cpassword==""){
            out.print("密码不能为空");
        }
        else if(result1!=""){
            out.print(result1);
        }
        else if(result2!=""){
            out.print(result2);
        }
        else if(!Cpassword.equals(Cpassword2)){
            out.print("两次输入的密码不一致");
        }
        else{
            user.setUsername(Cusername);
            user.setPassword(Cpassword);
            resultNumber=userService.UserAdd(user);
            if(resultNumber>0){
                out.print("注册成功");

            }else{
                out.print("注册失败");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    public String Pusername(String username) {
        boolean bool =false;
        if (username.length() >= 6 && username.length() <= 10) {
            for (int i = 0; i < username.length(); i++) {

                char ch = username.charAt(i);
                //获取每一个字符
                if (ch >= '0' && ch <= '9') {
                    //判断字符是否为0到9的数字
                    bool = true;

                } else {
                    bool =false;
                    return "用户名需要0~9的数字组成,长度为6~10位";
                }
            }
            if(bool == true){
                return "";
            }
        }
        return "用户名长度需要为长度为6~10位";
    }
    public String Ppassword(String password){

            //用户名格式正确，判断密码长度
            if (password.length() >= 6 && password.length() <= 12){
                 return "";
            }else{
                 return "密码长度需为6~12位";

            }

    }
}


