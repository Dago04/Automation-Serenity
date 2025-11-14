package stepdefinitions.serenitysteps;

import actions.ElementActions;
import assertions.ElementAssertions;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractions;
import pageobjects.HomePage;
import waits.ElementWaits;

public class CommonSteps extends UIInteractions {

    ElementActions elementActions;
    HomePage homePage;

    @Step("Navigate to the home page")
    public void navigateToHomePage() {
        getDriver().navigate().to("https://www.walmart.com.gt/");
    }

    @Step("Select {0} and {1} for delivery location")
    public void selectDeliveryLocation(String option1, String option2) {
        homePage.selectDeliveryLocation(option1, option2);
        ElementWaits.waitForPageLoad(5);
    }

    @Step("The user should see a element with the text {0} displayed")
    public void validateElementWithTextIsDisplayed(String text) {
        ElementWaits.waitForPageLoad(5);
        WebElementFacade element = elementActions.getElementByText(text);
        ElementAssertions.assertVisible(element);
    }
}
