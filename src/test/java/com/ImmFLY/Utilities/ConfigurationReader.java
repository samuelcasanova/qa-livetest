package com.ImmFLY.Utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;
    static {
        try{
            String path="configuration.properties";
            FileInputStream inputStream = new FileInputStream(path);
            properties=new Properties();
            properties.load(inputStream);
            inputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getValue(String key){
        return properties.getProperty(key);
    }
}
