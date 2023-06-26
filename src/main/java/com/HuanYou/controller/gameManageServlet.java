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

@WebServlet(name = "gameManageServlet",value = "/gameManageServlet")
public class gameManageServlet extends HttpServlet {
    GameService gameService = new GameServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        String gameID = request.getParameter("gameID1");
        String gameImage = request.getParameter("gameImage");
        String cname = request.getParameter("cname");
        String ename = request.getParameter("ename");
        String category = request.getParameter("category");
        String score = request.getParameter("score");
        String developer = request.getParameter("developer");
        String date = request.getParameter("date");
        String profile = request.getParameter("profile");
        String deleteGameID = request.getParameter("deleteGameID");
        System.out.println(deleteGameID);
        int resultNumber = 0;
        if(deleteGameID==null){
            Game game = new Game();
            game.setGameID(Integer.parseInt(gameID));
            game.setGameImage(gameImage);
            game.setCname(cname);
            game.setEname(ename);
            game.setCategory(category);
            game.setScore(Integer.parseInt(score));
            game.setDeveloper(developer);
            game.setDate(date);
            game.setProfile(profile);
            System.out.println(game);
            resultNumber = gameService.gameAdd(game);

            out.print(resultNumber);
        }else{
            System.out.println(deleteGameID);
            resultNumber = gameService.gameDelete(Integer.parseInt(deleteGameID));

            out.print(resultNumber);

        }




    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
