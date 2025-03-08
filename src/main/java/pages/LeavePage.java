package pages;

import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LeavePage extends BasePage {
    private static final Logger logger = Logger.getLogger(LeavePage.class.getName());

    public LeavePage(WebDriver driver) {
        super(driver); // تمرير WebDriver إلى BasePage
    }

    private By leavePageBtn = By.xpath("//span[normalize-space()='Leave']");
    private By verifyRedirectedLeavePage = By.xpath("(//h6[normalize-space()='Leave'])[1]");
    private By applyFormBtn = By.xpath("//a[normalize-space()='Apply']");
    private By selectLeaveTypeBtn = By.cssSelector(".oxd-select-text-input");
    private By secondOptionInTypes = By.cssSelector("div[role='option'] span");
    private By secondOptionInDuration = By.cssSelector("div[role='listbox'] div:nth-child(2) span:nth-child(1)");
    private By fmlaTypeBtn = By.xpath("//span[normalize-space()='CAN - FMLA']");
    private By matternityTypeBtn = By.xpath("//span[normalize-space()='CAN - Matternity']");
    private By fromDateField = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]");
    private By durationDropDownBtn = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]");
    private By toDateField = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]");
    private By applyBtn = By.cssSelector("button[type='submit']");
    private By allertFaildMessage = By.cssSelector(".oxd-icon.bi-exclamation-triangle.oxd-toast-icon");
    private By allertSuccesMessage = By.cssSelector(".oxd-text.oxd-text--p.oxd-text--toast-title.oxd-toast-content-text");

    // Methods
    public void clickLeavePageBtn() {
        clickElement(leavePageBtn);
    }
    
    public void clickDurationDropDownBtn() {
    	clickElement(durationDropDownBtn);
    }
    
    public void clicksecondOptionInDuration() {
    	clickElement(secondOptionInDuration);
    }

    public boolean verifyRedirectedLeavePage() {
        boolean success = isElementDisplayed(verifyRedirectedLeavePage);
        logger.info("[LeavePage] redirected Leave Page status: " + success);
        return success;
    }
    
    public boolean verifyLeaveIsApplied() {
    	boolean success = isElementDisplayed(allertSuccesMessage);
    	logger.info("[LeavePage] Verifying Leave Is Applied: " + success);
    	return success;
    }


    public void clickApplyFormBtn() {
        clickElement(applyFormBtn);
    }

    public void clickSelectLeaveTypeBtn() {
        clickElement(selectLeaveTypeBtn);
    }
    
    public void clickSecondOptionInTypes() {
    	clickElement(secondOptionInTypes);
    }

    public void clickFmlaTypeBtn() {
        clickElement(fmlaTypeBtn);
    }

    public void clickMatternityTypeBtn() {
        clickElement(matternityTypeBtn);
    }

    public void typeFromDateField(String fromDate) {
        typeText(fromDateField, fromDate);
    }

    public void typeToDateField(String toDate) {
        typeText(toDateField, toDate);
    }

    public void clickApplyBtn() {
        clickElement(applyBtn);
    }
}
