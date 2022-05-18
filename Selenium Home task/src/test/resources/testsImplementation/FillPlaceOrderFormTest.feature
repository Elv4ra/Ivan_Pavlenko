Feature: testing filling up the place order form and Purchase button

   Scenario Outline: User fills up Place Order form
     Given User is at cart page and Place Order form is opened in the Chrome browser
     When User types in name field <name>
     And types in country field <country>
     And types in city field <city>
     And types in credit card field <creditCard>
     And types in month field <month>
     And types in year field <year>
     And clicks Purchase button
     Then confirming window appears
     Examples:
     | name          | country | city | creditCard       | month     | year |
     | Ivan Pavlenko | Ukraine | Kyiv | 9999999999999999 | January   | 2002 |
     | Elvara        | Norway  | Oslo | 1111111111111111 | September | 2077 |

