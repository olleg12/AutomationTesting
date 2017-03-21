Feature: To test google

  Scenario: To test the result of translate google com query
    When I enter "translate google com" into searchfield
    And  I click on "Google Search" button
    Then I check whether Showing results for translate.google.com is displayed

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

