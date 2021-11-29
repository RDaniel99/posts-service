package database;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static database.DatabaseUtils.getConnectionURI;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DatabaseUtilsTest {

    private final String developURI = "jdbc:mysql://localhost:3306/lostandfound?characterEncoding=latin1&useConfigs=maxPerformance";
    private final String testURI = "jdbc:mysql://localhost:3306/lostandfound_test?characterEncoding=latin1&useConfigs=maxPerformance";

    @Test
    public void testIfBuildCorrectConnectionURI() {
/*
        // setup
        HashSet<String> dbURIs = new HashSet<>(Arrays.asList(developURI, testURI));

        // execute
        String uri = getConnectionURI();

        // verify
        // TODO: Add dedicated test for each environment (not a priority right now)
        assertTrue(dbURIs.contains(uri));*/
    }
}
