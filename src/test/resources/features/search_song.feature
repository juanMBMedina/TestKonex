# Author: juanmblancom@gmail.com
Feature: Search Song In Youtube
  I want to successfully play a song on YouTube

  Scenario Outline: Search Song In Youtube
    Given Navigate to the page "https://youtube.com/"
    When Search a son with name "<songName>"
    Then Successfully observe the song title

    Examples:
      | songName             |
      | Locked out of heaven |