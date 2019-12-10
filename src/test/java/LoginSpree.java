import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import suite.SuiteManager;
import testdata.LoginCredentials;
import util.ConfigFileReader;
import util.DriverManager;
import java.util.concurrent.TimeUnit;

public class LoginSpree extends SuiteManager {
    /*private String email;
    private String pwd;
    @BeforeTest
    public void readLoginProps() {
        email = ConfigFileReader.getProperty("email");
        pwd = ConfigFileReader.getProperty("password");
    }*/
    //@Test (dataProvider = "LoginCredentials", dataProviderClass = LoginCredentials.class)
    public void verifyLoginLogout(String email,String pwd)  {
        if(DriverManager.driver.findElements(By.linkText("Logout")).size()>0) {
            DriverManager.driver.findElement(By.linkText("Logout")).click();
        }
        DriverManager.driver.findElement(By.id("link-to-login")).click();
        DriverManager.driver.findElement(By.id("spree_user_email")).sendKeys(email);
        DriverManager.driver.findElement(By.id("spree_user_password")).sendKeys(pwd);
        DriverManager.driver.findElement(By.name("commit")).click();
        String st = DriverManager.driver.findElement(By.xpath("//*[@id='content']/div[1]")).getText();
        //verify login successful message
        if(DriverManager.driver.findElement(By.xpath("//*[@id='content']/div[1]")).isDisplayed()) {
            Assert.assertEquals("Logged in successfully", st);
            System.out.println("Login Successful..");
        } else{
            System.out.println("Login failed ....");
        }

    }
    @Test
    public void testLogin() {
        BasePage bp = new BasePage();
        LoginPage lp = bp.clickLoginButton();
        HomePage hp = lp.clickSignIn();
    }
}
