package stepdefinitions.serenitysteps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import pageobjects.HomePage;
import pageobjects.LoginPage;

public class LogInSteps extends UIInteractions {

    HomePage homePage;
    LoginPage loginPage;

    @Step("Login with valid credentials")
    public void loginWithValidCredentials() {
        String email = "Dagoberto.Salas@walmart.com";
        String password = "G9t#x4VmZ8q@p2L";
        loginPage.loginWithValidCredentials(email, password);
    }

    @Step("Login with invalid credentials")
    public void loginWithInvalidCredentials() {
        String email = "Dagoberto.Salas@walmart.com";
        String password = "G9t#x4VmZ8q@p2LTest";
        loginPage.loginWithInvalidCredentials(email, password);
    }

    @Step("Validate invalid login error message {0}")
    public void validateInvalidLoginMessage(String expectedMessage) {
        loginPage.validateAlertErrorMessage(expectedMessage);
    }
    @Step("Validate login title {0}")
    public void validateLoginTitle(String expectedMessage) {
        loginPage.validateLoginTitle(expectedMessage);
    }

}
