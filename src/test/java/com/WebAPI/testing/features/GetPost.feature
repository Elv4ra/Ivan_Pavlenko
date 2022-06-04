Feature:
  Testing Dropbox API v2

  Background: User has already signed up on the Dropbox.com

  Scenario Outline: Testing upload file operation
    Given User has file "<name>" placed at root directory of the app
    When User uploads file "<name>" to the Dropbox using API
    Then API responses with metadata
    Examples:
    | name     |
    | data.pdf |


  Scenario Outline: Testing get file metadata operation
    Given User has already uploaded file "<name>" to the Dropbox
    When User gets file "<name>" metadata using Dropbox API
    Then metadata must be same as response from upload operation
    Examples:
    | name     |
    | data.pdf |


  Scenario Outline: Testing delete file operation
    Given User has already uploaded file "<name>" to the Dropbox
    When User deletes file "<name>" from Dropbox using API
    Then file is deleted
    Examples:
    | name     |
    | data.pdf |
