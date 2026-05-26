Feature: Create Circle

  Scenario Outline: First name field error message validation
    Given a user opens Create Circle page
    And they enter "<circle name>" in the Circle name field on the Create Circle page
    And they click the Generate button on the Create Circle page
    And they enter "<first name>" in the First Name field on the Create Circle Page
    And they enter "<last name>" in the Last Name field on the Create Circle page
    And they enter "<email>" in the email field on the Create Circle page
    And they enter "<user password>" in the password field on the Create Circle page
    And they click the Create button on the Create Circle page
    Then error message pops-up "<error message>" below First Name field on Create Circle page

    Examples:
      | circle name     | first name                        | last name    | email               | user password | error message                                                                                  |
      | TestCircleThree | TestFirstNameThatIsExtremelyLongF | TestLastName | testemail@test.com  | Password123   | Field accepts alphabetical char and digits, no special chars allowed, limited to 32 characters |
      | CircleTester    |                                   | TestLastName | testing123@test.com | Password123   | This input is required.                                                                        |
      | TestCircleThree | TestFirstName@                    | TestLastName | testemail@test.com  | Password123   | Field accepts alphabetical char and digits, no special chars allowed, limited to 32 characters |


  Scenario Outline: Last name field error message validation
    Given a user opens Create Circle page
    And they enter "<circle name>" in the Circle name field on the Create Circle page
    And they click the Generate button on the Create Circle page
    And they enter "<first name>" in the First Name field on the Create Circle Page
    And they enter "<last name>" in the Last Name field on the Create Circle page
    And they enter "<email>" in the email field on the Create Circle page
    And they enter "<user password>" in the password field on the Create Circle page
    And they click the Create button on the Create Circle page
    Then error message pops-up "<error message>" below Last Name field on Create Circle page

    Examples:
      | circle name     | first name    | last name                                    | email               | user password | error message                                                                                  |
      | TestCircleThree | TestFirstName | TestLastNameTestLastNameThatIsExtremelyLongF | testemail@test.com  | Password123   | Field accepts alphabetical char and digits, no special chars allowed, limited to 32 characters |
      | CircleTester    | TestFirstName |                                              | testing123@test.com | Password123   | This input is required.                                                                        |
      | TestCircleThree | TestFirstName | TestLastName@                                | testemail@test.com  | Password123   | Field accepts alphabetical char and digits, no special chars allowed, limited to 32 characters |


  Scenario Outline: Email field error message validation
    Given a user opens Create Circle page
    And they enter "<circle name>" in the Circle name field on the Create Circle page
    And they click the Generate button on the Create Circle page
    And they enter "<first name>" in the First Name field on the Create Circle Page
    And they enter "<last name>" in the Last Name field on the Create Circle page
    And they enter "<email>" in the email field on the Create Circle page
    And they enter "<user password>" in the password field on the Create Circle page
    And they click the Create button on the Create Circle page
    Then error message pops-up "<error message>" for Email field on Create Circle page

    Examples:
      | circle name | first name | last name | email                                | user password | error message                                   |
      | oval        | fname      | lname     | nameataddressdotcom                  | Aa111111      | Invalid email address, limited to 32 characters |
      | oval        | fname      | lname     | namenamenamenamenamename@address.com | Aa111111      | Invalid email address, limited to 32 characters |
      | oval        | fname      | lname     |                                      | Aa111111      | This input is required.                         |


  Scenario Outline: Email field pop-up error message validation
    Given a user opens Create Circle page
    And they enter "<circle name>" in the Circle name field on the Create Circle page
    And they click the Generate button on the Create Circle page
    And they enter "<first name>" in the First Name field on the Create Circle Page
    And they enter "<last name>" in the Last Name field on the Create Circle page
    And they enter "<email>" in the email field on the Create Circle page
    And they enter "<user password>" in the password field on the Create Circle page
    And they click the Create button on the Create Circle page
    Then they see a warning popup message "<error popup>"

    Examples:
      | circle name | first name | last name | email              | user password | error popup                        |
      | oval        | fname      | lname     | name@address.com   | Aa111111      | A user with such an email exists.  |


  Scenario Outline: Password field error message validation
    Given a user opens Create Circle page
    And they enter "<circle name>" in the Circle name field on the Create Circle page
    And they click the Generate button on the Create Circle page
    And they enter "<first name>" in the First Name field on the Create Circle Page
    And they enter "<last name>" in the Last Name field on the Create Circle page
    And they enter "<email>" in the email field on the Create Circle page
    And they enter "<user password>" in the password field on the Create Circle page
    And they click the Create button on the Create Circle page
    Then error message pops-up "<error message>" for Password field on Create Circle page

    Examples:
      | circle name     | first name    | last name    | email               | user password                  | error message                                                                                                        |
      | TestCircleThree | TestFirstName | TestLastName | testing123@test.com | password1                      | Field should contain at least one upper-case, at least one lower-case and at least one digit and be between 8 and 20 |
      | TestCircleThree | TestFirstName | TestLastName | testing123@test.com | PASSWORD1                      | Field should contain at least one upper-case, at least one lower-case and at least one digit and be between 8 and 20 |
      | TestCircleThree | TestFirstName | TestLastName | testing123@test.com | password                       | Field should contain at least one upper-case, at least one lower-case and at least one digit and be between 8 and 20 |
      | TestCircleThree | TestFirstName | TestLastName | testing123@test.com | Passw1$                        | Field should contain at least one upper-case, at least one lower-case and at least one digit and be between 8 and 20 |
      | TestCircleThree | TestFirstName | TestLastName | testing123@test.com | Password1$Password1$Password1$ | Field should contain at least one upper-case, at least one lower-case and at least one digit and be between 8 and 20 |
      | TestCircleThree | TestFirstName | TestLastName | testing123@test.com |                                | This input is required.                                                                                              |


  Scenario Outline: Circle name field error message validation
    Given a user opens Create Circle page
    And they enter "<circle name>" in the Circle name field on the Create Circle page
    And they click the Generate button on the Create Circle page
    And they enter "<first name>" in the First Name field on the Create Circle Page
    And they enter "<last name>" in the Last Name field on the Create Circle page
    And they enter "<email>" in the email field on the Create Circle page
    And they enter "<user password>" in the password field on the Create Circle page
    And they click the Create button on the Create Circle page
    Then error message pops-up "<error message>" for Circle name field on Create Circle page

    Examples:
      | circle name                       | first name    | last name    | email               | user password | error message                                                                                  |
      |                                   | TestFirstName | TestLastName | testing123@test.com | Password123   | This input is required.                                                                        |
      | TestCircleNameTestCircleName12345 | TestFirstName | TestLastName | testing123@test.com | Password123   | Field accepts alphabetical char and digits, no special chars allowed, limited to 32 characters |
      | TestCircleName@#$                 | TestFirstName | TestLastName | testing123@test.com | Password123   | Field accepts alphabetical char and digits, no special chars allowed, limited to 32 characters |


  Scenario Outline: Attempting to enter input into passcode field
    Given a user opens Create Circle page
    And they enter "<passcode>" in Passcode field on Create Circle page
    Then Passcode field contains ""
    Examples:
      | passcode |
      | Abcd12@  |


  Scenario: Pushing copy button to copy generated data in passcode field
    Given a user opens Create Circle page
    When they click the Generate button on the Create Circle page
    And they click copy button on Create Circle page
    And they paste input into first name field on Create Circle form
    Then Input in first name field is the same as input in passcode field


  Scenario Outline:  Pushing copy button while passcode field is empty
      Given a user opens Create Circle page
      And they click copy button on Create Circle page
      Then they see a warning popup message "<error popup>"
      Examples:
        | error popup               |
        | Generate PassCode firstly |


  @DeleteCircleAndUser
  Scenario Outline: New circle is created, and user is logged into the newly created circle
    Given a user opens Create Circle page
    When they enter "<circle name>" in the Circle name field on the Create Circle page
    And they click the Generate button on the Create Circle page
    And they enter "FirstName" in the First Name field on the Create Circle Page
    And they enter "LastName" in the Last Name field on the Create Circle page
    And they enter a new email in the email field on the Create Circle page
    And they enter new password in the password field on the Create Circle page
    And they click the Create button on the Create Circle page
    Then they see a success popup message "You have successfully registered."
    And they enter new circle email in Email input field on Login page
    And they enter new circle password in Password input field on Login page
    And they click Sign In button on Login page
    And they see a Circle Name "<circle name>" on Home Page

    Examples:
      | circle name    |
      | TestCircle2025 |