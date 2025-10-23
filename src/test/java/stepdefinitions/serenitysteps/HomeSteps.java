package stepdefinitions.serenitysteps;

import net.serenitybdd.annotations.Step;
import pageobjects.HomePage;

public class HomeSteps {
    HomePage homePage;

    @Step("Sign off from user account")
    public void signOff(){
        homePage.signOff();
    }

    @Step("Validate successful login message {0}")
    public void validateSuccessfulLoginMessage(String expectedMessage) {
        homePage.validateGreetingMessage(expectedMessage);
    }

}
