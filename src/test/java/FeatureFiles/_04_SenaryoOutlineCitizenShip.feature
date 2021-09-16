Feature: Citizenship with scenario Outline

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully
    And Navigate to Citizenship page

  @Regression
  Scenario Outline: Citizenship create and delete with scenario Outline
    When User a Ctizenship name as "<CitizenshipName>" short name as "<ShortName>"
    Then Success message should be displayed

    When User a Ctizenship name as "<CitizenshipName>" short name as "<ShortName>"
    Then Already exist message should be displayed
    And  Click on close button

    When User delete the  "<CitizenshipName>"
    Then Success message should be displayed


    Examples:
      | CitizenshipName | ShortName |
      | Tarikish312     | tr31      |
      | Ragish312       | rg31      |
      | Ismetish313     | is31      |
      | Tarikish413     | tr41      |
