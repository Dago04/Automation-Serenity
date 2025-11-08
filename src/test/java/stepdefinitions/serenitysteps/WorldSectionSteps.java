package stepdefinitions.serenitysteps;

import net.serenitybdd.annotations.Step;
import pageobjects.WorldSectionPage;

public class WorldSectionSteps {

    WorldSectionPage worldSectionPage;

    @Step("Navigate to the {0} world section")
    public void navigateToWorldSection(String worldSectionName) {
        try{
            worldSectionPage.navigateToWorldSection(worldSectionName);
        }catch(Exception e){
            throw new AssertionError("Test Failed", e);
        }
    }

    @Step("Validate the world section {0} is displayed")
    public void validateWorldSectionIsDisplayed(String expectedUrlPart) {
        try{
            worldSectionPage.validateWorldSectionIsDisplayed(expectedUrlPart);
        }catch(Exception e){
            throw new AssertionError("Test Failed", e);
        }
    }
}

