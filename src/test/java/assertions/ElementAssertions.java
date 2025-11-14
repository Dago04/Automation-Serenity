package assertions;

import net.serenitybdd.core.pages.WebElementFacade;
import static org.assertj.core.api.Assertions.assertThat;

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

    public static void assertUrlContains(String expectedUrl, String expectedUrlPart) {
        assertThat(expectedUrl)
                .as("Validating that the URL contains the expected part")
                .containsIgnoringCase(expectedUrlPart);
    }

    public static void assertEqualsText(String actual, String expected) {
        assertThat(actual)
                .as("Validating that the selected category matches the expected name")
                .isEqualTo(expected);
    }
}
