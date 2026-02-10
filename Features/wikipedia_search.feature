Feature: Wikipedia Search

  As a user
  I want to search for information on Wikipedia
  So that I can read about a specific topic

  Scenario: Search for Selenium on Wikipedia
    Given the user opens the browser
    And navigates to "https://www.wikipedia.org"
    When the user enters "Selenium (software)" in the search field
    And clicks the search button
    Then the page title should contain "Selenium"
