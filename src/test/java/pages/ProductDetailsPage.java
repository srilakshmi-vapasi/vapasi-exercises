package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import suite.SuiteManager;
import util.DriverManager;

public class ProductDetailsPage extends SuiteManager {
    public ProductDetailsPage(){
        PageFactory.initElements(DriverManager.driver,this);
    }

    @FindBy(id = "main-image")
    public static WebElement prodImage;

    @FindBy(css = ".product-title.mt-2")
    public static WebElement prodName;

    @FindBy(xpath = "//*[@id=\"product-description\"]/div[1]")
    public static WebElement prodDesc;

    @FindBy(id = "product_price")
    public static WebElement price;

    @FindBy(id = "product-properties")
    public static WebElement prodProps;

    @FindBy(css = ".lead.price.selling")
    public static WebElement priceValue;

    @FindBy(id = "add-to-cart-button")
    public static WebElement addToCart;

    @FindBy(id = "quantity")
    public static WebElement qty;
    /*
    Verify displaying add to cart button in the product details page
     */
    public WebElement verifyProdDetailsPageElements() {
            return addToCart;
    }

    /*
    Verify displaying product image in product description page
     */
    public WebElement verifyProdImage() {
        return prodImage;
    }
    /*
   Verify displaying product name in product description page
    */
    public WebElement verifyProdName() {
        return prodName;
    }

    /*
   Verify displaying product price in product description page
    */
    public WebElement verifyProdPrice() {
        return priceValue;
    }

    /*
    Click on add-to-cart button
    Observe displaying cart page with products information
     */
    public ShoppingCartPage verifyProdInCart() {
        if(addToCart.isDisplayed())
            addToCart.click();
        return new ShoppingCartPage();
    }

}
