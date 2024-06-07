package pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.List;

public class ProductCataloguePage extends AbstractComponent {
    WebDriver driver;

    public ProductCataloguePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //List<WebElement> cardList = driver.findElements(By.cssSelector(".card-body"))

    @FindBy(xpath = "(//p[contains(text(),'Home')])[2]")
    WebElement CatalaguePagetxt;
    @FindBy(css = ".card-body")
    List<WebElement> products;
    @FindBy(css = ".ng-animating")
    WebElement spinner;
    @FindBy(xpath = "//button[@class='btn btn-custom' and contains(text(),'Cart')]")
    WebElement cartPageButton;

    By productBy = By.cssSelector(".card-body");
    By addToCart = By.cssSelector(".card-body button:last-of-type");
    By toastMessage = By.cssSelector("#toast-container");


    //confirmation of catalogue page
    public CartPage isCataloguePage(){
        boolean isCataloguePage= CatalaguePagetxt.getText().contains("Home");
        Assert.assertTrue(isCataloguePage);
        return new CartPage(driver);
    }
    //Actions in product catalogue
    public List<WebElement> getProducts() {
        waitForElementToAppear(productBy);
        return products;
    }

    public WebElement getProductByName(String productName) {
        WebElement prod = getProducts().stream().filter(Product -> Product.findElement(By.tagName("b")).getText().equals(productName)).findFirst().orElse(null);
        return prod;
    }

    //Adding Product to the card
    public void addProductToCart(String productName) throws InterruptedException {
        WebElement prod = getProductByName(productName);
        prod.findElement(addToCart).click();
        waitForElementToAppear(toastMessage);
        Thread.sleep(1000);
        waitForElementToDisappear(spinner);

    }
    public  void clickOnCartButton(){
        cartPageButton.click();
    }


}
