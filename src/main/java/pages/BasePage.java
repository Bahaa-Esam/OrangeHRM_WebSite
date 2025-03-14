package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.logging.Logger;
import org.openqa.selenium.support.ui.Select;
import java.nio.file.Paths;


/**
 * BasePage serves as a foundation for all page classes, providing common web interactions and utilities.
 */
public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    private static final Logger logger = Logger.getLogger(BasePage.class.getName());

    /**
     * Constructor to initialize WebDriver and WebDriverWait.
     *
     * @param driver the WebDriver instance to interact with the browser
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    
    public void selectDropdownByVisibleText(By locator, String visibleText) {
        try {
            WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            Select dropdown = new Select(dropdownElement);
            dropdown.selectByVisibleText(visibleText);
            logger.info("Selected '" + visibleText + "' from dropdown: " + locator);
        } catch (Exception e) {
            logger.severe("Failed to select '" + visibleText + "' from dropdown: " + locator + " - " + e.getMessage());
        }
    }
    

    /**
     * Uploads a file located in the resources folder to the specified file input element.
     *
     * @param locator   The By locator of the file input element.
     * @param fileName  The name of the file in the resources folder.
     */
    public void uploadFile(By fileInputLocator, String fileName) {
        // Get the absolute path of the file from the resources folder
    	String filePath = Paths.get("src/test/resources/Test_case.pdf").toAbsolutePath().toString();

        // Find the input element and send the file path
        driver.findElement(fileInputLocator).sendKeys(filePath);
    }


    /**
     * Waits for an element to be visible on the page.
     *
     * @param locator the By locator of the element
     * @return the visible WebElement, or null if not found
     */
    public WebElement waitUntilVisible(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            logger.warning(getLogPrefix() + "Element not visible: " + locator);
        } catch (Exception e) {
            logger.severe(getLogPrefix() + "Failed to wait for element visibility: " + e.getMessage());
        }
        return null;
    }

    /**
     * Waits for an element to be clickable on the page.
     *
     * @param locator the By locator of the element
     * @return the clickable WebElement, or null if not found
     */
    public WebElement waitUntilClickable(By locator) {
        try {
            return wait.until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            logger.warning(getLogPrefix() + "Element not clickable: " + locator);
        } catch (Exception e) {
            logger.severe(getLogPrefix() + "Failed to wait for element to be clickable: " + e.getMessage());
        }
        return null;
    }

    /**
     * Clicks on an element after ensuring it's clickable.
     *
     * @param locator the By locator of the element to click
     */
    public void clickElement(By locator) {
        try {
            WebElement element = waitUntilClickable(locator);
            if (element != null) {
                element.click();
            } else {
                logger.warning(getLogPrefix() + "Click action failed. Element not clickable: " + locator);
            }
        } catch (Exception e) {
            logger.severe(getLogPrefix() + "Failed to click element: " + locator + " - " + e.getMessage());
        }
    }

    /**
     * Types text into an element after ensuring it's visible.
     *
     * @param locator the By locator of the element
     * @param text    the text to type into the element
     */
    public void typeText(By locator, String text) {
        try {
            WebElement element = waitUntilVisible(locator);
            if (element != null) {
                element.clear();
                element.sendKeys(text);
            } else {
                logger.warning(getLogPrefix() + "Text input failed. Element not visible: " + locator);
            }
        } catch (Exception e) {
            logger.severe(getLogPrefix() + "Failed to type text into element: " + locator + " - " + e.getMessage());
        }
    }

    /**
     * Retrieves text from an element safely.
     *
     * @param locator the By locator of the element
     * @return the text of the element, or an empty string if not found
     */
    public String getElementText(By locator) {
        try {
            WebElement element = waitUntilVisible(locator);
            return element != null ? element.getText() : "";
        } catch (Exception e) {
            logger.severe(getLogPrefix() + "Unable to retrieve text from element: " + locator + " - " + e.getMessage());
            return "";
        }
    }

    /**
     * Checks if an element is displayed on the page.
     *
     * @param locator the By locator of the element
     * @return true if the element is displayed; false otherwise
     */
    public boolean isElementDisplayed(By locator) {
        try {
            WebElement element = waitUntilVisible(locator);
            return element != null && element.isDisplayed();
        } catch (Exception e) {
            logger.warning(getLogPrefix() + "Unable to check if element is displayed: " + locator);
            return false;
        }
    }

//    /**
//     * Verifies if an element is displayed and contains the expected text.
//     *
//     * @param locator      the By locator of the element
//     * @param expectedText the expected text to verify
//     * @return true if the element is displayed and contains the expected text; false otherwise
//     */
//    public boolean isElementDisplayedWithText(By locator, String expectedText) {
//        try {
//            WebElement element = waitUntilVisible(locator);
//            if (element != null && element.isDisplayed()) {
//                String actualText = element.getText();
//                return actualText.equals(expectedText);
//            }
//        } catch (Exception e) {
//            logger.warning(getLogPrefix() + "Error verifying element text: " + e.getMessage());
//        }
//        return false;
//    }

    /**
     * Retrieves the current page URL.
     *
     * @return the current URL as a string
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Waits for the entire page to load completely.
     */
    public void waitForPageLoad() {
        try {
            wait.until(driver -> ((JavascriptExecutor) driver)
                    .executeScript("return document.readyState").equals("complete"));
        } catch (TimeoutException e) {
            logger.warning(getLogPrefix() + "Page did not load completely in the expected time.");
        } catch (Exception e) {
            logger.severe(getLogPrefix() + "Failed to wait for page load: " + e.getMessage());
        }
    }

    /**
     * Generates a log prefix for consistent logging.
     *
     * @return the log prefix as a string
     */
    private String getLogPrefix() {
        return "[BasePage] ";
    }
    


}
