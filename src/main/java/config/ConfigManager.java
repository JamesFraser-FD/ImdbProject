package config;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static final Properties config;

    static {
        config = new Properties();
        try {
            config.load(new FileReader("src/main/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String imdbFileLocation() {
        return config.getProperty("imdbFileLocation");
    }
    public static String outputFileLocation() {
        return config.getProperty("outputFileLocation");
    }
}
