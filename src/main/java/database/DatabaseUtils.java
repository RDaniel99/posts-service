package database;

import props.ConfigProps;

import static utils.SessionUtils.isDevelopEnvironment;

public class DatabaseUtils {

    private static final String developDbName = "database.dbname";
    private static final String testDbName = "database.test_dbname";
    private static final String dbUser = "database.user";
    private static final String dbPassword = "database.password";
    private static final String dbDriver = "database.driver";

    public static String getDbUser() {

        return ConfigProps.getValue(dbUser).get();
    }

    public static String getDbPassword() {

        return ConfigProps.getValue(dbPassword).get();
    }

    public static String getDriver() {

        return ConfigProps.getValue(dbDriver).get();
    }

    public static String getConnectionURI() {

        StringBuilder builder = new StringBuilder();

        builder.append("jdbc:mysql://localhost:3306/");
        appendDbName(builder);
        builder.append("?characterEncoding=latin1&useConfigs=maxPerformance&useSSL=false");


        return builder.toString();
    }

    private static void appendDbName(StringBuilder builder) {

        if(isDevelopEnvironment()) {

            builder.append(ConfigProps.getValue(developDbName).get());
        }
        else {

            builder.append(ConfigProps.getValue(testDbName).get());
        }
    }
}
