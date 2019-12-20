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

    /*
    search by a product name, read from props file
    search results should be displayed
    validate all the products displayed should contain search keyword in product name
     */
    public List<WebElement>  verifyDisplayingSearchResults() {
        if(searchResultsTable.isDisplayed()) {
            Assert.assertTrue(searchResultsTable.isDisplayed());
            //get List of products under products table
            prod = DriverManager.driver.findElements(By.tagName("span"));
        } else {
            System.out.println("No Products for the search criteria...");
        }
        return prod;
    }

    /*
    search by a product category
    From the search results, select a product
    Verify the corresponding product details page displayed
     */
    public ProductDetailsPage verifySelectingProdFromSearchResults() {
        if(searchResultsTable.isDisplayed()) {
            Assert.assertTrue(searchResultsTable.isDisplayed());
            prod = DriverManager.driver.findElements(By.tagName("div"));
            if (prod.size() > 1)
                DriverManager.driver.findElement(By.xpath("//*[@id='products']/div[2]")).click();
        } else {
            System.out.println("No Products for the search criteria");
        }
        return new ProductDetailsPage();
    }
}
