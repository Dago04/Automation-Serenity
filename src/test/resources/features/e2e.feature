Feature: Walmart GT Functional Tests

  Background:
    Given I navigate to the home page
    When I select "El Progreso" and "El Progreso" for delivery location

  Scenario: Login with valid credentials
    When I login with email "Dagoberto.Salas@walmart.com" and password "G9t#x4VmZ8q@p2L"
    Then I validate successful login message "Hola, Dagoberto"

  Scenario: Login with invalid password
    When I login with email "Dagoberto.Salas@walmart.com" and password "G9t#x4VmZ8q@p2LError"
    Then I validate invalid login message "No se ingresó un correo electrónico válido o tu contraseña es incorrecta."

  Scenario: Sign off after successful login
    When I login with email "Dagoberto.Salas@walmart.com" and password "G9t#x4VmZ8q@p2L"
    And I sign off from the account
    Then I validate login page is displayed with message "Inicia sesión o crea una cuenta"

