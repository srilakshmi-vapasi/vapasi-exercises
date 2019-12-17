package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import suite.SuiteManager;
import util.DriverManager;

import java.util.List;

public class SearchPage extends SuiteManager {
    private List<WebElement> prod;

    public SearchPage(){
        PageFactory.initElements(DriverManager.driver,this);
    }

    @FindBy(id="products")
    private WebElement searchResultsTable;

    @FindBy(id = "add-to-cart-button")
    private WebElement addtocartbtn;

    public List<WebElement>  verifyDisplayingSearchResults() {

        if(searchResultsTable.isDisplayed()) {
            Assert.assertTrue(searchResultsTable.isDisplayed());
            //get List of products under products table
            prod = DriverManager.driver.findElements(By.tagName("span"));
           /* for(int i=0; i<prod.size(); i+=3) {
                System.out.println(prod.get(i).getText());
            }*/
        } else {
            System.out.println("No Products for the search criteria...");
        }

        return prod;
    }
}
