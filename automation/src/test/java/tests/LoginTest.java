package tests;

import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import helpers.AuthHelper;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;
    private AuthHelper authHelper;
    private static final Logger logger = Logger.getLogger(LoginTest.class.getName());

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        logger.info("[LoginTest] Setting up LoginPage...");
        loginPage = new LoginPage(driver);
        authHelper = new AuthHelper(driver);
    }

    @Test
    public void validLoginTest() {
        logger.info("[LoginTest] Starting valid login test...");

        // Perform login using AuthHelper
        authHelper.performValidLogin();

        // Validate successful login
        Assert.assertTrue(loginPage.isLoginSuccessful(), "[Error] Login failed!");
        logger.info("[LoginTest] Login was successful.");

        // Perform logout
        loginPage.logout();

        // Validate logout by checking login page elements
        boolean isLoggedOut = loginPage.isInvalidLoginMessageDisplayed() || !loginPage.isLoginSuccessful();
        Assert.assertTrue(isLoggedOut, "[Error] User is not logged out successfully!");
        logger.info("[LoginTest] Logout was successful.");
    }

    @Test
    public void invalidLoginTest() {
        logger.info("[LoginTest] Starting invalid login test...");

        // Attempt invalid login
        loginPage.login("WrongUser", "WrongPass");

        // Validate that the invalid login message is displayed
        Assert.assertTrue(loginPage.isInvalidLoginMessageDisplayed(), "[Error] Invalid login message not displayed!");
        logger.info("[LoginTest] Invalid login message was displayed as expected.");
    }
}
