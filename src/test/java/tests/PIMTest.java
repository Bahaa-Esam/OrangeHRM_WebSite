package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.util.logging.Logger;
import pages.PIMPage;

public class PIMTest extends BaseTest {
    private PIMPage pimPage;
    private LoginPage loginPage;
    private static final Logger logger = Logger.getLogger(PIMTest.class.getName());

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        super.setUp();
        logger.info("[Add Employee Test] Setting up test...");
        pimPage = new PIMPage(driver);
        loginPage = new LoginPage(driver);

        // Perform a valid login
        loginPage.performValidLogin();
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
        pimPage.typeUsername("illao567ii");
        pimPage.clickEnableStatusBtn();
        pimPage.typePassword("autoUserPass321");
        pimPage.typeConfirmPassword("autoUserPass321");
        pimPage.clickSaveBtn();

        // Verify success message
        Assert.assertTrue(pimPage.isEmployeeAddedSuccessfully(), "Employee not added successfully!");

        // Verify that the employee's name is saved correctly
        logger.info("[AddEmployeeTest] Verifying employee details...");
        Assert.assertEquals(pimPage.getFirstnameEmployee(), "AutomationUser", "First name does not match");

        // Navigate to Employee List
        logger.info("[AddEmployeeTest] Loging Out...");
        pimPage.clickUsernameIcon();
        pimPage.clickLogoutBtn();
    }
}
