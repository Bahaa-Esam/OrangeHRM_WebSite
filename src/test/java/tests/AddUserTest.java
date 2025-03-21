package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import helpers.AuthHelper;
import pages.AdminPage;

public class AddUserTest extends BaseTest {
    private AdminPage adminPage;
    private AuthHelper authHelper;
    private static final Logger logger = LogManager.getLogger(AddUserTest.class);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        super.setUp();
        logger.info("[Add User Test] Setting up test...");
        adminPage = new AdminPage(driver);
        authHelper = new AuthHelper(driver);

        // Perform a valid login using AuthHelper
        authHelper.performValidLogin();
    }

    @Test(description = "Verify that an admin can successfully add a new employee")
    public void testAddUser() {
        logger.info("[Add User Test] Navigating to Admin Page...");
        adminPage.clickAdminItem();
        logger.info("[Add User Test] Verifying Admin Page...");
        Assert.assertTrue(adminPage.verifyNavigateToAdminPage(), "Failed to navigate to Admin Page");

        logger.info("[Add User Test] Adding a new employee...");
        adminPage.clickAddButton();
        adminPage.enterAddUsername("lool3o");
        adminPage.enterPassword("1234kokoko");
        adminPage.enterConfirmPassword("1234kokoko");
        adminPage.openAdminRoles();
        adminPage.selectAdminRole();
        adminPage.openStatusOptions();
        adminPage.selectEnableStatusOption();
        adminPage.enterAddEmployeeName("E");
        adminPage.selectSecondOptionEmployeeName();
        adminPage.clickSaveButton();

        // Validate employee addition
        Assert.assertTrue(adminPage.isUserAddedSuccessfully(), "[Error] The employee was not added successfully!");
        logger.info("[Add User Test] Employee added successfully.");
    }
}
