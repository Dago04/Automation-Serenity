package stepdefinitions.cucumbersteps;

import io.cucumber.java.en.Then;
import net.serenitybdd.annotations.Steps;
import stepdefinitions.serenitysteps.*;

public class CucumberAssertionSteps {

    @Steps
    LogInSteps logInSteps;
    @Steps
    HomeSteps homeSteps;
    @Steps
    WorldSectionSteps worldSectionSteps;
    @Steps
    HomeProductsCategorySteps homeProductsCategorySteps;

    @Then("I validate invalid login message {string}")
    public void i_validate_invalid_login_message(String expectedMessage) {
        logInSteps.validateInvalidLoginMessage(expectedMessage);
    }

    @Then("I validate successful login message {string}")
    public void i_validate_successful_login_with_message(String expectedMessage) {
        homeSteps.validateSuccessfulLoginMessage(expectedMessage);
    }

    @Then("I validate login page is displayed with message {string}")
    public void i_validate_login_page_is_displayed_with_message(String expectedMessage) {
        logInSteps.validateLoginTitle(expectedMessage);
    }

    @Then("The correct page for the world section {string} should be displayed")
    public void the_correct_page_for_the_world_section_should_be_displayed(String expectedUrlPart) {
        worldSectionSteps.validateWorldSectionIsDisplayed(expectedUrlPart);
    }

    @Then("The selected product category should be {string}")
    public void the_selected_product_category_should_be(String expectedCategoryName) {
        homeProductsCategorySteps.validateSelectedCategory(expectedCategoryName);
    }
}

