package Controler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;


public class UpdateUser {
    
    /**
     *Updates the information of a user
     * @param id user id
     * @param name first name
     * @param lastName last name
     * @param email email
     * @param password password
     */
    public UpdateUser(int id, String name, String lastName, String email, String password){
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            if (password.equals(""))
            {
                stmt.executeUpdate("Update users Set email='"+email+"', first_name='"+name+"', last_name='"+lastName+"' Where id="+id);
            }else{
                stmt.executeUpdate("Update users Set email='"+email+"', password='"+password+"', first_name='"+name+"', last_name='"+lastName+"' Where id="+id);
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
        
    }
    
}
