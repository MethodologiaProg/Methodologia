
package Controler;

import static Controler.Authenticate.currentUserId;
import Model.Entry;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;


public class Interest {
    
    /**
     *Adds in the database the interest of a user to an entry
     * @param entryId The id of the entry the user is interested in
     */
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
    
    /**
     * Returns the number of the people interested in a specific entry
     * @param entryId The if of the entry
     * @return Int with the number of people interested
     */
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
    
    /**
     *Checks if the user has already declare interest on a specific entry
     * @param id the entry id
     * @return True if the user hasn't already declare interest, false otherwise
     */
    public static boolean CheckUniqueInterest(int id){
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int count=0;
        boolean rt = false;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from intrest where entryId="+id+" and userId="+currentUserId);            
            while(rs.next()){
                count++;
            }
            if (count==1) rt= true;
            else rt= false;
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
        return rt;
    }
    
    /**
     *Finds and returns all the entries the specific user is interested
     * @return A list of entries the user is interested
     */
    public static List<Entry> FindEntriesImInterested(){
        List<Entry> Entries = new ArrayList<>();
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        Statement stmt2 = null;
        ResultSet rs = null;  
        ResultSet rs2 = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            stmt2 = con.createStatement();
            rs = stmt.executeQuery("select * from intrest where userId="+currentUserId);
            while(rs.next()){
                rs2 = stmt2.executeQuery("select * from entries where id="+rs.getInt("entryId"));
                while(rs2.next()){
                    Entries.add(new Entry(rs2.getInt("id"), rs2.getInt("user"), rs2.getString("address"), rs2.getString("city"),rs2.getString("country"), rs2.getInt("price"), rs2.getString("title"), rs2.getString("description"), rs2.getString("photo")));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
                try {
                    if(stmt != null) stmt.close();
                    if(stmt2 != null) stmt2.close();
                    if(con != null) con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
        return Entries;
    }
    
}
