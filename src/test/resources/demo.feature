Feature: Adding comment feature

  Scenario Outline: Check the wsb page

    Given I navigate to "demoPage" page
    When I click random post
    Then I verify post form "<labels>"
    When I fill comment fields
    And I click submit button
    Then I compare added and generated comment

    Examples:
    |labels|
    | Comment, Name *,  Email *, Website    |