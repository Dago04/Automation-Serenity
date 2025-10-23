package assertions;

import net.serenitybdd.core.pages.WebElementFacade;

import java.time.Duration;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ElementAssertions {

    public static void assertWithText(WebElementFacade element, String expectedText) {
        element.waitUntilVisible();
        element.waitUntilPresent();
        element.shouldContainText(expectedText);
    }

    public static void assertVisible(WebElementFacade element) {
        element.waitUntilVisible();
        element.shouldBeVisible();
    }
}
