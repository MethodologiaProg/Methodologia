package Controler;


import Model.Entry;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import javax.swing.JOptionPane;

public class SearchEntries {
    List<Entry> Entries = new ArrayList<>();
    
    public List<Entry> getAllEntries(){
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from entries");
            while(rs.next()){
                System.out.println("Entry ID="+rs.getInt("id")+", Address="+rs.getString("address")+", city="+rs.getString("city")+", Country="+rs.getString("country")+", Price="+rs.getString("price")+", Title="+rs.getString("title"));                 
                Entries.add(new Entry(rs.getInt("id"), rs.getInt("user"), rs.getString("address"), rs.getString("city"),rs.getString("country"), rs.getInt("price"), rs.getString("title")));
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
        return Entries;
    }
    
    public List<Entry> GetEntriesByKeyword(String keyword, int price){
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from entries where title like '%"+keyword+"%' and price<="+price);
            while(rs.next()){
                System.out.println("Entry ID="+rs.getInt("id")+", Address="+rs.getString("address")+", city="+rs.getString("city")+", Country="+rs.getString("country")+", Price="+rs.getString("price")+", Title="+rs.getString("title"));                 
                Entries.add(new Entry(rs.getInt("id"), rs.getInt("user"), rs.getString("address"), rs.getString("city"),rs.getString("country"), rs.getInt("price"), rs.getString("title")));
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
        return Entries;
    }
    
    public List<Entry> GetEntriesByPrice(int price){
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from entries where price <="+price);
            while(rs.next()){
                System.out.println("Entry ID="+rs.getInt("id")+", Address="+rs.getString("address")+", city="+rs.getString("city")+", Country="+rs.getString("country")+", Price="+rs.getString("price")+", Title="+rs.getString("title"));                 
                Entries.add(new Entry(rs.getInt("id"), rs.getInt("user"), rs.getString("address"), rs.getString("city"),rs.getString("country"), rs.getInt("price"), rs.getString("title")));
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
        return Entries;
        
    }
    
    
    
    
}
