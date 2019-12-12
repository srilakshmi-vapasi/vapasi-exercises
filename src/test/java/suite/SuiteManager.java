package suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import util.ConfigFileReader;
import util.DriverManager;

import java.util.concurrent.TimeUnit;

public class SuiteManager {
    private static WebDriver driver;
    private static ConfigFileReader cfg;

    @BeforeSuite
    @Parameters({"browser"})
    //@DataProvider(name = "BrowserData")
    public void startDriver(String browser) throws Exception {
        System.out.println("Browser is ...."+browser);
        driver = DriverManager.getDriverInstance(browser);
    }

    @AfterSuite
    public void quitDriver() throws Exception {
        DriverManager.driver.quit();
    }

    @BeforeClass
    public void launchURL() {
        DriverManager.driver.get(ConfigFileReader.getProperty("base_url"));
    }
}
