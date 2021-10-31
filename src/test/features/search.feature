Feature: As a user
         I should search and get appropriate products

  Background: Home page
    Given I'm on Home page "http://www.next.co.uk"

  @search1 @search @smoke @reg
  Scenario: Verify search using valid product/brand name

   When I enter search term "T-Shirt"
   And I click search icon
   Then I should see relevant products realted to  "T-Shirt" in search results page

  @search @reg
  Scenario: Verify search using invalid product/brand name

    When I enter search term "cupboard"
    And I click search icon
    Then I shouldn't get results instead a message "No results returned"




