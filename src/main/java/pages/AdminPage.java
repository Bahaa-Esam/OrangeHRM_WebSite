package pages;

import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage extends BasePage {
    private static final Logger logger = Logger.getLogger(RecruitmentPage.class.getName());


    public AdminPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Locators for Admin Page elements
    private By adminItem = By.cssSelector(".oxd-main-menu-item-wrapper:nth-child(1) .oxd-text");
    private By addBtn = By.className("bi-plus");
    private By addUsername = By.cssSelector(".oxd-grid-item:nth-child(4) .oxd-input");
    private By addEmployeeName = By.cssSelector(".oxd-autocomplete-text-input > input");
    private By passwordField = By.cssSelector(".user-password-cell .oxd-input");
    private By confirmPassword = By.cssSelector(".oxd-grid-item:nth-child(2) .oxd-input");
    private By saveBtn = By.cssSelector(".oxd-button--secondary");
    private By cancelBtn = By.cssSelector(".oxd-button--ghost");
    private By roleOptions = By.cssSelector(".oxd-select-text--active > .oxd-select-text-input");
    private By adminRoleOption = By.cssSelector(".oxd-select-option:nth-child(2) > span");
    private By essRoleOption = By.cssSelector(".oxd-select-option:nth-child(3) > span");
    private By enableStatusOption = By.cssSelector(".oxd-select-option:nth-child(2) > span");
    private By statusOptions = By.cssSelector(".oxd-grid-item:nth-child(3) .oxd-select-text");
    private By disableStatusOption = By.cssSelector(".oxd-select-option:nth-child(2)");
    private By secondOptionEmployeeName = By.cssSelector(".oxd-autocomplete-option:nth-child(2)");
    private By successMessage = By.xpath("//p[text()='Successfully Saved']");

    // Actions on Admin Page elements
    public void clickAdminItem() {
        clickElement(adminItem);
    }

    public void clickAddButton() {
        clickElement(addBtn);
    }

    public void enterAddUsername(String username) {
        typeText(addUsername, username);
    }

    public void enterAddEmployeeName(String employeeName) {
       typeText(addEmployeeName, employeeName);
    }

    public void enterPassword(String password) {
        typeText(passwordField, password);
    }

    public void enterConfirmPassword(String confirmPasswordText) {
        typeText(confirmPassword, confirmPasswordText);
    }

    public void clickSaveButton() {
        clickElement(saveBtn);
    }

    public void clickCancelButton() {
        clickElement(cancelBtn);
    }

    public void openStatusOptions() {
        clickElement(statusOptions);
    }

    public void selectEnableStatusOption() {
        clickElement(enableStatusOption);
    }

    public void selectDisableStatusOption() {
        clickElement(disableStatusOption);
    }

    public void openAdminRoles() {
        clickElement(roleOptions);
    }

    public void selectAdminRole() {
        clickElement(adminRoleOption);
    }

    public void selectEssRoleOption() {
        clickElement(essRoleOption);
    }

    public void selectSecondOptionEmployeeName() {
        clickElement(secondOptionEmployeeName);
    }

    // Checks if the user was added successfully
    public boolean isUserAddedSuccessfully() {
        logger.info("Checking if User was added successfully");
        boolean isSuccess = isElementDisplayed(successMessage);
        logger.info("User added successfully: " + isSuccess);
        return isSuccess;
    }
}
