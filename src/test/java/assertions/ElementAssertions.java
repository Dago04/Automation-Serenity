package assertions;

import net.serenitybdd.core.pages.WebElementFacade;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ElementAssertions {

    public static void assertVisibleWithText(WebElementFacade element, String expectedText) {
        element.shouldBeVisible();
        assertThat(element.getText().trim()).isEqualTo(expectedText.trim());
    }
}
