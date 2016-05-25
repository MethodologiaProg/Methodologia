package Controler;

import Model.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import javax.sql.DataSource;

public class FindUser {
    String userName;
    User user;

    /**
     * Finds a user from his id
     * Use GetUserName() for the full name of the user (e.g. John Smith)
     * User GetUser() for the object user
     * 
     * @param userId The id of the user to find
     */
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
    
    /**
     *Returns the full name (eg John Smith)
     * @return A string of the full name of the user
     */
    public String GetUserName(){
        return userName;
    }
    
    /**
     *Returns an object user
     * @return user object
     */
    public User GetUser(){        
        return user;
    }
    
}
