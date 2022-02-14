package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

    Properties properties;

    public ConfigDataProvider() throws IOException {
        File src = new File("Config/Config.properties");
        FileInputStream fileInputStream = new FileInputStream(src);
        properties = new Properties();
        properties.load(fileInputStream);
    }

    public String getDataFromConfig(String key) {
        return properties.getProperty(key);
    }

    public String getBrowser() {
        return properties.getProperty("Browser");
    }

    public String getURL() {
        return properties.getProperty("qaUrl");
    }
}
