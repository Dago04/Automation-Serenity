package stepdefinitions.cucumbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import stepdefinitions.serenitysteps.*;

public class CucumberActionSteps {

    @Steps
    LogInSteps logInSignOffSteps;
    @Steps
    HomeSteps homeSteps;
    @Steps
    CommonSteps commonSteps;
    @Steps
    WorldSectionSteps worldSectionSteps;
    @Steps
    HomeProductsCategorySteps homeProductsCategorySteps;

    @Given("The user navigates to the home page")
    public void the_user_navigates_to_the_home_page() {
        commonSteps.navigateToHomePage();
    }

    @Given("The user selects {string} and {string} for delivery location")
    public void the_user_selects_for_delivery_location(String option1, String option2) {
        commonSteps.selectDeliveryLocation(option1, option2);
    }

    @When("The user performs a login with valid credentials")
    public void login_with_valid_credentials() {
        logInSignOffSteps.loginWithValidCredentials();
    }

    @When("The user performs a login with invalid password credentials")
    public void login_with_invalid_credentials() {
        logInSignOffSteps.loginWithInvalidCredentials();
    }

    @When("The user signs off from the account")
    public void the_user_signs_off_from_the_account() {
        homeSteps.signOff();
    }

    @When("The user navigates to a specific world section {string}")
    public void the_user_navigates_to_a_specific_world_section(String worldName) {
        worldSectionSteps.navigateToWorldSection(worldName);
    }

    @When("The user selects a specific product category {string}")
    public void the(String categoryName) {
        homeProductsCategorySteps.selectProductCategory(categoryName);
    }

}
