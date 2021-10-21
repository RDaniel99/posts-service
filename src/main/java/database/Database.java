package database;

import javax.xml.crypto.Data;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface Database {

    Connection connection = getConnection();

    static Connection getConnection() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/lostandfound?characterEncoding=latin1&useConfigs=maxPerformance", "root", "password");
        }
        catch (Exception e) {

            return null;
        }
    }
}
