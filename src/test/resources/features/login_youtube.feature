# Author: juanmblancom@gmail.com
Feature: Login in youtube
  I want to check a successfuly login in youtube

  Scenario Outline: User Youtube login
    Given Navigate to the page "https://youtube.com/"
    When Login with the email "<email>" and password "<password>"
    Then Observe the user text "<user>"

    Examples:
      | email | password | user |
      | email | password | user |