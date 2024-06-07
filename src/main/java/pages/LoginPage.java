package pages;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends AbstractComponent {
    private WebDriver driver;

    @FindBy(xpath = "//h1[@class='login-title']")
    private WebElement loginPageTitle;

    @FindBy(id = "userEmail")
    private WebElement userEmailInput;

    @FindBy(id = "userPassword")
    private WebElement userPasswordInput;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(css = "[class*='flyInOut']")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void goTo() {
        driver.get("https://rahulshettyacademy.com/client/");
    }

    public ProductCataloguePage verifyLoginPage() {
        goTo();
        waitForWebElementToAppear(loginPageTitle);
        boolean isLoginPage = loginPageTitle.getText().equalsIgnoreCase("Log in");
        Assert.assertTrue(isLoginPage, "The page is not the login page");
        return new ProductCataloguePage(driver);
    }

    public void loginApplication(String email, String password) {
        userEmailInput.sendKeys(email);
        userPasswordInput.sendKeys(password);
        loginButton.click();
    }

    public String getErrorMessage() {
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }
}
