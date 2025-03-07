package tests;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LeavePage;
import pages.LoginPage;

public class ApplyLeaveTest extends BaseTest {
    private LeavePage leavePage;
    private LoginPage loginPage;
    private static final Logger logger = Logger.getLogger(ApplyLeaveTest.class.getName());

    @BeforeMethod
    public void setUp() {
        super.setUp();
        logger.info("[ApplyLeaveTest] Setting up test...");
        loginPage = new LoginPage(driver);
        leavePage = new LeavePage(driver);

        // Perform a valid login
        loginPage.performValidLogin();
    }

    @Test
    public void testapplyLeaveTest() {
        logger.info("[ApplyLeaveTest] Navigating to Leave Page...");
        leavePage.clickleavePageBtn();
        leavePage.verifyRedirectedLeavePage();
        leavePage.clickApplyFormBtn();
        leavePage.clickSelectLeaveTypeBtn();
        leavePage.clickFmlaTypeBtn(); // FMLA Type Leave

        // 🔹 Get today's date
        String fromDate = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        leavePage.typeFromDateField(fromDate);
        
        // 🔹 Get toDate (3 days later)
        String toDate = LocalDate.now().plusDays(3).format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        leavePage.typeToDateField(toDate);
        
        logger.info("[ApplyLeaveTest] Applied leave from: Type Dates....");
        
        leavePage.clickApplyBtn();
    }
}
