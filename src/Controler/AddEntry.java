/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;

/**
 *
 * @author Hrystos
 */
public class AddEntry {
    
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
