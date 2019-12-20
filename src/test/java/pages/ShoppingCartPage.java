package pages;

import org.openqa.selenium.support.PageFactory;
import suite.SuiteManager;
import util.DriverManager;

public class ShoppingCartPage extends SuiteManager {

    public ShoppingCartPage(){
        PageFactory.initElements(DriverManager.driver,this);
    }
}
