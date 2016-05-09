/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import static Controler.Authenticate.currentUserId;
import Model.Comment;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

/**
 *
 * @author Hrystos
 */
public class Comments {
    List<Comment> comments = new ArrayList<>();
    
    
    public List<Comment> GetComments(int entryId){
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from comments where entry='"+entryId+"'");
            while(rs.next()){           
                comments.add(new Comment(rs.getInt("id"), rs.getInt("senter"), rs.getInt("entry"), rs.getString("message")));
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
        return comments; 
    }
    
    public void AddComment(int entryId, String comment){
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate("insert into comments (senter, entry, message) Values ("+currentUserId+","+entryId+",'"+comment+"')");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
                try {
                    if(stmt != null) stmt.close();
                    if(con != null) con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        
    }
    
}
