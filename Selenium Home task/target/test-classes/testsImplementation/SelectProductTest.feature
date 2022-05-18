Feature: testing product selection at the home page of the tested site

  Background:
    Given User is at Home Page in the Chrome browser

    Scenario Outline: User selects different products
      When User clicks on the <name> product title
      Then page of <name> product opens
      Examples:
      | name              |
      | Samsung galaxy s6 |
      | Iphone 6 32gb     |
      | Sony vaio i7      |

    Scenario Outline: User selects products after category selection
      Given User selects the <category> category button
      When User clicks on the <name> product title
      Then page of <name> product opens
      Examples:
      | category | name         |
      | Phones   | Nexus 6      |
      | Laptops  | Sony vaio i5 |
      | Monitors | ASUS Full HD |
