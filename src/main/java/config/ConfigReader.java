package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
    private Properties properties;

    public ConfigReader(String filePath) {
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//resources//config.properties");) {
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBrowser() {
        return properties.getProperty("browser");
    }

    // Add methods to retrieve other configuration properties
}
