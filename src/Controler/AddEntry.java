package Controler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;


public class AddEntry {
    
    /**
     *Adds an entry to the database
     * 
     * @param title The title of the entry
     * @param price The price of the entry
     * @param country The country of the entry
     * @param city The city of the entry
     * @param address The address of the entry
     * @param userId The user id of the entry's owner
     * @param description A description for the entry
     */
    public AddEntry(String title, int price, String country, String city, String address, int userId, String description) {
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        String photo = "C:/Users/Hrystos/Documents/NetBeansProjects/Methodologia/photos/entries/no_photo.png";
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate("Insert into entries (user, address, city, country, price, title, description, photo) Values ('"+userId+"','"+address+"','"+city+"','"+country+"','"+price+"','"+title+"','"+description+"','"+photo+"')");
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
