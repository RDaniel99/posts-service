package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static database.DatabaseUtils.*;

public interface Database {

    Connection connection = getConnection();

    static Connection getConnection() {

        try {

            Class.forName(getDriver());
            return DriverManager.getConnection(getConnectionURI(), getDbUser(), getDbPassword());
        }
        catch (Exception e) {

            System.err.println(e.getMessage());
            return null;
        }
    }
}
