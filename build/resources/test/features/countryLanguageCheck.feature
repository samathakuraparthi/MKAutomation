Feature:Country Language verification test

  Scenario Outline: Display of Language options for selected country
    Given user clicks on UK flag on homepage header
    When user hovers on "<country>" under "<region>" region
    Then List of Languages "<listOfLanguages>" for  the country "<country>" are displayed
    And user gets and prints list of countries with more than one language
    Examples:
      | region        | country     | listOfLanguages               |
      | North America | Canada      | English,French                |
