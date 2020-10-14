Feature: Wsb test feature

  Scenario: Check the wsb page

    Given I navigate to "wsbPage" page
    When I click menu item with text "Studia i szkolenia"
    And I click submenu item with text "Studia I stopnia"
    And I click "Kierunki i specjalności" in tab menu
    And I select "Wrocław" city from the left menu
    Then "9" search results should be displayed
    And Each result contains "Wrocław" city
    And "Zapisz się online" button is displayed
    And Sorting, filters and search field are displayed


#    Then I should be told "Nope"