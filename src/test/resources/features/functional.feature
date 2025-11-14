Feature: Walmart GT Functional Tests

  Background:
    Given The user navigates to the home page
    And The user selects "El Progreso" and "El Progreso" for delivery location

  Scenario: Login with valid credentials
    When The user performs a login with valid credentials
    Then The user should see a element with the text "Hola" displayed

  Scenario: Login with invalid password
    When The user performs a login with invalid password credentials
    Then The user should see a element with the text "Lo sentimos, hubo un error" displayed

  Scenario: Sign off after successful login
    When The user performs a login with valid credentials
    And The user signs off from the account
    Then The user should see a element with the text "Entrar" displayed

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
