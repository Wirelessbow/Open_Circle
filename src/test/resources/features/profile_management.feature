Feature: profile_management

  Scenario: Deleting profile picture
    Given a user is logged into the account
    And they click the Avatar icon
    When they delete profile picture
    Then the Upload button is present


  Scenario Outline: Updating last name with valid input
    Given a user is logged into the account
    And they click the Avatar icon
    When they clear Last name field on the Profile Page
    And they enter "<last name>" in Last name field on the Profile Page
    And they click the Save button
    Then Last name "<last name>" in Last Name field on Profile Page is present

    Examples:
      | last name                        |
      | Smith1                           |
      | SMITH                            |
      | smith                            |
      | Namenamenamenamenamenamenamename |


  Scenario Outline: Updating First Name with valid input
    Given a user is logged into the account
    And they click the Avatar icon
    When they clear First name field on the Profile page
    And they enter "<first name>" in First name field on the Profile Page
    And they click the Save button
    Then First name on Profile page is updated to "<first name>"

    Examples:
      | first name                       |
      | mary                             |
      | MARY                             |
      | Mary1                            |
      | Namenamenamenamenamenamenamename |


  Scenario Outline: Updating last name with invalid input
    Given a user is logged into the account
    And they click the Avatar icon
    When they clear Last name field on the Profile Page
    And they enter "<last name>" in Last name field on the Profile Page
    And they click the Save button
    Then error on the Profile Page is displayed "<error message>"

    Examples:
      | last name                         | error message                                                        |
      | Smith@                            | Field accepts alphabetical char and digits, no special chars allowed |
      | Smit h                            | Field accepts alphabetical char and digits, no special chars allowed |
      |                                   | Please input your Last Name                                          |
      | Namenamenamenamenamenamenamenamen | Last Name must be between 1 and 32                                   |

  Scenario Outline: Updating First name with invalid input
    Given a user is logged into the account
    And they click the Avatar icon
    When they clear First name field on the Profile page
    And they enter "<First name>" in First name field on the Profile Page
    And they click the Save button
    Then error on the Profile Page is displayed "<error message>"

    Examples:
      | First name                        | error message                                                        |
      | M@ry                              | Field accepts alphabetical char and digits, no special chars allowed |
      | M ary                             | Field accepts alphabetical char and digits, no special chars allowed |
      |                                   | Please input your First Name                                         |
      | Namenamenamenamenamenamenamenamen | First Name must be between 1 and 32                                  |

  Scenario: Replacing existing profile picture
    Given a user is logged into the account
    And they click the Avatar icon
    When they replace the profile picture
    Then The Delete button on Profile page is displayed