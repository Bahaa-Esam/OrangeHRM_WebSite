package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AdminPage {
    private BasePage elementUtil;

    public AdminPage(WebDriver driver) {
        this.elementUtil = new BasePage(driver);
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
    private By successMessage = By.cssSelector(".oxd-text--toast-title");

    // Actions on Admin Page elements
    public void clickAdminItem() {
        elementUtil.clickElement(adminItem);
    }

    public void clickAddButton() {
        elementUtil.clickElement(addBtn);
    }

    public void enterAddUsername(String username) {
        elementUtil.typeText(addUsername, username);
    }

    public void enterAddEmployeeName(String employeeName) {
        elementUtil.typeText(addEmployeeName, employeeName);
    }

    public void enterPassword(String password) {
        elementUtil.typeText(passwordField, password);
    }

    public void enterConfirmPassword(String confirmPasswordText) {
        elementUtil.typeText(confirmPassword, confirmPasswordText);
    }

    public void clickSaveButton() {
        elementUtil.clickElement(saveBtn);
    }

    public void clickCancelButton() {
        elementUtil.clickElement(cancelBtn);
    }

    public void openStatusOptions() {
        elementUtil.clickElement(statusOptions);
    }

    public void selectEnableStatusOption() {
        elementUtil.clickElement(enableStatusOption);
    }

    public void selectDisableStatusOption() {
        elementUtil.clickElement(disableStatusOption);
    }

    public void openAdminRoles() {
        elementUtil.clickElement(roleOptions);
    }

    public void selectAdminRole() {
        elementUtil.clickElement(adminRoleOption);
    }

    public void selectEssRoleOption() {
        elementUtil.clickElement(essRoleOption);
    }

    public void selectSecondOptionEmployeeName() {
        elementUtil.clickElement(secondOptionEmployeeName);
    }

    // Checks if the user was added successfully
    public boolean isUserAddedSuccessfully() {
        return elementUtil.isElementDisplayed(successMessage);
    }
}
