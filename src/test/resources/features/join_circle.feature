Feature: join_circle

  Scenario Outline: Show warning When Passcode is less than 6 digits
    Given a user opens Join Circle page
    When they enter "<circle name>" in the field Circle Name on the Join Circle page
    And they enter "<passcode>" in the Passcode field on the Join Circle page
    And they enter "<first name>" in the First Name field on the Join Circle page
    And they enter "<last name>" in the Last Name field on the Join Circle page
    And they enter "<email>" in the Email field on the Join Circle page
    And they enter "<password>" in the Password field on the Join Circle page
    And they press button Join on the Join Circle page
    Then they are still on the Join Circle page as the registration was not completed
    And Warning message appears: "<error message>"

    Examples:
      | circle name | passcode | first name | last name | email         | password  | error message                        |
      | JoinCircle  | 55566    | Victoria   | Palees    | test@test.com | Password1 | Incorrect Passcode. Please try again |
      | JoinCircle  | 5556666  | Victoria   | Palees    | test@test.com | Password1 | Incorrect Passcode. Please try again |
      | JoinCircle  | ab66cd   | Victoria   | Palees    | test@test.com | Password1 | Incorrect Passcode. Please try again |
      | JoinCircle  | 999999   | Victoria   | Palees    | test@test.com | Password1 | Incorrect Passcode. Please try again |


  Scenario Outline: Show warning When First Name exceeds 32 characters or if less than 1 character long
    Given a user opens Join Circle page
    When they enter "<circle name>" in the field Circle Name on the Join Circle page
    And they enter "<passcode>" in the Passcode field on the Join Circle page
    And they enter "<first name>" in the First Name field on the Join Circle page
    And they enter "<last name>" in the Last Name field on the Join Circle page
    And they enter "<email>" in the Email field on the Join Circle page
    And they enter "<password>" in the Password field on the Join Circle page
    And they press button Join on the Join Circle page
    Then they are still on the Join Circle page as the registration was not completed
    And under the field First Name the Warning message is displayed: "<error message>"

    Examples:
      | circle name | passcode | first name                               | last name | email         | password  | error message                                                                                 |
      | JoinCircle  | 55566    | JohnJohnJohnJohnJohnJohnJohnJohnJohnJohn | Palees    | test@test.com | Password1 | Field accepts alphabetical char and digits, no special chars allowed, limited to 32 character |
      | JoinCircle  | 55566    |                                          | Palees    | test@test.com | Password1 | This input is required                                                                        |


  Scenario Outline: The password should not be copied from context menu
    Given a user opens Join Circle page
    When they enter "<password>" in the Password field on the Join Circle page
    And they selected and copy entered password on the Join Circle page
    Then the "<password>" is not copied into clipboard

    Examples:
      | password |
      | 123456z  |

  Scenario: The password is masked
    Given a user opens Join Circle page
    Then the password is masked on Join Circle Page


  Scenario Outline: Verify Last Name field validations
    Given a user opens Join Circle page
    When they enter "<circleName>" in the field Circle Name on the Join Circle page
    And they enter "<passcode>" in the Passcode field on the Join Circle page
    And they enter "<firstName>" in the First Name field on the Join Circle page
    And they enter "<lastName>" in the Last Name field on the Join Circle page
    And they enter "<email>" in the Email field on the Join Circle page
    And they enter "<password>" in the Password field on the Join Circle page
    And they press button Join on the Join Circle page
    Then they are still on the Join Circle page as the registration was not completed
    And under the field 'Last Name' the Warning message is displayed: "<warningMessage>"

    Examples:
      | circleName | passcode | firstName | lastName                          | email         | password  | warningMessage                                                                                 |
      | JoinCircle | 555666   | Victoria  |                                   | test@test.com | Password1 | This input is required.                                                                        |
      | JoinCircle | 555666   | Victoria  | PaleesPaleesPaleesPaleesPaleesPal | test@test.com | Password1 | Field accepts alphabetical char and digits, no special chars allowed, limited to 32 characters |


  Scenario Outline: Error message for invalid "Email"
    Given a user opens Join Circle page
    When they enter "<circleName>" in the field Circle Name on the Join Circle page
    And they enter "<passcode>" in the Passcode field on the Join Circle page
    And they enter "<firstName>" in the First Name field on the Join Circle page
    And they enter "<lastName>" in the Last Name field on the Join Circle page
    And they enter "<email>" in the Email field on the Join Circle page
    And they enter "<password>" in the Password field on the Join Circle page
    And they press button Join on the Join Circle page
    Then they are still on the Join Circle page as the registration was not completed
    And under the field Email the Warning message is displayed: "<warningMessage>"

    Examples:
      | circleName | passcode | firstName | lastName | email             | password  | warningMessage                                  |
      | JoinCircle | 555666   | Victoria  | Palees   | testtest.com      | Password1 | Invalid email address, limited to 32 characters |
      | JoinCircle | 555666   | Victoria  | Palees   |                   | Password1 | This input is required.                         |
      | JoinCircle | 555666   | Victoria  | Palees   | stripe@gmail.com· | Password1 | Invalid email address, limited to 32 characters |


  Scenario Outline: Password must meet complexity requirements (uppercase, lowercase, digit, 8-20 characters)
    Given a user opens Join Circle page
    When they enter "<circleName>" in the field Circle Name on the Join Circle page
    And they enter "<passcode>" in the Passcode field on the Join Circle page
    And they enter "<firstName>" in the First Name field on the Join Circle page
    And they enter "<lastName>" in the Last Name field on the Join Circle page
    And they enter "<email>" in the Email field on the Join Circle page
    And they enter "<password>" in the Password field on the Join Circle page
    And they press button Join on the Join Circle page
    Then they are still on the Join Circle page as the registration was not completed
    And under the field 'Password' the Warning message is displayed: "<warningMessage>"

    Examples:
      | circleName | passcode | firstName | lastName | email         | password              | warningMessage                                                                                                       |
      | JoinCircle | 555666   | John      | Palees   | test@test.com | Pass1                 | Field should contain at least one upper-case, at least one lower-case and at least one digit and be between 8 and 20 |
      | JoinCircle | 555666   | John      | Palees   | test@test.com | Password15556667Victo | Field should contain at least one upper-case, at least one lower-case and at least one digit and be between 8 and 20 |
      | JoinCircle | 555666   | John      | Palees   | test@test.com | password1             | Field should contain at least one upper-case, at least one lower-case and at least one digit and be between 8 and 20 |
      | JoinCircle | 555666   | John      | Palees   | test@test.com | PASSWORD1             | Field should contain at least one upper-case, at least one lower-case and at least one digit and be between 8 and 20 |
      | JoinCircle | 555666   | John      | Palees   | test@test.com | Password              | Field should contain at least one upper-case, at least one lower-case and at least one digit and be between 8 and 20 |
      | JoinCircle | 555666   | John      | Palees   | test@test.com |                       | This input is required                                                                                               |