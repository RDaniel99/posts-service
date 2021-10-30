package props;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConfigPropsTest {

    @Test
    public void testIfCanReadFromConfigFile() {

        // Check [General] section
        assertNotNull(ConfigProps.getValue("environment"));

        // Check [Database] section
        assertNotNull(ConfigProps.getValue("database.dbname"));
        assertNotNull(ConfigProps.getValue("database.user"));
        assertNotNull(ConfigProps.getValue("database.password"));

        // Check [Tests] section
        assertNotNull(ConfigProps.getValue("database.test_dbname"));
    }
}
