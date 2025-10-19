package pageobjects;

import actions.ElementActions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageObject {

    HomePage homePage;

    @FindBy(id = "email")
    private WebElementFacade txtEmail;

    @FindBy(xpath = "//*[text()='Contraseña']/following::input[@type='password']")
    private WebElementFacade txtPassword;

    @FindBy(xpath = "//*[text()='Bienvenido']/following::span[@class='walmartgt-walmart-components-0-x-alertDescription']")
    private WebElementFacade alertErrorDescription;

    public WebElementFacade getAlertErrorDescription() {
        return alertErrorDescription;
    }

    public void userLogin(String email, String password){
        homePage.clickMyAccount();
        ElementActions.safeType(() -> txtEmail, email);
        ElementActions.safeType(() -> txtPassword, password);
    }
}
