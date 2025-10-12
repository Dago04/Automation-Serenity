package actions;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.*;

import java.time.Duration;
import java.util.function.Supplier;

public class ElementActions {
    // Método self-healing para hacer click
    public static void safeClick(Supplier<WebElementFacade> elementSupplier) {
        int retries = 3;
        for (int i = 0; i < retries; i++) {
            WebElementFacade element = elementSupplier.get();
            try {
                element.waitUntilClickable().click();
                return;
            } catch (NoSuchElementException e) {
                System.err.println("[safeClick] No se encontró el elemento en el intento " + (i + 1) + ": " + e.getMessage());
                if (i == retries - 1) throw e;
            } catch (TimeoutException e) {
                System.err.println("[safeClick] Timeout esperando el elemento en el intento " + (i + 1) + ": " + e.getMessage());
                if (i == retries - 1) throw e;
            } catch (StaleElementReferenceException e) {
                System.err.println("[safeClick] El elemento está obsoleto (stale) en el intento " + (i + 1) + ". Se volverá a buscar el elemento: "+ elementSupplier.get().getTagName() + "," + e.getMessage());
                if (i == retries - 1) throw e;
            } catch (ElementClickInterceptedException e) {
                System.err.println("[safeClick] El click fue interceptado en el intento " + (i + 1) + ": " + e.getMessage());
                if (i == retries - 1) throw e;
            } catch (ElementNotInteractableException e) {
                System.err.println("[safeClick] El elemento no es interactuable en el intento " + (i + 1) + ": " + e.getMessage());
                if (i == retries - 1) throw e;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {
            }
        }
    }

    // Método self-healing para escribir texto
    public static void safeType(Supplier<WebElementFacade> elementSupplier, String text) {
        int retries = 3;
        for (int i = 0; i < retries; i++) {
            WebElementFacade element = elementSupplier.get();
            try {
                element.waitUntilVisible().clear();
                element.typeAndEnter(text);
                return;
            } catch (NoSuchElementException e) {
                System.err.println("[safeType] No se encontró el elemento en el intento " + (i + 1) + ": " + e.getMessage());
                if (i == retries - 1) throw e;
            } catch (TimeoutException e) {
                System.err.println("[safeType] Timeout esperando el elemento en el intento " + (i + 1) + ": " + e.getMessage());
                if (i == retries - 1) throw e;
            } catch (StaleElementReferenceException e) {
                System.err.println("[safeType] El elemento está obsoleto (stale) en el intento " + (i + 1) + ". Se volverá a buscar el elemento. " + e.getMessage());
                if (i == retries - 1) throw e;
            } catch (ElementNotInteractableException e) {
                System.err.println("[safeType] El elemento no es interactuable en el intento " + (i + 1) + ": " + e.getMessage());
                if (i == retries - 1) throw e;
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {
            }
        }
    }

}
