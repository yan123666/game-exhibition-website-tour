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

@WebServlet(name = "hotGameServlet", value = "/hotGameServlet")
public class hotGameServlet extends HttpServlet {
    ContentService contentService = new ContentServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        List<Game> hotGameList = contentService.getHotGame();
        ObjectMapper mapper = new ObjectMapper(); //Jackson的核心类
        String json2 = mapper.writeValueAsString(hotGameList);
        out.print(json2);
    }
}
