package tools;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {
    private static final Properties properties = new Properties();

    static {
        try (InputStream configInput = PropertiesLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            if (configInput != null) {
                properties.load(configInput);
            } else {
                System.err.println("Warning: config.properties not found");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading config.properties", e);
        }

        try (InputStream localInput = PropertiesLoader.class.getClassLoader().getResourceAsStream("local.properties")) {
            if (localInput != null) {
                Properties localProps = new Properties();
                localProps.load(localInput);
                properties.putAll(localProps); // override or add keys from local.properties
            } else {
                System.out.println("Info: local.properties not found, using config.properties only");
            }
        } catch (IOException e) {
            throw new RuntimeException("Error loading local.properties", e);
        }
    }

    public static String getProperties(String key) {
        return properties.getProperty(key);
    }
}