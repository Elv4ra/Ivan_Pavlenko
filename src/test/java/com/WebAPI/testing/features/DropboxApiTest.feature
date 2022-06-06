Feature:
  Testing Dropbox API v2

  Background: User has already signed up on the Dropbox.com

  Scenario Outline: Testing upload file operation
    Given User has file "<name>" placed at root directory of the app
    When User uploads file to the Dropbox using API
    Then API responses with file "<name>" metadata
    Examples:
    | name     |
    | data.pdf |


  Scenario Outline: Testing get file metadata operation
    Given User has already uploaded file "<name>" to the Dropbox
    When User gets file metadata using Dropbox API
    Then API responses with file "<name>" metadata
    Examples:
    | name     |
    | data.pdf |


  Scenario Outline: Testing delete file operation
    Given User has file "<name>" in the Dropbox storage
    When User deletes file from Dropbox using API
    Then API responses with deleted file "<name>" metadata
    Examples:
    | name     |
    | data.pdf |
