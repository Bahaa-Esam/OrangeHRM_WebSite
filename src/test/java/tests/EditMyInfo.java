package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.AuthHelper;
import pages.MyInfoPage;

public class EditMyInfo extends BaseTest {
    private MyInfoPage myInfoPage;
    private AuthHelper authHelper;
    private static final Logger logger = LogManager.getLogger(EditMyInfo.class);

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        logger.info("[Edit My Info Test] Setting up test...");
        super.setUp();
        myInfoPage = new MyInfoPage(driver);
        authHelper = new AuthHelper(driver);
        
        // Perform a valid login using AuthHelper
        logger.info("[Add Candidate Test] Executing a valid login...");
        authHelper.performValidLogin();
    }

    @Test(description = "Verify that a user can successfully edit personal info")
    public void testEditMyInfo() {
        logger.info("[Edit My Info Test] Navigating to My Info Page...");
        myInfoPage.clickTabMyInfoPage();

        logger.info("[Edit My Info Test] Verifying navigation to My Info Page...");
        Assert.assertTrue(myInfoPage.verifyNavigateToMyInfoPage(), "Failed to navigate to My Info Page");

        logger.info("[Edit My Info Test] Editing personal details...");
        myInfoPage.fillFirstNameField("ahhhh");
        myInfoPage.fillMidNameField("A.aaaa");
        myInfoPage.fillLastNameField("Doe");
        myInfoPage.fillEmployeeIdField("12345");
        myInfoPage.fillOtherIdField("67890");
        myInfoPage.fillDriverLicenseNumField("D1234567");
        //myInfoPage.fillLicenseExpiryDateField("2027-12-31");
        myInfoPage.selectNationality("American");
        //myInfoPage.fillDateOfBirthField("1990-05-15");
        myInfoPage.clickSaveButton();

        logger.info("[Edit My Info Test] Changes saved successfully.");
    }
}
