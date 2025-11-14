package actions;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractions;
import org.openqa.selenium.*;
import java.util.function.Supplier;

public class ElementActions extends UIInteractions {

    public void safeClick(Supplier<WebElementFacade> elementSupplier) {
        int retries = 2;
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
                try {
                    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
                    waitFor(2).seconds();
                    return;
                } catch (Exception jsException) {
                    System.err.println("[safeClick] También falló el clic con JavaScript: " + jsException.getMessage());
                    if (i == retries - 1) throw e;
                }
            } catch (ElementClickInterceptedException e) {
                System.err.println("[safeClick] El click fue interceptado, intentando con JavaScript en el intento " + (i + 1));
                try {
                    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
                    waitFor(2).seconds();
                    return;
                } catch (Exception jsException) {
                    System.err.println("[safeClick] También falló el clic con JavaScript: " + jsException.getMessage());
                    if (i == retries - 1) throw e;
                }
            } catch (ElementNotInteractableException e) {
                System.err.println("[safeClick] El elemento no es interactuable en el intento " + (i + 1) + ": " + e.getMessage());
                if (i == retries - 1) throw e;
            }
            try {
                Thread.sleep(300);
            } catch (InterruptedException ignored) {
            }
        }
    }

    public void safeType(Supplier<WebElementFacade> elementSupplier, String text) {
        int retries = 3;
        for (int i = 0; i < retries; i++) {
            WebElementFacade element = elementSupplier.get();
            try {
                element.waitUntilVisible().clear();
                element.type(text);
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
                Thread.sleep(300);
            } catch (InterruptedException ignored) {
            }
        }
    }

    public void scrollToElement(Supplier<WebElementFacade> elementSupplier) {
        int maxRetries = 1;
        int scrollAttempts = 10;

        for (int retry = 0; retry < maxRetries; retry++) {
            try {
                WebElementFacade element = elementSupplier.get();
                if (element.isCurrentlyVisible()) {
                    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException ignored) {
                    }
                    return;
                }
            } catch (NoSuchElementException | TimeoutException e) {
                System.out.println("[scrollToElement] Elemento no encontrado inicialmente, haciendo scroll gradual. Intento: " + (retry + 1));
            }

            for (int scrollStep = 0; scrollStep < scrollAttempts; scrollStep++) {
                try {
                    ((JavascriptExecutor) getDriver()).executeScript("window.scrollBy(0, 300);");
                    Thread.sleep(300);

                    WebElementFacade element = elementSupplier.get();
                    if (element.isCurrentlyVisible()) {
                        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
                        Thread.sleep(300);
                        return;
                    }
                } catch (NoSuchElementException | TimeoutException e) {
                    // Continuar con el siguiente paso de scroll
                } catch (InterruptedException ignored) {
                }
            }
            if (retry < maxRetries - 1) {
                System.out.println("[scrollToElement] Volviendo al inicio de la página para reintentar...");
                ((JavascriptExecutor) getDriver()).executeScript("window.scrollTo(0, 0);");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ignored) {
                }
            }
        }

        throw new NoSuchElementException("No se pudo encontrar el elemento después de " + maxRetries + " intentos con scroll gradual");
    }

    public void jsClick(Supplier<WebElementFacade> elementSupplier) {
        int retries = 2;
        for (int i = 0; i < retries; i++) {
            WebElementFacade element = elementSupplier.get();
            try {
                element.waitUntilVisible();
                ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", element);
                System.out.println("[jsClick] Click ejecutado con JavaScript en intento " + (i + 1));
                return;
            } catch (NoSuchElementException e) {
                System.err.println("[jsClick] No se encontró el elemento en el intento " + (i + 1) + ": " + e.getMessage());
                if (i == retries - 1) throw e;
            } catch (TimeoutException e) {
                System.err.println("[jsClick] Timeout esperando el elemento en el intento " + (i + 1) + ": " + e.getMessage());
                if (i == retries - 1) throw e;
            } catch (StaleElementReferenceException e) {
                System.err.println("[jsClick] El elemento está obsoleto (stale) en el intento " + (i + 1) + ". Se volverá a buscar el elemento: "+ elementSupplier.get().getTagName() + "," + e.getMessage());
                if (i == retries - 1) throw e;
            } catch (Exception e) {
                System.err.println("[jsClick] Error con JavaScript executor en intento " + (i + 1) + ": " + e.getMessage());
                if (i == retries - 1) throw e;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException ignored) {
            }
        }
    }

}
