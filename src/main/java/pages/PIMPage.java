package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.logging.Logger;

public class PIMPage extends BasePage {
    private static final Logger logger = Logger.getLogger(PIMPage.class.getName());

    public PIMPage(WebDriver driver) {
        super(driver);
    }

    // ✅ Define Elements Using By Selectors
    private By pimBtnPage = By.xpath("//span[normalize-space()='PIM']");
    private By verifyIsPimPage = By.cssSelector(".oxd-text--h6");
    private By addEmployeeBtn = By.cssSelector(".oxd-topbar-body-nav-tab:nth-child(3)");
    private By firstnameField = By.cssSelector("input[name='firstName']");
    private By verifyFirstnamed = By.cssSelector(".orangehrm-firstname");
    private By middlenameField = By.cssSelector("input[name='middleName']");
    private By lastnameField = By.cssSelector("input[name='lastName']");
    private By loginDetailsSwitch = By.cssSelector(".oxd-switch-input");
    private By usernameField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[3]");
    private By passwordField = By.xpath("(//input[@type='password'])[1]");
    private By confirmPasswordField = By.xpath("(//input[@type='password'])[2]");
    private By enableStatusRBtn = By.xpath("//label[normalize-space()='Enabled']");
    private By disableStatusRBtn = By.xpath("//label[normalize-space()='Disabled']");
    private By saveBtn = By.cssSelector(".oxd-button--secondary");
    private By cancelBtn = By.xpath("//button[normalize-space()='Cancel']");
    private By succesfullyAddedMessage = By.cssSelector(".bi-check2");
    private By employeeIdFieldChecker = By.cssSelector(".oxd-grid-3:nth-child(1) > .oxd-grid-item:nth-child(1) .oxd-input");
    private final By usernameIcon = By.cssSelector(".oxd-userdropdown-tab");
    private final By logoutButton = By.xpath("//a[text()='Logout']");
    
    // ✅ Methods
    public void verifyEmployeeId() {
        isElementDisplayed(employeeIdFieldChecker);
    }

    public String getFirstnameEmployee() {
        return getElementText(verifyFirstnamed);
    }

    public void clickPIMPageBtn() {
        clickElement(pimBtnPage);
    }

    public boolean verifyRedirectedPIMPage() {
        boolean success = isElementDisplayed(verifyIsPimPage);
        logger.info("[PIMPage] Redirected to PIM Page: " + success);
        return success;
    }

    public void clickAddEmployeeBtn() {
        clickElement(addEmployeeBtn);
    }

    public void typeFirstname(String firstname) {
        typeText(firstnameField, firstname);
    }

    public void typeMiddlename(String middlename) {
        typeText(middlenameField, middlename);
    }

    public void typeLastname(String lastname) {
        typeText(lastnameField, lastname);
    }

    public void clickLoginDetailsSwitch() {
        clickElement(loginDetailsSwitch);
    }

    public void typeUsername(String username) {
        typeText(usernameField, username);
    }

    public void typePassword(String password) {
        typeText(passwordField, password);
    }

    public void typeConfirmPassword(String confirmPassword) {
        typeText(confirmPasswordField, confirmPassword);
    }

    public void clickEnableStatusBtn() {
        clickElement(enableStatusRBtn);
    }

    public void clickDisableStatusBtn() {
        clickElement(disableStatusRBtn);
    }

    public void clickSaveBtn() {
        clickElement(saveBtn);
    }

    public boolean isEmployeeAddedSuccessfully() {
        boolean success = isElementDisplayed(succesfullyAddedMessage);
        logger.info("[PIMPage] Employee successfully added: " + success);
        return success;
    }

    public void clickCancelBtn() {
        clickElement(cancelBtn);
    }

    // Click the username
    public void clickUsernameIcon() {
        clickElement(usernameIcon);
    }

    // Click logout button
    public void clickLogoutBtn() {
        clickElement(logoutButton);
    }
}
