
/*A classe DatabaseLocator implementa o padrão Singleton*/

package Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Felipe
 */
public class DatabaseLocator {
    
    private static DatabaseLocator instance = new DatabaseLocator();
  
    public static DatabaseLocator getInstance()
    {
        return instance;
    }
  
    /* Cria uma nova instância de DatabaseLocator */
    private DatabaseLocator() {}
  
    public Connection getConnection() throws SQLException, ClassNotFoundException
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?opteste", "root", "");
        return conn;
    }
}
