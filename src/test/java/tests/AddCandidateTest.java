package tests;

import java.util.logging.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import helpers.AuthHelper;
import pages.RecruitmentPage;

public class AddCandidateTest extends BaseTest {
    private RecruitmentPage recPage;
    private AuthHelper authHelper;
    private static final Logger logger = Logger.getLogger(AddCandidateTest.class.getName());

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        super.setUp(); // Initializes the base test setup
        logger.info("[Add Candidate Test] Setting up test...");
        recPage = new RecruitmentPage(driver);
        authHelper = new AuthHelper(driver);

        // Perform a valid login using AuthHelper
        logger.info("[Add Candidate Test] Executing a valid login...");
        authHelper.performValidLogin();
    }

    @Test
    public void addCandidate() {
        logger.info("[Add Candidate Test] Navigating to Recruitment Page...");
        recPage.clickTapRecruitmentPage();
        Assert.assertTrue(recPage.verifyNavigateToRecruitmentPage(), "Failed to navigate to Recruitment Page");

        recPage.clickAddButton();
        recPage.fillFirstNameField("Adel");
        recPage.fillMidNameField("Shakal");
        recPage.fillLastNameField("Asknrany");
        recPage.clickVacancyDropDown();
        recPage.clickSeniorQALeadVacancy();
        recPage.fillEmailField("automationUser@Java.com");
        recPage.fillContactNumber("01101000011101");
        recPage.clickFileBrowseBtn("Test_case.pdf");
        recPage.typeKeywords("Selenium");
        recPage.clickSaveButton();

        Assert.assertTrue(recPage.isCandidateAddedSuccessfully(), "Expected the success message to be displayed, but it was not.");
        logger.info("Add Candidate test completed successfully");
    }
}
