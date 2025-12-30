package core;
import java.util.Properties;
import java.io.InputStream;

public class ConfigReader {

    private Properties props = new Properties();  // Now , "props" object has the Properties class methods

    public ConfigReader() {  // Locate the file through the classloader
        try {
            InputStream inputStream =
                    getClass().getClassLoader().getResourceAsStream("config.properties");

            if (inputStream == null) {
                throw new RuntimeException("config.properties not found");
            }

            props.load(inputStream); // Props has access to the key-value pairs in "config.properties"

        } catch (Exception e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    public String getBaseUrl(){
        return props.getProperty("base.url");
    }

    public String getUserName(){
        return props.getProperty("auth.username");
    }

    public String getPassword(){
        return props.getProperty("auth.password");
    }
}
