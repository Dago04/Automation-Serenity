package stepdefinitions.cucumbersteps;

import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import stepdefinitions.serenitysteps.CommonSteps;
import stepdefinitions.serenitysteps.HomeSteps;
import stepdefinitions.serenitysteps.LogInSteps;

public class CucumberAssertionSteps {

    @Steps
    LogInSteps logInSignOffSteps;
    @Steps
    HomeSteps homeSteps;

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
