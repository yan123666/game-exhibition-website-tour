package com.HuanYou.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.HuanYou.service.GameService;
import com.HuanYou.model.Game;
import com.HuanYou.service.impl.GameServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet(name = "gameServlet",value = "gameServlet")
public class gameServlet extends HttpServlet {
    GameService gameService = new GameServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();

        String category = request.getParameter("category");
        String searchText = request.getParameter("search");
        System.out.println(category);
        System.out.println(searchText);
        List<Game> gameList = null;
        if(category!=null){
            gameList = gameService.getCategory(category);
        }
        else if(searchText!=null){
            gameList = gameService.gameSearch(searchText);
        }
        ObjectMapper mapper = new ObjectMapper(); //Jackson的核心类
        String json = mapper.writeValueAsString(gameList);
        out.print(json);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        List<Game> gameList = gameService.getGameList();
        ObjectMapper mapper = new ObjectMapper(); //Jackson的核心类
        String json = mapper.writeValueAsString(gameList);

        PrintWriter out = response.getWriter();
        out.print(json);
    }
}
