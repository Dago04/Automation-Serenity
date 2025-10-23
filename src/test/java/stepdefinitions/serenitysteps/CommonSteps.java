package stepdefinitions.serenitysteps;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractions;
import pageobjects.HomePage;

public class CommonSteps extends UIInteractions {

    HomePage homePage;

    @Step("Navigate to the home page")
    public void navigateToHomePage() {
        getDriver().navigate().to("https://www.walmart.com.gt/");
    }

    @Step("Select {0} and {1} for delivery location")
    public void selectDeliveryLocation(String option1, String option2) {
        homePage.selectDeliveryLocation(option1, option2);
    }
    @Step("Scroll to home products section")
    public void scrollToHomeProductsSection() {
        homePage.scrollToHomeProductsSection();
    }
}
