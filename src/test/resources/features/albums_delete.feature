Feature: delete Album

  Scenario: Deleting the album that user created
    Given a user is logged into the account
    And they create new album with unique name
    And they see a success popup message "Album has been created"
    And they assert the unique album name is present on Album Page
    And they delete unique album from Album Page
    Then they do not see the album with unique name on Album Page



  Scenario: User cannot delete album that they didn't create
    Given a user is logged into the account
    And they create new album with unique name
    And they see a success popup message "Album has been created"
    And a user is logged out of the account
    And another user is logged into the account
    And they click the Albums button
    And they assert delete icon for unique album is not displayed
    And a user is logged out of the account
    And a user is logged into the account
    And they click the Albums button
    And they assert delete icon for unique album is displayed
    And they delete unique album from Album Page
    Then they do not see the album with unique name on Album Page