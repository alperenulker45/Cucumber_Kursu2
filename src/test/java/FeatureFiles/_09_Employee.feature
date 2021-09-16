Feature: Employee Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Create Employee
    And Click on the element in the left Nav
      | humanResources |
      | employees      |

    And Click on the element in the Dialog
      | addButton |

    When User sending the keys in form content
      | inputEmployeeName     | ismet3412 |
      | inputEmployeeLastName | temur11 |
      | employeeId            | 934511 |
      | documentNumber        | 778911  |

    And Click on the element in the Form Content
      | gender          |
      | male            |
      | documentType    |
      | passport        |
      | employeeType    |
      | employeeTeacher |
      | saveButton      |

    Then Success message should be displayed

    And Click on the element in the left Nav
      | humanResources |
      | employees      |

    When User delete the  "ismet3412" from Form
    Then Success message should be displayed