Feature: Change Password

  Scenario Outline: Leaving the current password field empty triggers a warning message
    Given a user is logged into the account
    And they click the Avatar icon
    When they click Change password section
    And they enter "" in Current password input field on Change password page
    And they enter "<password>" in New password input field on Change password page
    And they click Save button on Change password page
    Then they see a warning popup message "<warning message>"

    Examples:
      | password   | warning message                                                                                                                                 |
      | Example123 | Field: oldPassword; Error: Field should contain at least one upper-case, at least one lower-case and at least one digit and be between 8 and 20|


  Scenario Outline:  Leaving the new password field empty triggers a warning message
    Given a user is logged into the account
    And they click the Avatar icon
    When they click Change password section
    And they enter "<valid password>" in Current password input field on Change password page
    When they enter "" in New password input field on Change password page
    And they click Save button on Change password page
    Then they see a warning popup message "<warning message>"

    Examples:
      | valid password | warning message                                                                                                                                 |
      | Test12345!     | Field: newPassword; Error: Field should contain at least one upper-case, at least one lower-case and at least one digit and be between 8 and 20 |


  Scenario Outline: Submitting an invalid current password displays an error message
    Given a user is logged into the account
    And they click the Avatar icon
    When they click Change password section
    And they enter "<invalid password>" in Current password input field on Change password page
    And they enter "<valid password>" in New password input field on Change password page
    And they click Save button on Change password page
    Then they see a warning popup message "<warning message>"

    Examples:
      | valid password | invalid password | warning message    |
      | Example123     | theExample123    | Incorrect password |


  @changePassword
  Scenario Outline: Success message is displayed on clicking Save with valid current passwords
    Given a user is logged into the account
    And they click the Avatar icon
    When they click Change password section
    And they enter current valid password in Current password input field on Change password page
    And they enter "<new password>" in New password input field on Change password page
    And they click Save button on Change password page
    Then success message Password Has Been Changed displayed

    Examples:
      | new password         |
      | Example122           |
      | Test1234             |
      | TestTestTestTest1234 |


  Scenario Outline: Submitting an invalid new password displays an error message
    Given a user is logged into the account
    And they click the Avatar icon
    When they click Change password section
    And they enter current valid password in Current password input field on Change password page
    And they enter "<invalid password>" in New password input field on Change password page
    Then they see an "<error message>" under the New password input field on Change password page

  Examples:
    | invalid password | error message                                                                                                           |
    | Test123          | Password should contain at least one upper-case, at least one lower-case and at least one digit and be between 8 and 20 |
    | TestTestTestTest | Password should contain at least one upper-case, at least one lower-case and at least one digit and be between 8 and 20 |


  @changePassword
  Scenario Outline: the user re-login with the new password
    Given a user is logged into the account
    And they click the Avatar icon
    When they click Change password section
    And they enter current valid password in Current password input field on Change password page
    And they enter "<new password>" in New password input field on Change password page
    And they click Save button on Change password page
    And success message Password Has Been Changed displayed
    And they click Log out button
    And they enter existing email in Email input field on Login page
    And they enter "<new password>" in Password input field on Login page
    Then they click Sign In button on Login page
    And they see a Circle Name on Home Page

    Examples:
     |new password |
     | Example122  |


  Scenario: password visibility toggle enabled by default on current password field
    Given a user is logged into the account
    And they click the Avatar icon
    When they click Change password section
    And they enter current valid password in Current password input field on Change password page
    Then they verify that current password visibility toggle enabled by default on Change password page


  Scenario Outline: password visibility toggle enabled by default on new password field
    Given a user is logged into the account
    And they click the Avatar icon
    When they click Change password section
    And they enter "<valid password>" in New password input field on Change password page
    Then they verify that new password visibility toggle enabled by default on Change password page

    Examples:
      | valid password |
      | 123456qweRT    |