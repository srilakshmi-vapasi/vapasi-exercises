package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    private static Properties prop;

    public static void readPropertiesFile() {
        String propertyFile = "testconfig.properties";
        FileInputStream fis = null;

        try {
            prop = new Properties();
            String configFilePath =System.getProperty("user.dir")+"/src/test/testdata/config/"+propertyFile;
            fis = new FileInputStream(configFilePath);
            prop.load(fis);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        readPropertiesFile();
        return prop.getProperty(key);
    }

    /*public static void main(String[] args) throws Exception {
        ConfigFileReader cfg = new ConfigFileReader();
        System.out.println("*******"+getProperty("browser"));
        System.out.println("*******"+getProperty("chrome_driver_path"));

    }*/

}
