Feature: createAlbum

  Scenario Outline: A user creates a photo album
    Given a user is logged into the account
    And they click the Albums button
    And click Create new album button on Albums page
    And they enter "<album name>" unique Album name in the pop up field in create new album window
    And they click Create button in create new album window
    And they see a success popup message "Album has been created"
    Then they assert the album name "<album name>" presented on Album Page
    And they delete album named "<album name>" from Album Page

    Examples:
      | album name     |
      | newUniqueAlbum |


  Scenario Outline: User can not create a photo album without a unique name
    Given a user is logged into the account
    And they create new album with the name "<duplicate name>"
    And they see a success popup message "Album has been created"
    And they create new album with the name "<duplicate name>"
    And they see a warning popup message "Album with this name exists"
    And they click Cancel button on Create New Album Window
    And they delete album named "<duplicate name>" from Album Page

    Examples:
      | duplicate name |
      | TestAlbum01    |


  Scenario Outline: User cancels creating a new album
    Given a user is logged into the account
    And they click the Albums button
    And click Create new album button on Albums page
    And they enter "<album name>" unique Album name in the pop up field in create new album window
    And they click Cancel button on Create New Album Window
    And they verify no album with the name "<album name>" was created

    Examples:
      | album name |
      | alex_album |


  Scenario: User can not create a photo album with the same name
    Given a user is logged into the account
    And they create new album with unique name
    And they see a success popup message "Album has been created"
    And they create new album with unique name
    And they see a warning popup message "Album with this name exists"
    And they click Cancel button on Create New Album Window
    And they delete unique album from Album Page


  Scenario Outline: User can not create a photo album with a name longer than 20 symbols
    Given a user is logged into the account
    And they click the Albums button
    And click Create new album button on Albums page
    And they enter "<album name>" unique Album name in the pop up field in create new album window
    And they see an error message under album name input "<error message>"
    And they click Cancel button on Create New Album Window
    And they verify no album with the name "<album name>" was created

    Examples:
      | album name             | error message                                        |
      | alex_album123456123451 | Album Name must be between 1 and 20                  |
      | alex album             | Album Name cannot contain spaces or most punctuation |
      | alex,.!                | Album Name cannot contain spaces or most punctuation |


  Scenario: User can upload a photo to the album they created
    Given a user is logged into the account
    And they create new album with unique name
    And they see a success popup message "Album has been created"
    And they assert the unique album name is present on Album Page
    And they open unique album from Album Page
    When they upload a photo to the unique album
    Then they see the uploaded photo in the album
    And they open page Albums
    And they delete unique album from Album Page



