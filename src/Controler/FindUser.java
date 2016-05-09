/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import Model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import javax.sql.DataSource;

/**
 *
 * @author Hrystos
 */
public class FindUser {
    String userName;
    User user;

    
    public FindUser(int userId) {
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from users where id='"+userId+"'");
            while(rs.next()){
                userName = rs.getString("first_name")+" "+rs.getString("last_name");
                user = new User(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("email"), rs.getString("profile_pic"));
//                user.setId(rs.getInt("id"));
//                user.setName(rs.getString("first_name"));
//                user.setLast_name(rs.getString("last_name"));
//                user.setPhoto(rs.getString("profile_pic"));
//                user.setEmail(rs.getString("email"));
                
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
                try {
                    if(rs != null) rs.close();
                    if(stmt != null) stmt.close();
                    if(con != null) con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }
    
    public String GetUserName(){
        return userName;
    }
    
    public User GetUser(){        
        return user;
    }
    
}
