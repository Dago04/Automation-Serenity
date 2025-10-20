package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class CucumberSteps {

    @Steps
    SerenitySteps serenitySteps;

    @Steps
    ValidationSteps validationSteps;

    @Given("I navigate to the home page")
    public void i_navigate_to_the_home_page() {
        serenitySteps.navigateToHomePage();
    }

    @When("I select {string} and {string} for delivery location")
    public void i_select_for_delivery_location(String option1, String option2) {
        serenitySteps.selectDeliveryLocation(option1, option2);
    }

    @When("I login with email {string} and password {string}")
    public void i_login_with_email_and_password(String email, String password) {
        serenitySteps.userLogin(email, password);
    }

    @When("I sign off from the account")
    public void i_sign_off_from_the_account() {
        serenitySteps.signOff();
    }

    @Then("I validate invalid login message {string}")
    public void i_validate_invalid_login_message(String expectedMessage) {
        validationSteps.validateInvalidLoginMessage(expectedMessage);
    }

    @Then("I validate successful login message {string}")
    public void i_validate_successful_login_with_message(String expectedMessage) {
        validationSteps.validateSuccessfulLoginMessage(expectedMessage);
    }

    @Then("I validate login page is displayed with message {string}")
    public void i_validate_login_page_is_displayed_with_message(String expectedMessage) {
        validationSteps.validateLoginTitle(expectedMessage);
    }
}
