
package Controler;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;


public class DeleteEntry {
    
    
    
    public DeleteEntry(int id){
        DataSource ds = ConnectToDatabase.getDatasource();
        Connection con = null;
        Statement stmt = null;
        try {
            con = ds.getConnection();
            stmt = con.createStatement();
            stmt.executeUpdate("Delete from entries where id="+id);
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
