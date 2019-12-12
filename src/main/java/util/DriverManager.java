package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {
    public static WebDriver driver;
    private static String browser;
    private static final String USERNAME = "srilashmi1";
    private static final String AUTOMATE_KEY = "jQAWtTRV2Mhp3qWTyz9N";
    private static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

    //Reading the Driver from testconfig.properties file and initialize driver
    public static WebDriver getDriverInstance()  {
        String chrome_driver_path = System.getProperty("user.dir")+ConfigFileReader.getProperty("chrome_driver_path");
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

    //Reading the driver from TestNG.xml file and initialize driver - selenium grid (hub)
    public static WebDriver getDriverInstance(String browser) throws MalformedURLException {
        if(browser.equals("chrome")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("browser", "Chrome");
            caps.setCapability("browser_version", "62.0");
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("resolution", "1024x768");
            caps.setCapability("name", "Bstack-[Java] Sample Test");

            driver = new RemoteWebDriver(new URL(URL), caps);

        } else if(browser.equals("firefox")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("os", "Windows");
            caps.setCapability("os_version", "10");
            caps.setCapability("browser", "Firefox");
            caps.setCapability("browser_version", "70.0");
            caps.setCapability("browserstack.local", "false");
            caps.setCapability("browserstack.selenium_version", "3.10.0");

            driver = new RemoteWebDriver(new URL(URL),caps);
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
