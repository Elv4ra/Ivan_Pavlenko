Feature: testing logging in mechanism of the tested site

  Scenario Outline: User logs in at different pages of the tested site
    Given User is at <pageURL> of the site in the <browser>
    When User clicks Log in button
    And types in username <username>
    And types in password <password>
    And clicks Log in button
    Then User must be logged in
    Examples:
    | browser  | pageURL                                    | username | password     |
    | Chrome   | https://www.demoblaze.com/                 | Elvara   | 21024l2O1a1K |
    | Firefox  | https://www.demoblaze.com/                 | Elvara   | 21024l2O1a1K |
    | Chrome   | https://www.demoblaze.com/prod.html?idp_=1 | Elvara   | 21024l2O1a1K |
    | Firefox  | https://www.demoblaze.com/cart.html        | Elvara   | 21024l2O1a1K |