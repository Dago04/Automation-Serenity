package stepdefinitions.serenitysteps;

import net.serenitybdd.annotations.Step;
import pageobjects.WorldSectionPage;

public class WorldSectionSteps {

    WorldSectionPage worldSectionPage;

    @Step("Navigate to the {0} world section")
    public void navigateToWorldSection(String worldSectionName) {
        worldSectionPage.navigateToWorldSection(worldSectionName);
    }

    @Step("Validate the world section {0} is displayed")
    public void validateWorldSectionIsDisplayed(String expectedUrlPart) {
        worldSectionPage.validateWorldSectionIsDisplayed(expectedUrlPart);
    }

}

