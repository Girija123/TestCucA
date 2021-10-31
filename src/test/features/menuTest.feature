Feature: Menu
  As a user
  I should navigate to appropriate products using menu

  @menu
  Scenario Outline: Menu re-direction verification

    Given I'm on Home page "http://www.next.co.uk"
    When I hover over menu option "<Menu>"
    Then I should be in the appropriate with title "<ExpectedTitle>"

    Examples:
      | Menu  | ExpectedTitle |
      | MEN   | Men's         |
      | WOMEN | Women's       |
      | Baby  | Baby          |