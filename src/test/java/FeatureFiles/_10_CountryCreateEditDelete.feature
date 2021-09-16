Feature: Country Create Edit Delete

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to country page

  Scenario: Create a country
    When Create a country name as "ismetYeni6" code as "code3"
    Then Success message should be displayed

  Scenario: Edit a country

    When User edit the "ismetYeni6" to "ismetYeni7"
    Then Success message should be displayed

  Scenario: Delete a country

    When User delete the "ismetYeni7"
    Then Success message should be displayed

