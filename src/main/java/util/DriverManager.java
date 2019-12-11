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
    public static final String USERNAME = "srilashmi1";
    public static final String AUTOMATE_KEY = "jQAWtTRV2Mhp3qWTyz9N";
    public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";


    public static WebDriver getDriverInstance() throws MalformedURLException {
    //public static WebDriver main(String[] args) throws MalformedURLException {
        //String chrome_driver_path = System.getProperty("user.dir")+ConfigFileReader.getProperty("chrome_driver_path");
        //System.out.println("chrome driver path is :::"+chrome_driver_path);
        //System.setProperty("webdriver.chrome.driver", chrome_driver_path);

        //public static final String USERNAME = "srilashmi1";
        //public static final String AUTOMATE_KEY = "jQAWtTRV2Mhp3qWTyz9N";
        //public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("browser", "Chrome");
        caps.setCapability("browser_version", "62.0");
        caps.setCapability("os", "Windows");
        caps.setCapability("os_version", "10");
        caps.setCapability("resolution", "1024x768");
        caps.setCapability("name", "Bstack-[Java] Sample Test");

        driver = new RemoteWebDriver(new URL(URL), caps);
        /*driver.get("http://www.google.com/ncr");
        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("BrowserStack");
        element.submit();

        System.out.println(driver.getTitle());
        driver.quit();*/

       /* if(ConfigFileReader.getProperty("browser").equals("chrome")) {
            driver = new ChromeDriver();
        }
        else if(ConfigFileReader.getProperty("browser").equals("firefox")) {
            driver = new FirefoxDriver();
        }*/

        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        //driver.manage().window().maximize();

        return driver;
    }

    /*public static void main(String[] args) {
        DriverManager dmg = new DriverManager();

        //getDriver();
    }*/
}
