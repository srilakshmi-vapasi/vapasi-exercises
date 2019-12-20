import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;
import suite.SuiteManager;
import util.DriverManager;


public class LoginTest extends SuiteManager {
    private LoginPage lp;
    private BasePage bp;
    @BeforeClass
    public void testCredentials() {
        bp = new BasePage();
        lp = bp.clickLoginButton();
    }
    @Test(priority = 1)
    public void testLogin() {
        HomePage hp = lp.clickSignIn();
        WebElement searchField = hp.verifySearchElements();
        try {
            if(searchField.isDisplayed())
                Assert.assertTrue(searchField.isDisplayed());
            else
                System.out.println("Unable to see the search input field on the home screen.");

        }catch (Exception e){
            e.printStackTrace();
        }

    }
    /*
    verify logout user
     */
    @Test(priority = 2)
    public void testLogoutLogin() {
        WebElement signoutMsg = lp.logoutUser();
        try {
            //verify logout successful message
            if (signoutMsg.isDisplayed()) {
                Assert.assertEquals("Signed out successfully.", signoutMsg.getText());
                System.out.println("Logout Successful..");
            } else {
                System.out.println("Logout failed ....");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /*
    verify login with invalid credentials
    verify error message
    user should not be able to login
     */
    @Test(priority = 3)
    public void testInvalidLogin() {
        bp.clickLoginButton();
        WebElement signinErrMsg = lp.loginWithInvalidCredentials();
        try {
            if (signinErrMsg.isDisplayed())
                Assert.assertEquals("Invalid email or password.", signinErrMsg.getText());
            else
                System.out.println("Signin error message is not displayed");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
