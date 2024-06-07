package pages;

import AbstractComponents.AbstractComponent;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends AbstractComponent {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "//h1[contains(text(),'My Cart')]")
    WebElement txtCartPage;
    @FindBy(css = ".cartSection h3")
    List<WebElement> itemsInCart;
    @FindBy(xpath = "//button[contains(.,'Checkout')]")
    WebElement proceedToCheckOutbtn;


    public PaymentPage iscartPage() {
        boolean isMatched = txtCartPage.getText().equalsIgnoreCase("My Cart");
        Assert.assertTrue(isMatched);
        return new PaymentPage(driver);
    }

    public void ProductValidation(String productName) {
        boolean isValidProduct = itemsInCart.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(isValidProduct);
    }

    public void clickOnCheckout() throws InterruptedException {
        Actions a = new Actions(driver);
        Thread.sleep(5000);
        scrolling();
        Thread.sleep(5000);
        a.scrollToElement(proceedToCheckOutbtn).click().build().perform();

        a.moveToElement(proceedToCheckOutbtn).click().build().perform();

    }

}
