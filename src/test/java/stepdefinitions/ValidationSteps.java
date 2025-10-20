package stepdefinitions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class ValidationSteps extends UIInteractions {

    HomePage homePage;
    LoginPage loginPage;

    @Step("Validate successful login message {0}")
    public void validateSuccesfulLoginMessage(String expectedMessage) {
       homePage.validateGreetingMessage(expectedMessage);
    }

    @Step("Validate invalid login error message {0}")
    public void validateInvalidLoginMessage(String expectedMessage) {
        loginPage.validateAlertErrorMessage(expectedMessage);
    }

}
