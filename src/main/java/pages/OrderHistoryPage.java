package pages;

import AbstractComponents.AbstractComponent;
//import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
//import org.testng.Assert;

public class OrderHistoryPage extends AbstractComponent {
    WebDriver driver;


    public OrderHistoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//tr/td[2]")
    List<WebElement> orderedItemList;
public void isOrderHistoryPage (){
    boolean isOrderHistoryPage = driver.getCurrentUrl().contains("myorders");
    //org.testng.Assert.assertTrue(isOrderHistoryPage);
    Assert.assertTrue(isOrderHistoryPage);
}
    public void isOrderFoundInHistory(String productName) throws InterruptedException {

        boolean isFound = orderedItemList.stream().anyMatch(s -> s.getText().equals(productName));
        System.out.println(isFound);
        Assert.assertTrue(true, "Item has been found in the order history List");

    }

}
