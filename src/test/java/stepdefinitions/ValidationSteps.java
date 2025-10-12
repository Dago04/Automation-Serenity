package stepdefinitions;

import assertions.ElementAssertions;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractions;
import pageobjects.HomePage;

public class ValidationSteps extends UIInteractions {
    HomePage homePage;

    @Step("Validate text on element matches expected {0}")
    public void validateElementMessage(String expectedMessage, WebElementFacade element) {
        ElementAssertions.assertTextEquals(element, expectedMessage, "message does not match expected. test");
    }
}
