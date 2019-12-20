import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import suite.SuiteManager;
import testdata.LoginCredentials;
import util.ConfigFileReader;
import util.DriverManager;

import java.util.List;

public class SearchProductsTest extends SuiteManager {
    private SearchPage search;
    @BeforeClass
    public void testSearchResults() {
        BasePage base = new BasePage();
        LoginPage login = base.clickLoginButton();
        HomePage home = login.clickSignIn();
        WebElement el = home.verifySearchElements();
    }
    @Test(priority = 1)
    public void testSearchProductResults()  {
        List<WebElement> li = search.verifyDisplayingSearchResults();
        try {
            for (int i = 0; i < li.size(); i += 3) {
                System.out.println(li.get(i).getText());
                Assert.assertTrue(li.get(i).getText().contains(ConfigFileReader.getProperty("searchItem")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void testSelectProdFromSearchResults() {
        ProductDetailsPage detailsPage = search.verifySelectingProdFromSearchResults();
        WebElement cartbtn = detailsPage.verifyProdDetailsPageElements();
        try {
            Assert.assertTrue(cartbtn.isDisplayed());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
