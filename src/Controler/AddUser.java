package Controler;

//import java.io.File;
//import java.nio.file.Files;
//import java.nio.file.StandardCopyOption;
import java.awt.Component;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import javax.swing.JOptionPane;

public class AddUser {
    /**
     * Add a user to the database.
     * 
     * @param email Email of the user
     * @param password Password of the user
     * @param name First name of the user
     * @param lastname Last Name of the user
     * @param photo The path of the photo
     */
    public AddUser(String email, String password, String name, String lastname, String photo) {
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String path = "C:/Users/Hrystos/Documents/NetBeansProjects/Methodologia/photos/users/";
        if(!ValidateEmail(email)){
            try {
                con = ds.getConnection();
                stmt = con.createStatement();
                //if(photo.equals("")){
                    photo = "no_photo.png";
                    stmt.executeUpdate("Insert into users (email, password, first_name, last_name, profile_pic) Values ('"+email+"','"+password+"','"+name+"','"+lastname+"','C:/Users/Hrystos/Documents/NetBeansProjects/Methodologia/photos/users/"+photo+"')");
                //}else{
                //    stmt.executeUpdate("Insert into users (email, password, first_name, last_name) Values ('"+email+"','"+password+"','"+name+"','"+lastname+"')");
                //    rs = stmt.executeQuery("select id from users where email='"+email+"' and password='"+password+"'");
                //    stmt.executeUpdate("Update users set profile_pic='C://Users/Hrystos//Documents//NetBeansProjects//Methodologia//photos//users//"+rs.getInt("id")+".jpg' where id='"+rs.getInt("id")+"';");
                //}
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
        }else{
            Component frame = null;
            JOptionPane.showMessageDialog(frame,"This email already exist!");
        }
    }
    
    
    /**
     * Checks if the email provided by the user is already in use.
     * @param email 
     */
    private boolean ValidateEmail(String email){
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        int count = 0;
        boolean rt = false;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            rs = stmt.executeQuery("Select * from users where email='"+email+"'");
            while(rs.next()){
                count++;
            }
            rt = count==1;
            
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
    
}
