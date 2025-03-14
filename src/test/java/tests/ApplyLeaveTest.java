package tests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LeavePage;
import pages.LoginPage;

public class ApplyLeaveTest extends BaseTest {
    private LeavePage leavePage; // Instance of LeavePage for leave-related actions
    private LoginPage loginPage; // Instance of LoginPage for user login actions
    private static final Logger logger = Logger.getLogger(ApplyLeaveTest.class.getName());

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        super.setUp(); // Initializes the base test setup
        logger.info("[ApplyLeaveTest] Setting up the test environment...");
        leavePage = new LeavePage(driver); // Initialize the LeavePage
        loginPage = new LoginPage(driver);

        // Perform a valid login
        logger.info("[ApplyLeaveTest] Executing a valid login...");
        loginPage.performValidLogin();
    }

    @Test
    public void testApplyLeave() {
        logger.info("[Apply Leave Test] Navigating to Leave Page...");
        leavePage.clickLeavePageBtn(); // Click on the Leave page button
        Assert.assertTrue(leavePage.verifyRedirectedLeavePage(), "Failed to navigate to Recruitment Page"); // Verify redirection to the Leave page

        leavePage.clickApplyFormBtn(); // Click on the Apply Leave form button
        
        // 🔹 Get today's date
        String fromDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-dd-MM"));
        leavePage.typeFromDateField(fromDate); // Input the start date of leave
        
        // 🔹 Calculate the end date (3 days later)
        String toDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("yyyy-dd-MM"));
        //leavePage.typeToDateField(toDate); // Uncomment if end date input is required
        leavePage.clickSelectLeaveTypeBtn(); // Click to select leave type
        leavePage.clickSecondOptionInTypes(); // Select the second leave type (e.g., FMLA)
        
        logger.info("[ApplyLeaveTest] Applying leave from: " + fromDate + " to: " + toDate + " with type: FMLA.");
        leavePage.clickApplyBtn(); // Click on the Apply button
        
        Assert.assertFalse(leavePage.overLappingError(), "[ApplyLeaveTest] Error!> Overlapping Leave Request(s) Found");
        logger.info("[Apply Leave Test] Error!> Overlapping Leave Request(s) Found");
        
        Assert.assertTrue(leavePage.verifyLeaveIsApplied(), "[ApplyLeaveTest] Leave application verification failed!");
        logger.info("[Apply Leave Test] Leave application submitted successfully.");
        
        
    }
}