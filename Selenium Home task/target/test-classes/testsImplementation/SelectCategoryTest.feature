Feature: testing category selection at the home page of the tested site

  Scenario Outline: User selects different categories at home page
    Given User is at Home Page using Chrome
    When User clicks on the <category> category button
    Then products on the home page must be changed
    Examples:
    | category |
    | Laptops  |
    | Phones   |
    | Monitors |