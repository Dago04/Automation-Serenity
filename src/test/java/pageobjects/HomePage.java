package pageobjects;

import actions.ElementActions;
import assertions.ElementAssertions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    ElementActions elementActions;

    @FindBy(xpath = "//*[text()='Aceptar']/ancestor::button[@type='button']")
    private WebElementFacade btnAcceptDelivery;

    @FindBy(xpath = "//*[text()='Entrar']/ancestor::button")
    private WebElementFacade bntMyAccount;

    @FindBy(xpath = "(//*[@class='pr0     flex']/following::span[contains(normalize-space(.), 'Hola')])[2]")
    private WebElementFacade greetingMessage;

    @FindBy(xpath = "(//*[@class='pr0     flex']/following::span[contains(normalize-space(.), 'Hola')])[2]/ancestor::button")
    private WebElementFacade btnGreetingMessage;

    @FindBy(xpath = "//*[text()='Salir']/ancestor::button")
    private WebElementFacade btnLogout;

    @FindBy(xpath = "//span[text()='Frescos']")
    private WebElementFacade sectionHomeProducts;

    public void selectDropdown(String valor, int index) {
        String xpathOpcion = String.format(
            "//*[text()='Selecciona donde deseas que entreguemos tu pedido']/following::select[%d]/option[normalize-space(text())='%s']",
                index, valor
        );
        WebElementFacade option = find(By.xpath(xpathOpcion));
        elementActions.safeClick(() -> option);
    }

    public void selectDeliveryLocation(String option1, String option2) {
        selectDropdown(option1, 1);
        selectDropdown(option2, 2);
        elementActions.safeClick(() -> btnAcceptDelivery);
    }

    public void clickMyAccount(){
        elementActions.safeClick(() -> bntMyAccount);
    }

    public void signOff(){
        elementActions.safeClick(() -> btnGreetingMessage);
        elementActions.safeClick(() -> btnLogout);
        clickMyAccount();
    }

    public void validateGreetingMessage(String expectedMessage){
        ElementAssertions.assertWithText(greetingMessage, expectedMessage);
    }

    public WebElementFacade getGreetingMessage() {
        return greetingMessage;
    }
}
