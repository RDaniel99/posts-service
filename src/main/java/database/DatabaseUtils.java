package database;

import props.ConfigProps;

import static utils.SessionUtils.isDevelopEnvironment;

public class DatabaseUtils {

    private static final String developDbName = "database.dbname";
    private static final String testDbName = "database.test_dbname";
    private static final String dbUser = "database.user";
    private static final String dbPassword = "database.password";
    private static final String dbDriver = "database.driver";
    private static final String dbURI = "database.URI";

    public static String getDbUser() {

        String value = System.getenv(dbUser);

        if(!value.isEmpty()) {
            return value;
        }

        return ConfigProps.getValue(dbUser).get();
    }

    public static String getDbPassword() {

        String value = System.getenv(dbPassword);

        if(!value.isEmpty()) {
            return value;
        }

        return ConfigProps.getValue(dbPassword).get();
    }

    public static String getDriver() {

        String value = System.getenv(dbDriver);

        if(!value.isEmpty()) {
            return value;
        }

        return ConfigProps.getValue(dbDriver).get();
    }

    public static String getConnectionURI() {

        String value = System.getenv(dbURI);

        if(!value.isEmpty()) {

            return value;
        }

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
