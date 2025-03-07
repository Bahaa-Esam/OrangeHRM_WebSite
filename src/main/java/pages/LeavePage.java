package pages;

import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LeavePage extends BasePage {
    private static final Logger logger = Logger.getLogger(LeavePage.class.getName());

    public LeavePage(WebDriver driver) {
        super(driver); // تمرير WebDriver إلى BasePage
    }

    private By leavePageBtn = By.xpath("//span[normalize-space()='Leave']");
    private By verifyRedirectedLeavePage = By.xpath("(//h6[normalize-space()='Leave'])[1]");
    private By applyFormBtn = By.xpath("//a[normalize-space()='Apply']");
    private By selectLeaveTypeBtn = By.cssSelector(".oxd-select-text-input");
    private By fmlaTypeBtn = By.xpath("//span[normalize-space()='CAN - FMLA']");
    private By matternityTypeBtn = By.xpath("//span[normalize-space()='CAN - Matternity']");
    private By fromDateField = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]");
    private By toDateField = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]");
    private By applyBtn = By.xpath("//button[type='submit']");

    // Methods
    public void clickleavePageBtn() {
        clickElement(leavePageBtn);
    }

    public boolean verifyRedirectedLeavePage() {
        boolean success = isElementDisplayed(verifyRedirectedLeavePage);
        logger.info("[LeavePage] redirected Leave Page status: " + success);
        return success;
    }

    public void clickApplyFormBtn() {
        clickElement(applyFormBtn);
    }

    public void clickSelectLeaveTypeBtn() {
        clickElement(selectLeaveTypeBtn);
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
