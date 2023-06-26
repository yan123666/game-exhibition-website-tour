package com.HuanYou.dao;

import com.HuanYou.model.Game;
import com.HuanYou.model.User;
import com.HuanYou.utils.JDBCUtils;
import java.lang.String;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CollectDao {
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    {
        try{
            conn = JDBCUtils.getConnection();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //用户收藏游戏

    public int collect(User user,Game game){
        String sql = "insert into collection (userID,gameID) values (?,?)";
        int resultNumber = 0;

        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,String.valueOf(user.getUserID()));
            pstmt.setString(2,String.valueOf(game.getGameID()));
            resultNumber = pstmt.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return resultNumber;
    }

    //用户删除收藏
    public int delete(User user,Game game){
        String sql = "delete from collection where userID = ? and gameID = ?";
        int resultNumber = 0;
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,String.valueOf(user.getUserID()));
            pstmt.setString(2,String.valueOf(game.getGameID()));
            resultNumber = pstmt.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return resultNumber;
    }

    //查询用户收藏游戏
    public List<Game> findCollect(User user){
        List<Game> collectList = new ArrayList<>();
        Game game = null;
        String sql = "SELECT userID,gameID form collection where useID = ?";
        try{

            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,String.valueOf(user.getUserID()));
            rs = pstmt.executeQuery();
            while(rs.next()){
                game = new Game();
                game.setGameID(rs.getInt("gameID"));
                collectList.add(game);
            }
        }
        catch(SQLException e)
        {
            e.getMessage();
        }
        return collectList;
    }
}
