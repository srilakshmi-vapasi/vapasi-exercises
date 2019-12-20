import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import java.lang.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import suite.SuiteManager;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AccountCreationTest extends SuiteManager {
    public static WebDriver driver;
    public static String email;
    public static String pwd;

    //constructor to initialize web driver
    public AccountCreationTest() {
        System.setProperty("webdriver.chrome.driver","/Users/techops/Downloads/chromedriver");
        driver = new ChromeDriver();
        email = "test123@gmail.com";
        pwd = "test123";
        driver.get("https://spree-vapasi-prod.herokuapp.com");
    }

    public static void main(String args[]) throws Exception {
        AccountCreationTest sc = new AccountCreationTest();
        //sc.createUserAccount();
        sc.checkoutProductFromSearch();
    }

    public static void createUserAccount() throws Exception{
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.linkText("Create a new account")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys("test__123@gmail.com");
        driver.findElement(By.id("spree_user_password")).sendKeys("test1233");
        driver.findElement(By.id("spree_user_password_confirmation")).sendKeys("test1233");
        driver.findElement(By.name("commit")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/div[1]")).isDisplayed());
        //WebElement el = driver.findElement(By.className("alert alert-notice"));


    }

    public static void checkoutProductFromSearch() throws Exception {
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        driver.findElement(By.id("link-to-login")).click();
        driver.findElement(By.id("spree_user_email")).sendKeys(email);
        driver.findElement(By.id("spree_user_password")).sendKeys(pwd);
        driver.findElement(By.name("commit")).click();
        String st = driver.findElement(By.xpath("//*[@id='content']/div[1]")).getText();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='content']/div[1]")).isDisplayed());
        //verify login successful message
        if(driver.findElement(By.xpath("//*[@id='content']/div[1]")).isDisplayed()) {
            Assert.assertEquals("Logged in successfully", st);
            System.out.println("Login Successful..");
        } else{
            System.out.println("Login failed ....");
        }

        driver.findElement(By.id("keywords")).sendKeys("Bag");
        //verify search button is present and click
        if(driver.findElement(By.cssSelector(".btn.btn-success")).isDisplayed()) {
            driver.findElement(By.cssSelector(".btn.btn-success")).click();
        } else {
            System.out.println("Search button is not visible...");
        }

        //Assert.assertTrue(driver.findElement(By.id("products")).isDisplayed());
        //Verify Products List Table is visible
        WebElement el = driver.findElement(By.id("products"));
        if(el.isDisplayed()) {
            //get List of products under products table
            List prod = driver.findElements(By.tagName("div"));
            if (prod.size() > 1)
                //select second product from the list of product
                driver.findElement(By.xpath("//*[@id='products']/div[2]")).click();

            //Assert.assertTrue(driver.findElement(By.id("add-to-cart-button")).isDisplayed());
        } else {
            System.out.println("No Products for the search criteria");
        }
        if(driver.findElement(By.id("add-to-cart-button")).isDisplayed()) {
            driver.findElement(By.id("add-to-cart-button")).click();
        } else
            System.out.println("Add to cart button not displayed...");

        Assert.assertTrue(driver.findElement(By.id("checkout-link")).isDisplayed());

        WebElement elem = driver.findElement(By.cssSelector("#line_items > tr > td.cart-item-description > h4 > a"));
        Assert.assertEquals("Spree Bag",elem.getText());

        driver.findElement(By.id("checkout-link")).click();

    }



}
