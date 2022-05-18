Feature: testing cart section and Place Order button

  Scenario Outline: User opens cart section
    Given User selected <pageURL> product in the Firefox
    When User clicks Cart button on the menu bar
    Then cart page opens with URL https://www.demoblaze.com/cart.html
    Examples:
    | pageURL                                    |
    | https://www.demoblaze.com/                 |
    | https://www.demoblaze.com/prod.html?idp_=7 |
    | https://www.demoblaze.com/index.html#      |


  Scenario: User is at the cart page and clicks Place Order button
    Given User is at cart page using Chrome
    When User clicks Place Order button
    Then Place Order form appears