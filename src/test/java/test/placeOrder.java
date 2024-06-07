package test;

import org.testng.annotations.Test;
import pages.*;
import utils.baseTest;

import java.io.IOException;

public class placeOrder extends baseTest {


    @Test
    public void Order() throws IOException, InterruptedException {

        String productName = "ZARA COAT 3";

        LoginPage loginPage = new LoginPage(driver);
        ProductCataloguePage productCataloguePage = new ProductCataloguePage(driver);
        CartPage cartPage = new CartPage(driver);
        PaymentPage paymentPage = new PaymentPage(driver);
        OrderConfirmationPage orderConfirmationPage = new OrderConfirmationPage(driver);
        OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver);
        //============================================================

        loginPage.verifyLoginPage();
        loginPage.loginApplication("ersndubey@gmail.com", "Dubey@1832");

        productCataloguePage.isCataloguePage();
        productCataloguePage.addProductToCart(productName);
        productCataloguePage.clickOnCartButton();

        cartPage.iscartPage();
        cartPage.ProductValidation(productName);
        cartPage.clickOnCheckout();

        paymentPage.isPaymentPage();
        paymentPage.countrySelection("ind");
        paymentPage.clickPlaceOrderButton();

        orderConfirmationPage.isOrderConfirmationPage();
        orderConfirmationPage.isOrderConfirmed("THANKYOU FOR THE ORDER.");
        orderConfirmationPage.goToOrderHistoryPage();

        orderHistoryPage.isOrderHistoryPage();
        orderHistoryPage.isOrderFoundInHistory(productName);
    }

//    @DataProvider
//    public Object[][] getData() throws IOException {
//
//        List<HashMap<String, String>> data = getJSONDataToMap(System.getProperty("user.dir") + "\\src\\test\\java\\utils\\PurchaseOrder.json");
//        return new Object[][]{{data.get(0)}, {data.get(1)}};
//    }
}