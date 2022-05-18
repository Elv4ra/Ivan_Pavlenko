Feature: testing logging in and product buying processes of the site

  Scenario Outline: User opens home page of the tested site,
    logs in, selects product category, selects product,
    adds it to the cart, opens cart page, clicks place order button,
    fills up place order form and purchases product
    Given User is at the main page in the Chrome
    When User logs in with credentials Elvara and 21024l2O1a1K
    And selects <category> category
    And selects product <product>
    And adds it to the cart
    And opens cart section
    And clicks Place Order button
    And fills up form with data <name>, <country>, <city>, <creditCard>, <month>, <year>
    And purchases product
    And clicks OK button after receiving confirmation
    Then site is redirected back to the Home page
    Examples:
      | category | product     | name | country | city | creditCard       | month | year |
      | Laptops  | MacBook air | Ivan | Ukraine | Kyiv | 1991911991191991 | July  | 2142 |