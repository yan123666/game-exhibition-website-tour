package com.HuanYou.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.HuanYou.utils.JDBCUtils;
import com.HuanYou.model.Game;
import java.util.*;

public class GameDao {
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
    public List<Game> findAll(){
        //查询所有游戏
        Game game = null;
        List<Game> gameList= new  ArrayList<>();
        String sql = "select * from game";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                game = new Game();
                game.setGameID(rs.getInt("gameID"));
                game.setGameImage(rs.getString("gameImage"));
                game.setCname(rs.getString("Cname"));
                game.setEname(rs.getString("Ename"));
                game.setScore(rs.getInt("score"));
                game.setDeveloper(rs.getString("developer"));
                game.setDate(rs.getString("date"));
                game.setProfile(rs.getString("profile"));
                game.setCategory(rs.getString("category"));
                gameList.add(game);
            }
        }catch(SQLException e) {e.printStackTrace();}
        return gameList;
    }

    //根据分类查询游戏
    public List<Game> findCategory(String category){
        Game game = null;
        List<Game> gameList= new  ArrayList<>();
        String sql = "select * from game where category=?";
        try {
            pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1,category);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                game = new Game();
                game.setGameID(rs.getInt("gameID"));
                game.setGameImage(rs.getString("gameImage"));
                game.setCname(rs.getString("Cname"));
                game.setEname(rs.getString("Ename"));
                game.setScore(rs.getInt("score"));
                game.setDeveloper(rs.getString("developer"));
                game.setDate(rs.getString("date"));
                game.setProfile(rs.getString("profile"));
                game.setCategory(rs.getString("category"));
                gameList.add(game);
            }
        }catch(SQLException e ) {e.printStackTrace();}
        return gameList;
    }

    //根据用户输入搜索游戏
    public List<Game> findText(String Text){
        Game game = null;
        List<Game> gameList= new  ArrayList<>();
        String sql = "select * from game where Cname like ? or Ename like ?";
        try {
            pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1,'%'+Text+'%');
            pstmt.setString(2,'%'+Text+'%');
            rs = pstmt.executeQuery();
            while(rs.next()) {
                game = new Game();
                game.setGameID(rs.getInt("gameID"));
                game.setGameImage(rs.getString("gameImage"));
                game.setCname(rs.getString("Cname"));
                game.setEname(rs.getString("Ename"));
                game.setScore(rs.getInt("score"));
                game.setDeveloper(rs.getString("developer"));
                game.setDate(rs.getString("date"));
                game.setProfile(rs.getString("profile"));
                game.setCategory(rs.getString("category"));
                gameList.add(game);
            }
        }catch(SQLException e ) {e.printStackTrace();}
        return gameList;
    }

    //根据游戏ID查询游戏
    public Game findGame(String GameID) {
        String sql = "select * from game where GameID=?";
        Game game = null;
        try {
            pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1,GameID);
            rs = pstmt.executeQuery();
            game = new Game();
            game.setGameID(rs.getInt("GameID"));
            game.setGameImage(rs.getString("gameImage"));
            game.setCname(rs.getString("Cname"));
            game.setEname(rs.getString("Ename"));
            game.setScore(rs.getInt("score"));
            game.setDeveloper(rs.getString("developer"));
            game.setDate(rs.getString("date"));
            game.setProfile(rs.getString("profile"));
            game.setCategory(rs.getString("category"));
        }catch(SQLException e ) {e.printStackTrace();}
        return game;
    }

    public int insert(Game game) {
        int resultNumber = 0;
        try {
            String sql = "insert into game values(?,?,?,?,?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,game.getGameID());
            pstmt.setString(2,game.getGameImage());
            pstmt.setString(3,game.getCname());
            pstmt.setString(4,game.getEname());
            pstmt.setInt(5,game.getScore());
            pstmt.setString(6,game.getDeveloper());
            pstmt.setString(7,game.getDate());
            pstmt.setString(8,game.getProfile());
            pstmt.setString(9,game.getCategory());
            resultNumber = pstmt.executeUpdate();
        }catch(SQLException e) { e.printStackTrace();}
        return resultNumber;
    }

    //删除游戏
    public int delete(int gameID) {
        int resultNumber = 0;
        try {
            String sql = "delete from game where gameID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, gameID);
            resultNumber = pstmt.executeUpdate();
        }catch(SQLException e) { e.printStackTrace();}
        return resultNumber;
    }

}
