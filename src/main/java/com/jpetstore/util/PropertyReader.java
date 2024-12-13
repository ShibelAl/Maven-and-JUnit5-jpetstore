package com.jpetstore.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyReader {

    private static volatile PropertyReader propInstance;

    private PropertyReader(){

    }

    public static synchronized PropertyReader getInstance(){
        if(propInstance == null){
            propInstance = new PropertyReader();
        }
        return propInstance;
    }


    /**
     * Method to return property value
     */
    public String getProperty(String propertyName) {
        Properties properties = new Properties();

        // Using try-with-resources to ensure the InputStream is closed automatically
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("application.properties")) {
            if (inputStream == null) {
                throw new IOException("Properties file not found.");
            }

            properties.load(inputStream);
            String value = properties.getProperty(propertyName);

            if (value != null) {
                return value;
            } else {
                throw new IllegalArgumentException("Property '" + propertyName + "' not found in the file.");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + e.getMessage(), e);
        }
    }
}
