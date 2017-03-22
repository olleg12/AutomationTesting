Feature: To test google

  @translate
  Scenario: To test the result of translate google com query
    When I enter "translate google com" into searchfield
    And  I click on "Google Search" button
    Then I check whether Showing results for translate.google.com is displayed

  @translate
  Scenario: To test google translate page
    When I enter "translate google com" into searchfield
    And  I click on "Google Search" button
    And I click on the first link
    And I fill in first field Apple
    And I save the previous translation
    And I click on languages dropdown
    And I choose the language to translate in
    Then I compare the translations

#  Scenario: To test search results amount
#    When I enter "Apple" into searchfield
#    And  I click on "Google Search" button
#    And  I get the number of results
#    And  I navigete to 2-nd page
#    And  I get the number of results
#    And  I navigete to 10-nd page
#    And  I get the number of results
#    Then I check whether the number of results is the same on the above mentioned pages
