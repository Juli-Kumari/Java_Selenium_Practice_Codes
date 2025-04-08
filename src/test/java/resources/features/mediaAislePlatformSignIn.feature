Feature: Media Aisle Application Sign In

  @MediaAisle
  Scenario: Login to Media Aisle platform
    Given Open the media app link
    When I enter the credential
    Then I am on the home page of the Loop app