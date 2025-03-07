package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.LoginPage;
import java.util.logging.Logger;

public class AddEmployeeTest extends BaseTest {
    private AdminPage adminPage;
    private LoginPage loginPage;
    private static final Logger logger = Logger.getLogger(AddEmployeeTest.class.getName());

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        logger.info("[AdminAddEmployeeTest] Setting up test...");
        adminPage = new AdminPage(driver);
        loginPage = new LoginPage(driver);

        // Perform a valid login
        loginPage.performValidLogin();
    }

    @Test(description = "Verify that an admin can successfully add a new employee")
    public void testAdminCanAddEmployee() {
        logger.info("[AdminAddEmployeeTest] Navigating to Admin Page...");
        adminPage.clickAdminItem();

        logger.info("[AdminAddEmployeeTest] Adding a new employee...");
        adminPage.clickAddButton();
        adminPage.enterAddUsername("loolo");
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
        logger.info("[AdminAddEmployeeTest] Employee added successfully.");
    }
}
