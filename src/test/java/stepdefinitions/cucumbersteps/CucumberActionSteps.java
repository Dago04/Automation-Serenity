package stepdefinitions.cucumbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import stepdefinitions.serenitysteps.CommonSteps;
import stepdefinitions.serenitysteps.HomeSteps;
import stepdefinitions.serenitysteps.LogInSteps;
import stepdefinitions.serenitysteps.WorldSectionSteps;

public class CucumberActionSteps {

    @Steps
    LogInSteps logInSignOffSteps;
    @Steps
    HomeSteps homeSteps;
    @Steps
    CommonSteps commonSteps;
    @Steps
    WorldSectionSteps worldSectionSteps;

    @Given("I navigate to the home page")
    public void i_navigate_to_the_home_page() {
        commonSteps.navigateToHomePage();
    }

    @When("I select {string} and {string} for delivery location")
    public void i_select_for_delivery_location(String option1, String option2) {
        commonSteps.selectDeliveryLocation(option1, option2);
    }

    @When("I login with valid credentials")
    public void i_login_with_valid_credentials() {
        logInSignOffSteps.loginWithValidCredentials();
    }

    @When("I login with invalid password credentials")
    public void i_login_with_invalid_password_credentials() {
        logInSignOffSteps.loginWithInvalidCredentials();
    }

    @When("I sign off from the account")
    public void i_sign_off_from_the_account() {
        homeSteps.signOff();
    }

    @When("The user navigates to a specific world section {string}")
    public void the_user_navigates_to_a_specific_world_section(String worldName) {
        worldSectionSteps.navigateToWorldSection(worldName);
    }

}
