import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;
import suite.SuiteManager;
import testdata.LoginCredentials;
import util.ConfigFileReader;
import util.DriverManager;

import java.util.List;

public class SearchProducts extends SuiteManager {

    //@Test
    public void searchForItem() {
        DriverManager.driver.findElement(By.id("keywords")).sendKeys(ConfigFileReader.getProperty("searchItem"));
        //verify search button is present and click
        if(DriverManager.driver.findElement(By.cssSelector(".btn.btn-success")).isDisplayed()) {
            DriverManager.driver.findElement(By.cssSelector(".btn.btn-success")).click();
        } else {
            System.out.println("Search button is not visible...");
        }

        //Assert.assertTrue(DriverManager.driver.findElement(By.id("products")).isDisplayed());
        //Verify Products List Table is visible
        WebElement el = DriverManager.driver.findElement(By.id("products"));
        if(el.isDisplayed()) {
            //get List of products under products table
            List prod = DriverManager.driver.findElements(By.tagName("div"));
            if (prod.size() > 1)
                //select second product from the list of product
                DriverManager.driver.findElement(By.xpath("//*[@id='products']/div[2]")).click();

            //Assert.assertTrue(DriverManager.driver.findElement(By.id("add-to-cart-button")).isDisplayed());
        } else {
            System.out.println("No Products for the search criteria");
        }
        if(DriverManager.driver.findElement(By.id("add-to-cart-button")).isDisplayed()) {
            DriverManager.driver.findElement(By.id("add-to-cart-button")).click();
        } else
            System.out.println("Add to cart button not displayed...");

        Assert.assertTrue(DriverManager.driver.findElement(By.id("checkout-link")).isDisplayed());

        WebElement elem = DriverManager.driver.findElement(By.cssSelector("#line_items > tr > td.cart-item-description > h4 > a"));
        Assert.assertEquals("Spree Bag",elem.getText());

        DriverManager.driver.findElement(By.id("checkout-link")).click();

    }
    @Test
    public void testSearchProductResults() throws InterruptedException {
        BasePage base = new BasePage();
        LoginPage login = base.clickLoginButton();
        HomePage home = login.clickSignIn();
        SearchPage search = home.verifySearchElements();
        List<WebElement> li = search.verifyDisplayingSearchResults();
        for(int i=0; i<li.size(); i+=3) {
            System.out.println(li.get(i).getText());
            Assert.assertTrue(li.get(i).getText().contains(ConfigFileReader.getProperty("searchItem")));
        }
        Thread.sleep(3000);
    }
}
