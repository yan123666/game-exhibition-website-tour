package com.HuanYou.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.HuanYou.model.Ad;
import com.HuanYou.model.Game;
import com.HuanYou.service.ContentService;
import com.HuanYou.service.impl.ContentServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.HuanYou.service.ContentService;

@WebServlet(name = "contentServlet",value = "/contentServlet")
public class contentServlet extends HttpServlet {
    ContentService contentService = new ContentServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        //获取广告信息
        ObjectMapper mapper = new ObjectMapper(); 
        List<Ad> adList = contentService.getAd();

        String json = mapper.writeValueAsString(adList);


        out.print(json);

    }
}
