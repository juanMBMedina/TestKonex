# Author: juanmblancom@gmail.com
Feature: Validate A Create Account In Wikipedia
  I want to create a successfuly Wikipedia's Account

  Scenario: Create Account In Wikipedia
    Given Navigate to the page "https://es.wikipedia.org/wiki/Wikipedia:Portada"
    When I want to create an Account using
      | JuanMiblanco | juan.blanco.test01@gmail.com | 12345678# |
    Then Validate Alert of Captcha's Edit Text
