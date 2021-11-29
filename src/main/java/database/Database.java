package database;

import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static database.DatabaseUtils.*;

public interface Database {

    Connection connection = getConnection();

    static Connection getConnection() {

        try {

            /*Class.forName(getDriver());
            return DriverManager.getConnection(getConnectionURI(), getDbUser(), getDbPassword());*/
            // TODO: REALLY FUCKING TIRED OF THIS SHIT
            URI dbUri = new URI(System.getenv("DATABASE_URL"));

            String username = dbUri.getUserInfo().split(":")[0];
            String password = dbUri.getUserInfo().split(":")[1];
            String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath() + "?sslmode=require";

            return DriverManager.getConnection(dbUrl, username, password);
        }
        catch (Exception e) {

            System.err.println(e.getMessage());
            return null;
        }
    }
}
