package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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

    public HomePage clickSignIn() {
        email.sendKeys(ConfigFileReader.getProperty("email"));
        pwd.sendKeys(ConfigFileReader.getProperty("password"));
        WebDriverWait wait = new WebDriverWait(DriverManager.driver,3000);
        wait.until(ExpectedConditions.visibilityOf(signIn));
        signIn.click();
        return new HomePage();
    }
}
