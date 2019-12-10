package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getDriverInstance()  {
        String chrome_driver_path = System.getProperty("user.dir")+ConfigFileReader.getProperty("chrome_driver_path");
        //System.out.println("chrome driver path is :::"+chrome_driver_path);
        System.setProperty("webdriver.chrome.driver", chrome_driver_path);

        if(ConfigFileReader.getProperty("browser").equals("chrome")) {
            driver = new ChromeDriver();
        }
        else if(ConfigFileReader.getProperty("browser").equals("firefox")) {
            driver = new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    /*public static void main(String[] args) {
        DriverManager dmg = new DriverManager();

        //getDriver();
    }*/
}
