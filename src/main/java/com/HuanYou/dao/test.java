package com.HuanYou.dao;

import com.HuanYou.utils.JDBCUtils;
import com.HuanYou.model.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test {
    public static void getUser(){
        Connection conn = JDBCUtils.getConnection();
        Statement stmt =null;
        ResultSet rs = null;
        try{
            stmt = conn.createStatement();
            String sql = "SELECT * from user";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                System.out.println(rs.getString("profile"));
                System.out.println(rs.getString("gender"));
                System.out.println(rs.getString("loved"));
                System.out.println(rs.getString("nickname"));
                System.out.println(rs.getString("password"));
                System.out.println(rs.getString("username"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        if(conn!=null){
            System.out.println("数据库连接成功！");
            System.out.println(conn);

        }
    }
}
