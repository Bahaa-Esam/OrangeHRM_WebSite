package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.logging.Logger;

public class LoginPage {
    private final BasePage elementUtil;
    private static final Logger logger = Logger.getLogger(LoginPage.class.getName());

    public LoginPage(WebDriver driver) {
        this.elementUtil = new BasePage(driver);
    }

    // Locators
    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By validLoginMessage = By.cssSelector(".oxd-text--h6");
    private final By invalidLoginMessage = By.cssSelector(".oxd-alert-content");
    private final By usernameIcon = By.cssSelector(".oxd-userdropdown-tab");
    private final By logoutButton = By.xpath("//a[text()='Logout']");

    // Enter username
    public void enterUsername(String username) {
        logger.info("[LoginPage] Entering username: " + username);
        elementUtil.typeText(usernameField, username);
    }

    // Enter password
    public void enterPassword(String password) {
        logger.info("[LoginPage] Entering password");
        elementUtil.typeText(passwordField, password);
    }

    // Click login button
    public void clickLoginButton() {
        logger.info("[LoginPage] Clicking login button");
        elementUtil.clickElement(loginButton);
    }

    // Perform login action
    public void login(String username, String password) {
        logger.info("[LoginPage] Attempting login with username: " + username);
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
    
    // Perform valid admin login and verify success
    public void performValidLogin() {
        logger.info("[LoginPage] Performing valid Admin login...");
        login("Admin", "admin123"); // Reusing the existing login method

        if (!isLoginSuccessful()) {
            logger.severe("[LoginPage] Admin login failed!");
            throw new AssertionError("[Error] Admin login failed!");
        }
        
        logger.info("[LoginPage] Admin login was successful.");
    }

    // Check if login was successful
    public boolean isLoginSuccessful() {
        boolean success = elementUtil.isElementDisplayed(validLoginMessage);
        logger.info("[LoginPage] Login success status: " + success);
        return success;
    }

    // Check if invalid login message is displayed
    public boolean isInvalidLoginMessageDisplayed() {
        boolean failure = elementUtil.isElementDisplayed(invalidLoginMessage);
        logger.info("[LoginPage] Invalid login message displayed: " + failure);
        return failure;
    }

    // Perform logout action
    public void logout() {
        logger.info("[LoginPage] Performing logout");
        clickUsernameIcon();
        clickLogoutButton();
    }

    // Click the username dropdown
    private void clickUsernameIcon() {
        logger.info("[LoginPage] Clicking username icon");
        elementUtil.clickElement(usernameIcon);
    }

    // Click logout button
    private void clickLogoutButton() {
        logger.info("[LoginPage] Clicking logout button");
        elementUtil.clickElement(logoutButton);
    }
}
