package pages;

import com.sun.tools.jxc.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import suite.SuiteManager;
import util.ConfigFileReader;
import util.DriverManager;

public class HomePage extends SuiteManager {

    public HomePage(){
        PageFactory.initElements(DriverManager.driver,this);
    }

    @FindBy(id="keywords")
    private WebElement searchField;
    /*
    Verify search input field is present on the Home Page
    Read product to search from the config file
    Enter a product in the search input field
    click on search button to see the results
     */
    public WebElement verifySearchElements() {
        if(searchField.isDisplayed()){
            searchField.click();
            searchField.clear();
            searchField.sendKeys(ConfigFileReader.getProperty("searchItem"));
        }
        if(DriverManager.driver.findElement(By.cssSelector(".btn.btn-success")).isDisplayed()) {
            DriverManager.driver.findElement(By.cssSelector(".btn.btn-success")).click();
        } else {
            System.out.println("Search button is not visible...");
        }
        return searchField;
    }

    public SearchPage verifySearchResultsCat() {
        if(searchField.isDisplayed()){
            searchField.sendKeys(ConfigFileReader.getProperty("searchItem"));
        }
        if(DriverManager.driver.findElement(By.cssSelector(".btn.btn-success")).isDisplayed())
            DriverManager.driver.findElement(By.cssSelector(".btn.btn-success")).click();

        return new SearchPage();
    }



}
