Feature: testing adding product to the cart

  Scenario Outline: User adds selected product to the cart
    Given User is at <productPageURL> product page in the browser Chrome
    When User clicks Add to cart button
    Then alert about adding the product to the cart appears
    Examples:
    | productPageURL                              |
    | https://www.demoblaze.com/prod.html?idp_=14 |
    | https://www.demoblaze.com/prod.html?idp_=2  |
    | https://www.demoblaze.com/prod.html?idp_=7  |