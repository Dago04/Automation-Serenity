package pageobjects;

import actions.ElementActions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    @FindBy(id = "email")
    private WebElementFacade emailField;

    @FindBy(xpath = "//*[text()='Contraseña']/following::input[@type='password']")
    private WebElementFacade passwordField;

    @FindBy(xpath = "//*[text()='Bienvenido']/following::span[@class='walmartgt-walmart-components-0-x-alertDescription']")
    private WebElementFacade alertErrorDescription;

    public WebElementFacade getEmailField() {
        return emailField;
    }
    public WebElementFacade getPasswordField() {
        return passwordField;
    }
    public WebElementFacade getAlertErrorDescription() {
        return alertErrorDescription;
    }
}
