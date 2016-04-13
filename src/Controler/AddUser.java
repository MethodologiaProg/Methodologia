package Controler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

public class AddUser {

    public AddUser(String email, String password, String name, String lastname) {
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        System.out.println(email);
        System.out.println(password);
        System.out.println(name);
        System.out.println(lastname);
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate("Insert into users (email, password, first_name, last_name) Values ('"+email+"','"+password+"','"+name+"','"+lastname+"')");
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
