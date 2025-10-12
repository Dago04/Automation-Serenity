package stepdefinitions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractions;
import pageobjects.HomePage;
import actions.ElementActions;

public class SerenitySteps extends UIInteractions {

    HomePage homePage;

    @Step("Navigate to the home page")
    public void navigateToHomePage() {
        getDriver().navigate().to("https://www.walmart.com.gt/");
    }
    @Step("Select option {0} from dropdown {1}")
    public void selectFromDropdown(String option, int dropdown) {
        homePage.selectDropdown(option, dropdown);
    }

    @Step("Enter {0} in {1} field")
    public void typeInField(String text, String field, WebElementFacade element) {
        ElementActions.safeType(() -> element, text);
        waitFor(5).seconds();
    }
    @Step("Click on {0}")
    public void clickOnElement(String description, WebElementFacade element){
        ElementActions.safeClick(() -> element);
    }

}
