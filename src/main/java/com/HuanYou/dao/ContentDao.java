package com.HuanYou.dao;


import com.HuanYou.model.Ad;
import com.HuanYou.utils.JDBCUtils;
import com.HuanYou.model.Game;

import java.sql.*;
import java.util.*;

public class ContentDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    {
        try{
            conn =JDBCUtils.getConnection();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //获取广告信息
    public List<Ad> getAd(){
        List<Ad> adList =new ArrayList<>();
        Ad ad =null;
        String sql = "SELECT gameID,AdText,AdImage from ad";
        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                ad = new Ad();
                ad.setGameID(rs.getInt("gameID"));
                ad.setAdText(rs.getString("AdText"));
                ad.setAdImage(rs.getString("AdImage"));
                adList.add(ad);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return adList;
    }
    public List<Game> getHotGame(){
        List<Game> hotList = new ArrayList<>();
        Game game;
        String sql = "SELECT gameID,Cname,gameImage from hotGame inner join game on  hotGame.hotGameID = game.gameID";
        try{
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()){
                game = new Game();
                game.setGameID(rs.getInt("gameID"));
                game.setCname(rs.getString("Cname"));
                game.setGameImage(rs.getString("gameImage"));
                hotList.add(game);
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return hotList;
    }
}
