package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import suite.SuiteManager;
import util.ConfigFileReader;
import util.DriverManager;

public class LoginPage extends SuiteManager {
    public LoginPage(){
        PageFactory.initElements(DriverManager.driver,this);
    }
    @FindBy(id = "spree_user_email")
    private WebElement email;

    @FindBy(id = "spree_user_password")
    private WebElement pwd;

    @FindBy(name = "commit")
    private WebElement signIn;

    @FindBy(xpath = "//*[@id='content']/div[1]")
    private WebElement signInSuccessMsg;
    /*
    Enter login user name and password read from properties file
    Click on signin button
    Verify login success message
     */
    public HomePage clickSignIn() {
        email.sendKeys(ConfigFileReader.getProperty("email"));
        pwd.sendKeys(ConfigFileReader.getProperty("password"));

        new WebDriverWait(DriverManager.driver,3000).until(ExpectedConditions.visibilityOf(signIn));
        signIn.click();

        //verify login successful message
        if(signInSuccessMsg.isDisplayed()) {
            Assert.assertEquals("Logged in successfully", signInSuccessMsg.getText());
            System.out.println("Login Successful..");
        } else{
            System.out.println("Login failed ....");
        }

        return new HomePage();
    }
}
