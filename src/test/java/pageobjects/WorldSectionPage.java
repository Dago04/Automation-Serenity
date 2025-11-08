package pageobjects;

import actions.ElementActions;
import assertions.ElementAssertions;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class WorldSectionPage extends PageObject {

    ElementActions elementActions;

    @FindBy(xpath = "//*[@aria-label='Next Slide']")
    private WebElementFacade nextSlideArrow;

    public void navigateToWorldSection(String name) {

        String xpath = String.format(
                "//*[@class='vtex-render__container-id-slider-categories']//*[@data-testid='slider-track']//a[@href='/%s']",
                name
        );


        int maxScrolls = 10;
        boolean found = false;

        for (int i = 0; i < maxScrolls; i++) {
            try {
                WebElementFacade worldSectionLink = find(xpath);

                if (worldSectionLink.isVisible()) {
                    elementActions.safeClick(() -> worldSectionLink);
                    waitForPageToLoad();
                    found = true;
                    break;
                } else {
                    if (nextSlideArrow.isVisible()) {
                        elementActions.jsClick(() -> nextSlideArrow);
                    } else {
                        break;
                    }
                }

            } catch (Exception e) {
                if (nextSlideArrow.isVisible()) {
                    elementActions.jsClick(() -> nextSlideArrow);
                }
            }
        }

        if (!found) {
            throw new RuntimeException("❌ Could not find section with name: " + name);
        }
    }

    public void validateWorldSectionIsDisplayed(String worldName) {
        String currentUrl = getDriver().getCurrentUrl();
        try {
            ElementAssertions.assertUrlContains(currentUrl, worldName);
        } catch (Exception e) {
            throw new AssertionError("❌ Error validating URL contains world section name", e);
        }
    }

    private void waitForPageToLoad() {
        waitFor(2).seconds();
    }
}
