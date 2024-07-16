# Author: juanmblancom@gmail.com
Feature: Validate Home Message In Wikipedia
  I want to check a successfuly Wikipedia's Home Page

  Scenario: Get Welcome Text in Wikipedia's Home Page
    Given Navigate to the page "https://es.wikipedia.org/wiki/Wikipedia:Portada"
    When I can get text of the home page in wikipedia
    Then Observe the home text "Bienvenidos a Wikipedia"
