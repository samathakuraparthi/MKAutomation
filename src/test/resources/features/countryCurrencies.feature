@mkTest
Feature: Country Currencies verification
  As a user I should able to select countries and output their currencies

  Scenario Outline: Display of currencies for selected country
    Given user clicks on UK flag on homepage header
    When user gets list of countries for region "<region>"
    Then user prints currency for each country
    Examples:
      | region |
      | Africa |
