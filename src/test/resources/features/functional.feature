Feature: Walmart GT Functional Tests

  Background:
    Given I navigate to the home page
    When I select "El Progreso" and "El Progreso" for delivery location

  Scenario: Login with valid credentials
    When I login with valid credentials
    Then I validate successful login message "Hola, Dagoberto"

  Scenario: Login with invalid password
    When I login with invalid password credentials
    Then I validate invalid login message "No se ingresó un correo electrónico válido o tu contraseña es incorrecta."

  Scenario: Sign off after successful login
    When I login with valid credentials
    And I sign off from the account
    Then I validate login page is displayed with message "Inicia sesión o crea una cuenta"

  @worldSectionNavigation
  Scenario: Navigate to a world section and validate navigation
    When  The user navigates to a specific world section "mundo-deportes"
    Then The correct page for the world section "mundo-deportes" should be displayed

  @homeProductCategory
  Scenario Outline: The user selects a product category from home page
    When The user selects a specific product category "<categoryName>"
    Then The selected product category should be "<categoryName>"

    Examples:
      | categoryName          |
      | Línea Blanca          |
      | Celulares y Pantallas |
      | Todo para el Hogar    |
