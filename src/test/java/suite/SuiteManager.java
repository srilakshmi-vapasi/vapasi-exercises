package suite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import util.ConfigFileReader;
import util.DriverManager;

import java.util.concurrent.TimeUnit;

public class SuiteManager {
    private static WebDriver driver;
    private static ConfigFileReader cfg;

    @BeforeSuite
    public void startDriver() throws Exception {
        driver = DriverManager.getDriverInstance();
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
