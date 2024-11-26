
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ActionUtils {
    private WebDriver driver;
    private WebDriverWait wait;

    public ActionUtils(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Wait for an element to be visible
    public WebElement waitForElementToBeVisible(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element));
        } catch (TimeoutException e) {
            System.out.println("Element is not visible within the timeout period: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("An error occurred while waiting for the element to be visible: " + e.getMessage());
            return null;
        }
    }

    // Wait for an element to be clickable
    public WebElement waitForElementToBeClickable(WebElement element) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException e) {
            System.out.println("Element is not clickable within the timeout period: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("An error occurred while waiting for the element to be clickable: " + e.getMessage());
            return null;
        }
    }

    // Perform click action
    public void doClick(WebElement element) {
        try {
            if (waitForElementToBeVisible(element) != null && waitForElementToBeClickable(element) != null) {
             element.click();
                System.out.println("Successfully clicked on the element.");
            }
        } catch (Exception e) {
            System.out.println("Failed to click on the element: " + e.getMessage());
        }
    }
    public void doActionClick(WebElement element) {
        Actions actions=new Actions(driver);
        try {
            if (waitForElementToBeVisible(element) != null && waitForElementToBeClickable(element) != null) {
                actions.click(element);
                System.out.println("Successfully clicked on the element.");
            }
        } catch (Exception e) {
            System.out.println("Failed to click on the element: " + e.getMessage());
        }
    }

    // Perform sendKeys action
    public void doSendKeys(WebElement element, String text) {
        try {
            if (waitForElementToBeVisible(element) != null) {
                element.sendKeys(text);
                System.out.println("Successfully sent keys to the element.");
            }
        } catch (Exception e) {
            System.out.println("Failed to send keys to the element: " + e.getMessage());
        }
    }

    // Scroll to an element
    public void doScrollToElement(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", element);
            System.out.println("Successfully scrolled to the element.");
        } catch (Exception e) {
            System.out.println("Failed to scroll to the element: " + e.getMessage());
        }
    }

    // Perform drag and drop by offset
    public void doDragAndDropBy(WebElement element, int x, int y) {
        try {
            Actions actions = new Actions(driver);
            actions.dragAndDropBy(element, x, y).perform();
            System.out.println("Successfully dragged and dropped the element by offsets (" + x + ", " + y + ").");
        } catch (Exception e) {
            System.out.println("Failed to drag and drop the element: " + e.getMessage());
        }
    }

    // Verify text equality
    public void doVerifyText(String actual, String expected) {
        try {
            if (actual.equalsIgnoreCase(expected)) {
                System.out.println("Actual and Expected value are the same.");
            } else {
                System.out.println("Actual and Expected value are not the same.");
            }
        } catch (Exception e) {
            System.out.println("Failed to verify text: " + e.getMessage());
        }
    }
}
