package Controler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;


public class UpdateEntry {

    /**
     *Updates the information of an entry
     * 
     * @param id the entry's id
     * @param title The entry's title
     * @param price The entry's price
     * @param description The entry's description
     */
    public UpdateEntry (int id, String title, int price, String description){
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
                stmt.executeUpdate("Update entries Set title='"+title+"', price='"+price+"', description='"+description+"' Where id="+id);
            
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
