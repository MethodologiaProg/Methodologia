package Controler;
import javax.sql.DataSource;  
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;


public class ConnectToDatabase {
    static String db = "jdbc:mysql://localhost:3306/methprog?zeroDateTimeBehavior=convertToNull";
    static String dbUsername = "root";
    static String dbPassword = "";
    
    /**
     *Use this to initialize the database properties.
     * @param db The database as a path
     * @param dbUsername The username (usually "root")
     * @param dbPassword The password
     */
    public static void ConnectToDatabase(String db, String dbUsername, String dbPassword){
        ConnectToDatabase.db = db;
        ConnectToDatabase.dbUsername = dbUsername;
        ConnectToDatabase.dbPassword = dbPassword;
        
    }

    /**
     *Use this whenever you want to run an SQL statement
     * 
     * @return returns the datasource
     */
    public static DataSource getDatasource(){
        MysqlDataSource mysqlDS = null;

        mysqlDS = new MysqlDataSource();
        mysqlDS.setURL(db);
        mysqlDS.setUser(dbUsername);
        mysqlDS.setPassword(dbPassword);
        
        return mysqlDS;  
    }
    
    
    
}
