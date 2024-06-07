package pages;

import AbstractComponents.AbstractComponent;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderConfirmationPage extends AbstractComponent {
    WebDriver driver;

    public OrderConfirmationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(css = "h1.hero-primary")
    WebElement confirmationMessagetxt;

    @FindBy(xpath = "(//label[contains(text(),'History')])")
    WebElement OrderHistorybtn;

    public OrderHistoryPage isOrderConfirmationPage() {
        waitForWebElementToAppear(confirmationMessagetxt);
        boolean isOrderConfirmationPage = driver.getCurrentUrl().contains("thanks");
        Assert.isTrue(isOrderConfirmationPage, "It is not order confirmation page");
        return new OrderHistoryPage(driver);


    }

    public void isOrderConfirmed(String confirmationMsg) {
        boolean isMatched = confirmationMessagetxt.getText().equals(confirmationMsg);
        Assert.isTrue(isMatched, "confirmation message didi not appears");
    }

    public void goToOrderHistoryPage() throws InterruptedException {
        waitForWebElementToAppear(OrderHistorybtn);
        OrderHistorybtn.click();

    }
}
