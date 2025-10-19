Feature: Walmart Login and Navigation
  As a user
  I want to login to Walmart website
  So that I can access my account

  Scenario: Login with valid credentials
    Given I navigate to the home page
    When I select "El Progreso" and "El Progreso" for delivery location
    And I login with email "Dagoberto.Salas@walmart.com" and password "G9t#x4VmZ8q@p2L"
    Then I should see the message "Hola, Dagoberto"

  Scenario: Login with invalid password
    Given I navigate to the home page
    When I select "El Progreso" and "El Progreso" for delivery location
    And I login with email "Dagoberto.Salas@walmart.com" and password "G9t#x4VmZ8q@p2LError"
    Then I should see the message "No se ingresó un correo electrónico válido o tu contraseña es incorrecta."
