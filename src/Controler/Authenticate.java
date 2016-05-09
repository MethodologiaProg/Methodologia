
package Controler;

import Model.User;
import View.Profile;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import javax.swing.JOptionPane;

public class Authenticate {
    public static int currentUserId;
    
    public static boolean Authenticate(String email, String password){
        DataSource ds = ConnectToDatabase.getDatasource();
        User user;
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        Profile pr = new Profile();    
        boolean returnvalue = false;
        int count = 0;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("select id, email, password, first_name, last_name, profile_pic  from users where email='"+email+"' and password='"+password+"'");
            while(rs.next()){
                count++;
            }
            rs.first();
            if(count==1){
                user = new User(rs.getInt("id"),rs.getString("first_name"),rs.getString("last_name"),rs.getString("email"), rs.getString("profile_pic"));
                pr.setProfileInfo(user);
                pr.setVisible(true);
                returnvalue = true;
                
                currentUserId = rs.getInt("id");
                
            }
            else{
                Component frame = null;
                JOptionPane.showMessageDialog(frame,"Invalid Email or Password");
                returnvalue = false;
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
        return returnvalue;
        
        
    }
    
}
