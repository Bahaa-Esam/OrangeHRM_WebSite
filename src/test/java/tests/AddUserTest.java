package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;
import java.util.logging.Logger;

public class AddUserTest extends BaseTest {
    private AdminPage adminPage;
    private LoginPage loginPage;
    private static final Logger logger = Logger.getLogger(AddUserTest.class.getName());

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        super.setUp(); // Initializes the base test setup

        logger.info("[Add User Test] Setting up test...");
        adminPage = new AdminPage(driver);
        loginPage = new LoginPage(driver);

        // Perform a valid login
        loginPage.performValidLogin();
    }

    @Test(description = "Verify that an admin can successfully add a new employee")
    public void testAddUser() {
        logger.info("[Add User Test] Navigating to Admin Page...");
        
        adminPage.clickAdminItem();
        logger.info("[Add User Test] Verifying Admin Page...");
        Assert.assertTrue(adminPage.isUserAddedSuccessfully(), "Failed to navigate to Admin Page");


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
