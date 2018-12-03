package web.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    static String url = "jdbc:sqlserver://localhost:1433;DatabaseName=newlifeDB";
    static String username = "sa";
    static String password = "888999";
    static String driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    
    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driverClassName);
            
            connection = DriverManager.getConnection(url,username,password);
            
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
}
