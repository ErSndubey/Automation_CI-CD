package Infobays.stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.*;
import utils.baseTest;

import java.io.IOException;

public class StepDefinitions extends baseTest {

    LoginPage loginPage;
    ProductCataloguePage productCataloguePage;
    CartPage cartPage;
    PaymentPage paymentPage;
    OrderConfirmationPage orderConfirmationPage;
    OrderHistoryPage orderHistoryPage;

    @Given("User Launches Application")
    public void userLaunchesApplication() throws IOException {
        loginPage = launchApplication();
    }

    @Then("User Landed on Login Page")
    public void userLandedOnLoginPage() {

        productCataloguePage = loginPage.verifyLoginPage();
    }

    @When("user Logged in with user name {} and password {}")
    public void userLoggedInWithUserNameAndPassword(String arg0, String arg1) {
        loginPage.loginApplication(arg0, arg1);
    }

    @Then("User Should see the Product Catalauge Page")
    public void userShouldSeeTheProductCatalaugePage() {

        cartPage = productCataloguePage.isCataloguePage();
    }

    @When("User Adds {} to the cart and hit cart button")
    public void userAddsToTheCartAndHitCartButton(String arg0) throws InterruptedException {
        productCataloguePage.addProductToCart(arg0);
        productCataloguePage.clickOnCartButton();
    }

    @Then("User Should see the cart page")
    public void userShouldSeeTheCartPage() throws InterruptedException {
        paymentPage = cartPage.iscartPage();
    }

    @And("validates the {} on the cart")
    public void validatesTheOnTheCart(String arg0) throws InterruptedException {
        cartPage.ProductValidation(arg0);
    }

    @When("User clicks on checkout button")
    public void userClicksOnCheckoutButton() throws InterruptedException {
        cartPage.clickOnCheckout();
    }

    @Then("User Should see Payment Page")
    public void userShouldSeePaymentPage() {

        orderConfirmationPage = paymentPage.isPaymentPage();
    }

    @When("User selects the country")
    public void userSelectsTheCountry() throws InterruptedException {
        paymentPage.countrySelection("ind");
    }

    @And("clicks on the Place order button")
    public void clicksOnThePlaceOrderButton() throws InterruptedException {
        paymentPage.clickPlaceOrderButton();
    }

    @Then("User should see confirmation page")
    public void userShouldSeeConfirmationPage() {

        orderHistoryPage = orderConfirmationPage.isOrderConfirmationPage();
    }

    @And("{string} message is displayed")
    public void messageIsDisplayed(String arg0) {
        orderConfirmationPage.isOrderConfirmed(arg0);
    }

    @When("User clicks on orders button")
    public void userClicksOnOrdersButton() throws InterruptedException {
        orderConfirmationPage.goToOrderHistoryPage();
    }

    @Then("User should see order History page")
    public void userShouldSeeOrderHistoryPage() {
        orderHistoryPage.isOrderHistoryPage();
    }

    @And("User Verifies {} in order history list")
    public void userVerifiesInOrderHistoryList(String arg0) throws InterruptedException {
        orderHistoryPage.isOrderFoundInHistory(arg0);
    }


}
