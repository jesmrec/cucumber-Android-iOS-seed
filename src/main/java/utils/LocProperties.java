package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;

import utils.log.Log;

public class LocProperties {

    private static Properties properties = null;

    private LocProperties() {
        try {
            properties = new Properties();
            FileInputStream inputStream = new FileInputStream("execution.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            Log.log(Level.SEVERE, "IO Exception: " + e.getMessage());
        }
    }

    public static Properties getProperties() {
        if (properties == null) {
            new LocProperties();
        }
        return properties;
    }
}

