package com.HuanYou.dao;

import com.HuanYou.model.User;
import com.HuanYou.utils.JDBCUtils;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.text.*;
import java.text.SimpleDateFormat;

public class UserDao {
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
    public int insert(User user){
        //向数据库中插入该用户的用户名和密码
        int resultNumber=0;
        String sql = "insert into user (username,password) values (?,?) ";
        try{
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            resultNumber = pstmt.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return resultNumber;

        //插入用户

    }
    public User select(String username,String password){
        //根据用户名和密码查询用户
        User user = null;
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd");
        String sql = "select userID,username,password,nickname,head,gender,loved,profile,birthday from user where username= ? and password=?";
        try{
            pstmt = this.conn.prepareStatement(sql);
            pstmt.setString(1,username);
            pstmt.setString(2,password);
            rs = pstmt.executeQuery();
            while(rs.next()){
                user = new User();
                user.setUserID(rs.getInt("userID"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setNickname(rs.getString("nickname"));
                user.setHead(rs.getString("head"));
                user.setGender(rs.getString("gender"));
                user.setLoved(rs.getString("loved"));
                user.setProfile(rs.getString("profile"));
                user.setBirthday(rs.getString("birthday"));
            }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return user;
    }
    public int update(User user){
        //更新用户信息
        SimpleDateFormat sdf = new SimpleDateFormat( "yyyy-MM-dd");
        int resultNumber = 0;
        try {
            String sql = "update user set nickname=?,head=?,gender=?,profile=?,loved=?,birthday=? WHERE  username = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getNickname());
            pstmt.setString(2,user.getHead());
            pstmt.setString(3,user.getGender());
            pstmt.setString(4,user.getProfile());
            pstmt.setString(5,user.getLoved());
            pstmt.setString(6,user.getBirthday());
            pstmt.setString(7,user.getUsername());
            resultNumber = pstmt.executeUpdate();
        }catch(SQLException e) { e.printStackTrace();}
        return resultNumber;
    }
    public	List<User> findAll(){
        User user = null;
        List<User> userList= new  ArrayList<>();
        String sql = "select * from user";
        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                user = new User();
                user.setUserID(rs.getInt("userID"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setNickname(rs.getString("nickname"));
                user.setHead(rs.getString("head"));
                user.setGender(rs.getString("gender"));
                user.setProfile(rs.getString("profile"));
                user.setLoved(rs.getString("loved"));
                user.setBirthday(rs.getString("birthday"));
                userList.add(user);
            }
        }catch(SQLException e) {e.printStackTrace();}
        return userList;

    }
    public int Delete(int userID){
        int resultNumber = 0;
        try {
            String sql = "delete from user where userID = ?";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,userID);
            resultNumber = pstmt.executeUpdate();
        }catch(SQLException e) { e.printStackTrace();}
        return resultNumber;
    }
}
    /*public int Delete(User user){
        //删除用户


    }
    List<User> findAll(){
        //查询所有用户

    }
    public User select(String username,String password){
        //根据用户名和密码查询用户

    }
    public int update(User user){
        //更新用户信息

    }*/

