package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigFileReader {
    private Properties prop;

    public ConfigFileReader() {
        String propertyFile = "testconfig.properties";
        FileInputStream inputFileStream = null;

        try {
            this.prop = new Properties();
            String configFilePath =System.getProperty("user.dir")+"/src/test/resources/config/"+propertyFile;
            FileInputStream fis = new FileInputStream(new File(configFilePath));

            prop.load(fis);

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return prop.getProperty(key);
    }

    public static void main(String[] args) throws Exception {
        ConfigFileReader cfg = new ConfigFileReader();
        System.out.println("*******"+cfg.getProperty("browser"));

    }

}
