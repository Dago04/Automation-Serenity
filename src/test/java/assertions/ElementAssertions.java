package assertions;

import net.serenitybdd.core.pages.WebElementFacade;
import org.junit.jupiter.api.Assertions;

public class ElementAssertions {

    public static void assertVisible(WebElementFacade element, String mensaje) {
        Assertions.assertTrue(element.isVisible(), mensaje);
    }

    public static void assertTextEquals(WebElementFacade element, String textoEsperado, String mensaje) {
        Assertions.assertEquals(textoEsperado, element.getText(), mensaje);
    }

    public static void assertEnabled(WebElementFacade element, String mensaje) {
        Assertions.assertTrue(element.isEnabled(), mensaje);
    }
}
