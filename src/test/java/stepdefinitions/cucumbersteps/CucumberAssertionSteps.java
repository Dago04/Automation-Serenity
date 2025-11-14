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
    @Steps
    CommonSteps commonSteps;

    @Then("The user should see a element with the text {string} displayed")
    public void the_user_should_see_a_element_with_the_text_displayed(String text) {
        commonSteps.validateElementWithTextIsDisplayed(text);
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

