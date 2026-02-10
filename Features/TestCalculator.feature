Feature: Test Calculator
  Scenario: Add two numbers
    Given I have a Calculator
    When I add 2 and 3
    Then The result shoulmd be 5