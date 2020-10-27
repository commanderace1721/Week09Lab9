package dataaccess;

import java.sql.Connection;
import javax.sql.DataSource;

/**
 *
 * @author Group CCC
 */
public class ConnectionPool {
    
    private static ConnectionPool pool = null;
    private static DataSource dataSource = null;
    
    private ConnectionPool(){
    
    }
    
    public static synchronized ConnectionPool getInstance(){
        return null;
    
    }
    
    public Connection getConnection(){
        return null;
    
    }
    
    public void freeConnection(Connection c){
    
    }
    
}