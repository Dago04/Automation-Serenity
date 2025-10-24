package pageobjects;

import actions.ElementActions;
import assertions.ElementAssertions;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import java.util.List;

public class WorldSectionPage extends PageObject {

    ElementActions elementActions;

    @FindBy(xpath = "//*[@class='vtex-render__container-id-slider-categories']//*[@data-testid='slider-track']")
    private WebElementFacade worldSectionSlider;

    @FindBy(xpath = "//*[@aria-label='Next Slide']")
    private WebElementFacade nextSlideArrow;

    @FindBy(xpath = "//*[@data-testid='breadcrumb']")
    private WebElementFacade breadCrumb;

    @FindBy(xpath = "//*[contains(@class,'galleryItem')]")
    private List<WebElementFacade> productItems;


    public void navigateToWorldSection(String name) {

        String xpath = String.format(
                "//*[@class='vtex-render__container-id-slider-categories']//*[@data-testid='slider-track']//a[@href='/%s']",
                name
        );

        String breadCrumb = "//*[@data-testid='breadcrumb']";

        int maxScrolls = 10;
        boolean found = false;

        for (int i = 0; i < maxScrolls; i++) {
            try {
                WebElementFacade worldSectionLink = find(xpath);

                if (worldSectionLink.isVisible()) {
                    elementActions.safeClick(() -> worldSectionLink);
                    waitFor(breadCrumb);
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
        try {
            validateUrlContainsSection(worldName);
            validateBreadcrumbIsVisible();
            waitForPageToLoad();
            validateSectionContentIsPresent(worldName);
        } catch (Exception e) {
            String currentUrl = getDriver().getCurrentUrl();
            throw new AssertionError(String.format(
                "❌ Failed to validate world section '%s' is displayed. Current URL: %s. Error: %s",
                worldName, currentUrl, e.getMessage()
            ));
        }
    }

    private void validateUrlContainsSection(String sectionName) {
        String currentUrl = getDriver().getCurrentUrl();
        ElementAssertions.assertUrlContains(currentUrl, sectionName);
        System.out.println("✅ URL validation passed: " + currentUrl);
    }

    private void validateBreadcrumbIsVisible() {
        ElementAssertions.assertVisible(breadCrumb);
        System.out.println("✅ Breadcrumb is visible");
    }

    private void waitForPageToLoad() {
        waitFor(3).seconds();
        System.out.println("✅ Page load wait completed");
    }

    private void validateSectionContentIsPresent(String worldName) {
        boolean hasSectionTitle = validateSectionTitleInBreadcrumb(worldName);
        boolean hasProducts = validateProductsAreVisible();

        if (!hasProducts && !hasSectionTitle) {
            throw new AssertionError("❌ The section page appears to be empty - no products or section title found");
        }

        System.out.println("✅ Section content validation completed successfully");
    }

    private boolean validateSectionTitleInBreadcrumb(String worldName) {
        String sectionTitleXpath = String.format(
                "//*[@data-testid='breadcrumb']//a[@href='/%s']",
                worldName
        );

        try {
            WebElementFacade sectionTitle = find(sectionTitleXpath);
            boolean isVisible = sectionTitle.isVisible();

            if (isVisible) {
                System.out.println("✅ Section title is displayed: " + sectionTitle.getText());
                return true;
            }
        } catch (Exception e) {
            System.out.println("⚠️ Section title not found in breadcrumb, checking for products instead");
        }

        return false;
    }

    private boolean validateProductsAreVisible() {
        boolean hasProducts = !productItems.isEmpty() && productItems.stream().anyMatch(WebElementFacade::isVisible);

        if (hasProducts) {
            int visibleProducts = (int) productItems.stream().filter(WebElementFacade::isVisible).count();
            System.out.println("✅ Section page loaded successfully with " + visibleProducts + " visible products");
            return true;
        }

        System.out.println("⚠️ No visible products found on the section page");
        return false;
    }
}
