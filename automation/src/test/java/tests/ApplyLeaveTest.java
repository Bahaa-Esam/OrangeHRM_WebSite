package tests;

import helpers.AuthHelper;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PIMPage;

import java.util.logging.Logger;

public class ApplyLeaveTest extends BaseTest {
    private PIMPage pimPage;
    private AuthHelper authHelper;
    private static final Logger logger = Logger.getLogger(ApplyLeaveTest.class.getName());

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        super.setUp();
        logger.info("[Add Employee Test] Setting up test...");
        pimPage = new PIMPage(driver);
        authHelper = new AuthHelper(driver);

        // Perform a valid login using AuthHelper
        authHelper.performValidLogin();
    }

    @Test
    public void testAddEmployeeFromPIMPage() {
        logger.info("[AddEmployeeTest] Navigating to PIM Page...");
        pimPage.clickPIMPageBtn();

        // Validate PIM Page
        logger.info("[AddEmployeeTest] Verifying PIM Page...");
        Assert.assertTrue(pimPage.verifyRedirectedPIMPage(), "Failed to navigate to PIM Page");

        // Add new employee
        logger.info("[AddEmployeeTest] Adding a new employee...");
        pimPage.clickAddEmployeeBtn();
        pimPage.typeFirstname("AutomationUser");
        pimPage.typeMiddlename("Selenium");
        pimPage.typeLastname("TestNG");
        pimPage.clickLoginDetailsSwitch();
        pimPage.typeUsername("illaoi9i");
        pimPage.typePassword("autoUserPass321");
        pimPage.typeConfirmPassword("autoUserPass321");
        pimPage.clickDisableStatusBtn();
        pimPage.clickSaveBtn();

        // Verify success message
        Assert.assertTrue(pimPage.isEmployeeAddedSuccessfully(), "Employee not added successfully!");

        // Verify that the employee's name is saved correctly
        logger.info("[AddEmployeeTest] Verifying employee details...");
        Assert.assertEquals(pimPage.getFirstnameEmployee(), "AutomationUser", "First name does not match");

        // Log out
        logger.info("[AddEmployeeTest] Logging out...");
        pimPage.clickUsernameIcon();
        pimPage.clickLogoutBtn();
    }
}
