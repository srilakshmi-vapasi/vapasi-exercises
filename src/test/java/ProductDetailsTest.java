import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import suite.SuiteManager;
import util.ConfigFileReader;

public class ProductDetailsTest extends SuiteManager {
    ProductDetailsPage details;
    @BeforeClass
    public void testSearchResults() {
        BasePage base = new BasePage();
        LoginPage login = base.clickLoginButton();
        HomePage home = login.clickSignIn();
        SearchPage search = home.verifySearchResultsCat();
        details = search.verifySelectingProdFromSearchResults();
    }

    @Test(priority = 1)
    public void testProdImageDisplay() {
        System.out.println("testProdImageDisplay.."+details.verifyProdImage().isDisplayed());
        try {
            Assert.assertTrue(details.verifyProdImage().isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void testProdNameDisplay() {
        System.out.println("testProdNameDisplay.."+details.verifyProdName().isDisplayed());
        try {
            Assert.assertTrue(details.verifyProdName().isDisplayed());
            Assert.assertEquals(details.verifyProdName().getText(), ConfigFileReader.getProperty("prodName"));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority = 3)
    public void testProdPriceDisplay() {
        System.out.println("testProdPriceDisplay.."+details.verifyProdPrice().isDisplayed());
        try {
            Assert.assertTrue(details.verifyProdPrice().isDisplayed());
            Assert.assertEquals("$22.99", details.verifyProdPrice().getText());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
