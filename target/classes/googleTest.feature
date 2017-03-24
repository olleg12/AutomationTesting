Feature: To test google

  Scenario: To test the result of translate google com query
    When I enter "translate google com" into searchfield
    And  I click on Google Search button
    Then I check whether Showing results for translate.google.com is displayed
    
  Scenario: To test google translate page
    When I enter "translate google com" into searchfield
    And  I click on Google Search button
    And I click on the first link
    And I fill translate from field
    And I save the previous translation
    And I choose the language to translate in
    Then I compare the translations

  Scenario: To test search results amount
    When I enter "Apple" into searchfield
    And  I click on Google Search button
    And  I get the number of results
    And  I navigate to 2 page
    And  I get the number of results
    And  I navigate to 10 page
    And  I get the number of results
    Then I check whether the number of results is the same on the above mentioned pages

