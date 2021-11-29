package utils;

import props.ConfigProps;

import java.util.Optional;

import static props.ConfigProps.getValue;

// TODO: To add unit tests for each static method (not a priority right now)
public class SessionUtils {

    private static final String environmentPropertyName = "environment";
    private static final String developEnvValue = "develop";
    private static final String testEnvValue = "test";
    private static final String prodEnvValue = "lostandfound.env";

    public static boolean isProductionEnvironment() {

        return !System.getenv(prodEnvValue).isEmpty();
    }

    public static boolean isDevelopEnvironment() {

        Optional<String> environmentOptional = getValue(environmentPropertyName);

        return environmentOptional.isPresent() && environmentOptional.get().equals(developEnvValue);
    }

    public static boolean isTestEnvironment() {

        Optional<String> environmentOptional = getValue(environmentPropertyName);

        return environmentOptional.isPresent() && environmentOptional.get().equals(testEnvValue);
    }
}
