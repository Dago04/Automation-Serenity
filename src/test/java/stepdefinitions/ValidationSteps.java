package stepdefinitions;

import assertions.ElementAssertions;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractions;

public class ValidationSteps extends UIInteractions {

    @Step("Validate text on element matches expected {0}")
    public void validateElementMessage(String expectedMessage, WebElementFacade element) {
        ElementAssertions.assertVisibleWithText(element, expectedMessage);
    }
}
