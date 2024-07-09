# Author: juanmblancom@gmail.com
Feature: Adding integer numbers
  I want to check a basic Calculator

  Scenario Outline: Adding numbers using differents builds
    Given I want to open a calculator page
    When The build is <select> adding numbers <number1> and <number2>
    Then Check a response is <response>

    Examples: 
      | select | number1 | number2 | response |
      |      0 |       5 |       5 |       10 |
      |      1 |       6 |       5 |        9 |
      |      2 |       5 |       4 |        9 |
      |      3 |       4 |       5 |        9 |
      |      4 |       5 |       5 |       10 |
      |      5 |       3 |       5 |        8 |
      |      6 |       5 |       5 |       10 |
      |      7 |       5 |       6 |       11 |
      |      8 |       5 |       5 |       10 |
      |      9 |       6 |       7 |       13 |
