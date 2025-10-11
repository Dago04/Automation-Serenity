package test;

import net.serenitybdd.annotations.Steps;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import pageobjects.HomePage;
import pageobjects.LoginPage;
import steps.SerenitySteps;
import steps.ValidationSteps;

@ExtendWith(SerenityJUnit5Extension.class)
public class WalmartTest {
    HomePage homePage;
    LoginPage loginPage;
    String email = "Dagoberto.Salas@walmart.com";
    String password = "G9t#x4VmZ8q@p2L";

    @Steps
    SerenitySteps serenitySteps;

    @Steps
    ValidationSteps validationSteps;

    @Test
    public void LoginWithValidCredentials() {
        serenitySteps.navigateToHomePage();
        serenitySteps.selectFromDropdown("El Progreso", 1);
        serenitySteps.selectFromDropdown("El Progreso", 2);
        serenitySteps.clickOnElement("Accept Delivery button", homePage.getAcceptDeliveryButton());
        serenitySteps.clickOnElement("My Account button", homePage.getMyAccountButton());
        serenitySteps.typeInField(email, "email", loginPage.getEmailField());
        serenitySteps.typeInField(password,"password", loginPage.getPasswordField());
        validationSteps.validateElementMessage("Hola, "+ email.toLowerCase(), homePage.getGreetingMessage());

    }
}
