import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginSpree {
    public static WebDriver driver;
    public static String email;
    public static String pwd;

    @BeforeClass
    public void setupTestData() {
        System.setProperty("webdriver.chrome.driver","/Users/techops/Downloads/chromedriver");
        driver = new ChromeDriver();
        email = "test123@gmail.com";
        pwd = "test123";
        driver.get("https://spree-vapasi-prod.herokuapp.com");
    }

    @Test
    public void verifyLoginLogout() throws Exception {
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(email);
        driver.findElement(By.id("spree_user_password")).sendKeys(pwd);
        driver.findElement(By.name("commit")).click();
        String st = driver.findElement(By.xpath("//*[@id='content']/div[1]")).getText();

        //Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/div[1]")).isDisplayed());
        //verify login successful message
        if(driver.findElement(By.xpath("//*[@id='content']/div[1]")).isDisplayed()) {
            Assert.assertEquals("Logged in successfully", st);
            System.out.println("Login Successful..");
        } else{
            System.out.println("Login failed ....");
        }
        driver.close();
    }
}
