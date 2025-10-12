Feature: Walmart Login and Navigation
  As a user
  I want to login to Walmart website
  So that I can access my account

  Scenario: Login with valid credentials
    Given I navigate to the home page
    When I select "El Progreso" from dropdown 1
    And I select "El Progreso" from dropdown 2
    And I click on "Accept Delivery button"
    And I click on "My Account button"
    And I enter "Dagoberto.Salas@walmart.com" in "email" field
    And I enter "G9t#x4VmZ8q@p2L" in "password" field
    Then I should see the message "Hola, dagoberto.salas@walmart.com"
