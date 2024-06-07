package pages;

import AbstractComponents.AbstractComponent;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PaymentPage extends AbstractComponent {
    WebDriver driver;

    public PaymentPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(text(),' Payment Method ')]")
    WebElement txtPaymentPAge;

    @FindBy(css = "input[placeholder='Select Country")
    WebElement countryInputField;

    @FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
    WebElement countryButton;
    @FindBy(xpath = "//div[@class='actions']/child::a")
    WebElement placeOrderButton;
    By countryResults = By.cssSelector(".ta-results");


    public OrderConfirmationPage  isPaymentPage(){
        boolean isPaymentPage = txtPaymentPAge.getText().contains("Payment Method");
        Assert.assertTrue(isPaymentPage);
        return new OrderConfirmationPage(driver);
    }
    public void countrySelection(String countryName) throws InterruptedException {
        countryInputField.sendKeys(countryName);
        waitForElementToAppear(countryResults);
        countryButton.click();
        Actions a = new Actions(driver);
        a.scrollToElement(placeOrderButton).build().perform();


    }
    public void clickPlaceOrderButton () throws InterruptedException {
        Actions a = new Actions(driver);
        Thread.sleep(2000);
        a.moveToElement(placeOrderButton).click().build().perform();

    }
}
