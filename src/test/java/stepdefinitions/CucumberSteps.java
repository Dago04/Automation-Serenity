package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class CucumberSteps {

    @Steps
    SerenitySteps serenitySteps;

    @Steps
    ValidationSteps validationSteps;

    HomePage homePage;
    LoginPage loginPage;

    @Given("I navigate to the home page")
    public void i_navigate_to_the_home_page() {
        serenitySteps.navigateToHomePage();
    }

    @When("I select {string} from dropdown {int}")
    public void i_select_from_dropdown(String option, int dropdown) {
        serenitySteps.selectFromDropdown(option, dropdown);
    }

    @When("I click on {string}")
    public void i_click_on(String buttonDescription) {
        if (buttonDescription.equals("Accept Delivery button")) {
            serenitySteps.clickOnElement(buttonDescription, homePage.getAcceptDeliveryButton());
        } else if (buttonDescription.equals("My Account button")) {
            serenitySteps.clickOnElement(buttonDescription, homePage.getMyAccountButton());
        }
    }

    @When("I enter {string} in {string} field")
    public void i_enter_in_field(String text, String fieldName) {
        if (fieldName.equals("email")) {
            serenitySteps.typeInField(text, fieldName, loginPage.getEmailField());
        } else if (fieldName.equals("password")) {
            serenitySteps.typeInField(text, fieldName, loginPage.getPasswordField());
        }
    }

    @Then("I should see the message {string}")
    public void i_should_see_the_message(String expectedMessage) {
        validationSteps.validateElementMessage(expectedMessage, homePage.getGreetingMessage());
    }
}
