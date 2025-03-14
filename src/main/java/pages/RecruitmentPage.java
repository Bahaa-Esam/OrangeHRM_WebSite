package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.logging.Logger;

public class RecruitmentPage extends BasePage {

    private static final Logger logger = Logger.getLogger(RecruitmentPage.class.getName());

    public RecruitmentPage(WebDriver driver) {
        super(driver);
        logger.info("RecruitmentPage initialized");
    }
    
    // Identify elements on the Recruitment page
    private By recruitmentPageTap =
            By.xpath("//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name'][normalize-space()='Recruitment']");
    private By addButton = By.cssSelector(".oxd-icon.bi-plus.oxd-button-icon");
    private By firstnameField = By.cssSelector("input[placeholder='First Name']");
    private By middlenameField = By.cssSelector("input[placeholder='Middle Name']");
    private By lastnameField = By.cssSelector("input[placeholder='Last Name']");
    private By vacancyDropDown = By.cssSelector("div[tabindex='0']");
    private By SeniorQALeadVacancy = By.xpath("//span[normalize-space()='Senior QA Lead']");
    private By emailField = By.xpath("//div[3]//div[1]//div[1]//div[1]//div[2]//input[1]");
    private By numberConField = By.xpath("(//input[@placeholder='Type here'])[2]");
    private By uploadFile = By.xpath("//input[@type='file']");
    private By keywordsField = By.cssSelector("input[placeholder='Enter comma seperated words...']");
    private By saveButton = By.cssSelector("button[type='submit']");
    private By checkAddSuccessfully = By.xpath("//p[text()='Successfully Saved']");
    private By CheckNavigatedToPage = By.xpath("(//h6[normalize-space()='Recruitment'])[1]");
    
    // Methods to interact with the Recruitment page
    public void clickTapRecruitmentPage() {
        logger.info("Clicking on Recruitment Page tab");
        clickElement(recruitmentPageTap);
    }
    
    public boolean verifyNavigateToRecruitmentPage() {
        logger.info("Checking Navigated To RecruitmentPage successfully");
        boolean isSuccess = isElementDisplayed(CheckNavigatedToPage);
        logger.info("Navigated To RecruitmentPage successfully: " + isSuccess);
        return isSuccess;
    }
    
    public void clickAddButton() {
        logger.info("Clicking on Add button");
        clickElement(addButton);
    }
    
    public void fillFirstNameField(String firstname) {
        logger.info("Filling in First Name: " + firstname);
        typeText(firstnameField, firstname);
    }
    
    public void fillMidNameField(String middlename) {
        logger.info("Filling in Middle Name: " + middlename);
        typeText(middlenameField, middlename);
    }
    
    public void fillLastNameField(String lastname) {
        logger.info("Filling in Last Name: " + lastname);
        typeText(lastnameField, lastname);
    }
    
    public void clickVacancyDropDown() {
        logger.info("Clicking on Vacancy dropdown");
        clickElement(vacancyDropDown);
    }
    
    public void clickSeniorQALeadVacancy() {
        logger.info("Selecting Senior QA Lead vacancy");
        clickElement(SeniorQALeadVacancy);
    }
    
    public void fillEmailField(String email) {
        logger.info("Filling in Email: " + email);
        typeText(emailField, email);
    }
    
    public void fillContactNumber(String contactNumber) {
        logger.info("Filling in Contact Number: " + contactNumber);
        typeText(numberConField, contactNumber);
    }
    
    public void clickFileBrowseBtn(String fileName) {
        logger.info("Uploading file: " + fileName);
        uploadFile(uploadFile, fileName);
    }
    
    public void typeKeywords(String keywords) {
        logger.info("Filling in Keywords: " + keywords);
        typeText(keywordsField, keywords);
    }
    
    public void clickSaveButton() {
        logger.info("Clicking Save button");
        clickElement(saveButton);
    }
    
    public boolean isCandidateAddedSuccessfully() {
        logger.info("Checking if candidate was added successfully");
        boolean isSuccess = isElementDisplayed(checkAddSuccessfully);
        logger.info("Candidate added successfully: " + isSuccess);
        return isSuccess;
    }
}