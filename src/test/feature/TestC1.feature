@tag
Feature: Purchase the item from the e-commerce website

  Scenario Outline: Test of submitting the order
    Given User Launches Application
    Then User Landed on Login Page
    When user Logged in with user name <name> and password <password>
    Then User Should see the Product Catalauge Page
    When User Adds <productName> to the cart and hit cart button
    Then User Should see the cart page
    And  validates the <productName> on the cart
    When User clicks on checkout button
    Then User Should see Payment Page
    When User selects the country
    And clicks on the Place order button
    Then User should see confirmation page
    And "THANKYOU FOR THE ORDER." message is displayed
    When User clicks on orders button
    Then User should see order History page
    And User Verifies <productName> in order history list

    Examples:
      | name                | password   | productName |
      | ersndubey@gmail.com | Dubey@1832 | ZARA COAT 3 |