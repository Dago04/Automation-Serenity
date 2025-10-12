package assertions;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.jupiter.api.Assertions;

public class ElementAssertions {

    public static void assertVisibleWithText(WebElementFacade element, String expectedText) {
        element.waitUntilVisible();
        Assertions.assertTrue(element.isVisible(), "The element is not visible");
        Assertions.assertEquals(expectedText.trim(), element.getText().trim(), "The text does not match the expected value");
    }

    public static void assertEnabled(WebElementFacade element, String mensaje) {
        Assertions.assertTrue(element.isEnabled(), mensaje);
    }
}
