package ru.appline.framework.managers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class PropManager {

    private final Properties properties = new Properties();
    private static PropManager INSTANCE = null;

    private PropManager() {
        try {
            properties.load(new FileInputStream(
                    new File("src/main/resources/" +
                            System.getProperty("env", "environment") + ".properties")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static PropManager getPropManager() {
        if (INSTANCE == null) {
            INSTANCE = new PropManager();
        }
        return INSTANCE;
    }

    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }


    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
