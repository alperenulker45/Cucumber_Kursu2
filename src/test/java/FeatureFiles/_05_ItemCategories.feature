Feature: Item Categories

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully


  Scenario Outline:
    And Navigate to Item Category page
    When User create a item categories name as "<InventoryItemName>" short name as "<UserTypeOption>"
    Then Success message should be displayed
    When User delete the  "<InventoryItemName>"
    Then Success message should be displayed

    Examples:
      | InventoryItemName | UserTypeOption |
      | Laptopis22 | Manager        |
      | Projectoris22  | Student        |
      | Whiteboardis221 | Teacher        |