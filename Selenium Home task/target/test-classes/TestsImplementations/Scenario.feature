Feature: for example lets start from opening the URL

  Scenario Outline: just open URL at Chrome
    Given User is at "<startLink>"
    When User types into search field "<link>"
    Then current page link must be "<link>"
    Examples:
    | startLink               | link                       |
    | https://www.google.com/ | https://www.demoblaze.com/ |