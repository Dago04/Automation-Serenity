package stepdefinitions.cucumbersteps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import stepdefinitions.serenitysteps.CommonSteps;
import stepdefinitions.serenitysteps.HomeSteps;
import stepdefinitions.serenitysteps.LogInSteps;

public class CucumberSteps {

    @Steps
    LogInSteps logInSignOffSteps;
    @Steps
    HomeSteps homeSteps;
    @Steps
    CommonSteps commonSteps;

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

    @When("I scroll to the home products section")
    public void scroll_to_home_products_section() {
        commonSteps.scrollToHomeProductsSection();
    }

    @Then("I validate invalid login message {string}")
    public void i_validate_invalid_login_message(String expectedMessage) {
        logInSignOffSteps.validateInvalidLoginMessage(expectedMessage);
    }

    @Then("I validate successful login message {string}")
    public void i_validate_successful_login_with_message(String expectedMessage) {
        homeSteps.validateSuccessfulLoginMessage(expectedMessage);
    }

    @Then("I validate login page is displayed with message {string}")
    public void i_validate_login_page_is_displayed_with_message(String expectedMessage) {
        logInSignOffSteps.validateLoginTitle(expectedMessage);
    }

}
