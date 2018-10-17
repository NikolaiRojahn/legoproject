package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author nr
 */
public class DBConnector {

    private static final String URL = "jdbc:mysql://188.166.86.13:3306/lego";
    private static final String USERNAME = "nikolai";
    private static final String PASSWORD = "nikolai123";

    private static Connection singleton;

    public static void setConnection(Connection con) {
        singleton = con;
    }

    public static Connection connection() throws SQLException {
        if (singleton == null) {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                singleton = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBConnector.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return singleton;
    }

}
