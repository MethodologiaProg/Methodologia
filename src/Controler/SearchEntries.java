package Controler;


import Model.Entry;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;

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
                Entries.add(new Entry(rs.getInt("id"), rs.getInt("user"), rs.getString("address"), rs.getString("city"),rs.getString("country"), rs.getInt("price"), rs.getString("title"), rs.getString("description"), rs.getString("photo")));
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
    
    public List<Entry> GetEntriesByKeyword(String keyword){
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from entries where title like '%"+keyword+"%' or description like '%"+keyword+"%'");
            while(rs.next()){                 
                Entries.add(new Entry(rs.getInt("id"), rs.getInt("user"), rs.getString("address"), rs.getString("city"),rs.getString("country"), rs.getInt("price"), rs.getString("title"), rs.getString("description"), rs.getString("photo")));
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
                Entries.add(new Entry(rs.getInt("id"), rs.getInt("user"), rs.getString("address"), rs.getString("city"),rs.getString("country"), rs.getInt("price"), rs.getString("title"), rs.getString("description"), rs.getString("photo")));
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
    
    public List<Entry> GetEntriesById(int userId){
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from entries where user='"+userId+"'");
            while(rs.next()){           
                Entries.add(new Entry(rs.getInt("id"), rs.getInt("user"), rs.getString("address"), rs.getString("city"),rs.getString("country"), rs.getInt("price"), rs.getString("title"), rs.getString("description"), rs.getString("photo")));
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
    
    public List<Entry> GetEntriesByKeywordAndPrice(String keyword, int price){
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from entries where (title like '%"+keyword+"%' or description like '%"+keyword+"%') and price<="+price);
            while(rs.next()){                 
                Entries.add(new Entry(rs.getInt("id"), rs.getInt("user"), rs.getString("address"), rs.getString("city"),rs.getString("country"), rs.getInt("price"), rs.getString("title"), rs.getString("description"), rs.getString("photo")));
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
