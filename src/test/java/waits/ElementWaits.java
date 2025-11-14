package waits;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static net.serenitybdd.core.Serenity.getDriver;

public class ElementWaits {

    public static boolean waitForElementVisibility(WebElementFacade element, int waitTime, int attempt, int maxRetries) {

        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waitTime));
        try {
                wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        } catch (TimeoutException e) {
            if (attempt == maxRetries) {
                throw new RuntimeException("Element visibility condition not met after " + maxRetries + " attempts.", e);
            }
            return false;
        }
    }

    public static void waitForPageLoad(int waitTime) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(waitTime));
        wait.until(driver -> {
            JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
            return jsExecutor.executeScript("return document.readyState").equals("complete");
        });
    }
}
