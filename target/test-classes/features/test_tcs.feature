# Author: juanmblancom@gmail.com
Feature: Prueba de ingreso a TCS
  Yo como automatizador de TCS quiero realizar la prueba de Evalart de forma correcta

  Background:
    * Ingresar a la url del sitio Evalart

  Scenario Outline: Llenar el formulario de la pagina de Evalart
    Given Ingresar con el usuario "<user>" y clave "<password>"
    When Se diligencia el formulario las veces necesarias
    And Validar que el formulario se repitio 10 veces
    Then validar la finalizacion correcta del formulario

    Examples:
      | user | password |
      | user | password |