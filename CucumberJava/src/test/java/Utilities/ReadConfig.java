package Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    Properties prop;

    public ReadConfig() {
        try {
            // Create Properties object
            prop = new Properties();

            // Load config file
            FileInputStream fis =
                    new FileInputStream("config.properties");

            // Read properties
            prop.load(fis);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }

  
}