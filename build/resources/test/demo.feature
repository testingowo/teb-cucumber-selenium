Feature: Is it Summer?
  Everybody likes Summer

  Scenario Outline: Check the wsb page

    Given I navigate to "demoPage" page
    When I click random post
    Then I verify post form <labels>

    Examples:
    |labels|
  | Comment     |
  | Name        |
  | Email       |
  | Website     |
#    When I click menu item with text "Studia i szkolenia"
#    And I click submenu item with text "Studia I stopnia"
#    And I click "Kierunki i specjalności" in tab menu
#    And I select "Wrocław" city from the left menu
#    Then "9" search results should be displayed

#    Then I should be told "Nope"