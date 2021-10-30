package props;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class ConfigProps {

    private static final String propertiesFilename = "config.properties";
    private static Properties properties;

    public static Optional<String> getValue(String propertyName) {

        if(properties == null) {

            if(!getProps()) {

                return Optional.empty();
            }
        }

        return Optional.ofNullable(properties.getProperty(propertyName));
    }

    private static boolean getProps() {

        try {
            properties = new Properties();

            InputStream inputStream = ConfigProps.class.getClassLoader().getResourceAsStream(propertiesFilename);

            if(inputStream != null) {
                properties.load(inputStream);
            }
            else {
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }
}
