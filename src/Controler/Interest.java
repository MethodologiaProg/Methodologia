/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import static Controler.Authenticate.currentUserId;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *
 * @author Hrystos
 */
public class Interest {
    
    public Interest(int entryId){
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate("insert into intrest (userId, entryId) Values ("+currentUserId+","+entryId+")");
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
    
    public static int getNumberOfPeopleInterested(int entryId){
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int numOfPeople=0;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from intrest where entryId="+entryId);
            
            while(rs.next()){
                numOfPeople++;
            }            
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
        return numOfPeople;        
    }
}
