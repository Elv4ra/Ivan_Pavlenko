Feature: testing purchase confirmation

  Scenario Outline: User selects product and adds it to the cart,
    fills up place order form and purchases it
    Given User adds product <productURL> to the cart using Mozilla browser
    And click Cart button to open cart section
    When User places order
    And fills up form with information Ivan, Ukraine, Kyiv, 1991911991191991, July, 2142
    And clicks button Purchase
    Then purchase must be confirmed
    Examples:
    | productURL                                  |
    | https://www.demoblaze.com/prod.html?idp_=10 |
    | https://www.demoblaze.com/prod.html?idp_=4  |