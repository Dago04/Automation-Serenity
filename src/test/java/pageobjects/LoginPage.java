package pageobjects;

import actions.ElementActions;
import assertions.ElementAssertions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;
import waits.ElementWaits;

public class LoginPage extends PageObject {

    ElementActions elementActions;
    HomePage homePage;

    @FindBy(xpath = "//*[text()='Correo']/following-sibling::div[1]/input")
    private WebElementFacade txtEmail;

    @FindBy(xpath = "//*[text()='Contraseña']/following::input[@type='password']")
    private WebElementFacade txtPassword;

    @FindBy(xpath = "//*[text()='Bienvenido']/following::span[@class='walmartgt-walmart-components-0-x-alertDescription']")
    private WebElementFacade alertErrorDescription;

    @FindBy(xpath = "//h3[text()='Inicia sesión o crea una cuenta']")
    private WebElementFacade loginTitle;

    @FindBy(xpath = "//*[text()='Continuar']")
    private WebElementFacade btnContinue;

    @FindBy(xpath = "//*[text()='Iniciar sesión']")
    private WebElementFacade btnLogin;

    public void loginWithValidCredentials(String email, String password) {
        homePage.clickMyAccount();

        int maxRetries = 3;

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            if (attempt > 1) {
                getDriver().navigate().refresh();
            }

            elementActions.safeType(() -> txtEmail, email);
            elementActions.jsClick(() -> btnContinue);
            if (!ElementWaits.waitForElementVisibility(txtPassword, 6, true, attempt, maxRetries)) continue;

            elementActions.safeType(() -> txtPassword, password);
            elementActions.jsClick(() -> btnLogin);
            if (ElementWaits.waitForElementVisibility(homePage.getGreetingMessage(), 6,true, attempt, maxRetries)) {
                return;
            }
        }
    }

    public void loginWithInvalidCredentials(String email, String password) {
        homePage.clickMyAccount();

        int maxRetries = 3;

        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            if (attempt > 1) {
                getDriver().navigate().refresh();
            }

            elementActions.safeType(() -> txtEmail, email);
            elementActions.jsClick(() -> btnContinue);
            if (!ElementWaits.waitForElementVisibility(txtPassword, 6, true, attempt, maxRetries)) continue;

            elementActions.safeType(() -> txtPassword, password);
            elementActions.jsClick(() -> btnLogin);
            if (ElementWaits.waitForElementVisibility(alertErrorDescription, 6,true, attempt, maxRetries)) {
                return;
            }
        }
    }

    public void validateAlertErrorMessage(String expectedMessage) {
        ElementAssertions.assertWithText(alertErrorDescription, expectedMessage);
    }
    public void validateLoginTitle(String expectedMessage) {
        ElementAssertions.assertWithText(loginTitle, expectedMessage);
    }
}
