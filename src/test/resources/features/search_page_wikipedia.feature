# Author: juanmblancom@gmail.com
Feature: Validate A Search In Wikipedia
  I want to check a successfuly Wikipedia's Search

  Scenario: Get Welcome Text in Wikipedia's Search
    Given Navigate to the page "https://es.wikipedia.org/wiki/Wikipedia:Portada"
    When I want to search a word "Sistema"
    Then Validate the title "Análisis CEEM" doing Scroll
