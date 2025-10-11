package pageobjects;

import actions.ElementActions;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageObject {

    @FindBy(xpath = "//*[text()='Selecciona donde deseas que entreguemos tu pedido']/following::select[1]")
    private WebElementFacade departmentDropdown;

    @FindBy(xpath = "//*[text()='Aceptar']/ancestor::button[@type='button']")
    private WebElementFacade acceptDeliveryButton;

    @FindBy(xpath = "//*[text()='Entrar']/ancestor::button")
    private WebElementFacade myAccountButton;

    @FindBy(xpath = "(//*[@class='pr0     flex']/following::span[contains(normalize-space(.), 'Hola')])[2]")
    private WebElementFacade greetingMessage;

    public WebElementFacade getGreetingMessage() {
        return greetingMessage;
    }
    public WebElementFacade getMyAccountButton(){
        return myAccountButton;
    }
    public WebElementFacade getAcceptDeliveryButton(){
        return acceptDeliveryButton;
    }
    public void selectDropdown(String valor, int indiceSelect) {
        String xpathOpcion = String.format(
            "//*[text()='Selecciona donde deseas que entreguemos tu pedido']/following::select[%d]/option[normalize-space(text())='%s']",
            indiceSelect, valor
        );
        WebElementFacade option = find(By.xpath(xpathOpcion));
        ElementActions.safeClick(() -> option);
    }
}
