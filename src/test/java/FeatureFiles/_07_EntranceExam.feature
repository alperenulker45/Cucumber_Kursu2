#  1 sınav girişi yapıp
#  sonrasında silmesini yapınız

Feature: Entrance Exam Functionality

  Background:
    Given Navigate to basqar
    When Enter username and password and click login button
    Then User should login successfully

  Scenario: Create a Country
    And Click on the element in the left Nav
      | entranceExamsOne |
      | setupTree        |
      | entranceExamsTwo |

    And Click on the element in the Dialog
      | addButton |

    When User sending the keys in dailog content
      | nameInput | ismetExam8 |

    And Click on the element in the Form Content
      | academicPeriod  |
      | academicPeriod1 |
      | gradeLevel      |
      | gradeLevel2     |
      | saveButton      |

    Then Success message should be displayed

    And Click on the element in the left Nav
      | entranceExamsOne |
      | setupTree        |
      | entranceExamsTwo |

    When User delete the  "ismetExam8" from Form
    Then Success message should be displayed