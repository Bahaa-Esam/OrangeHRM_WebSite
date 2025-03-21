package pages;

import java.util.logging.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyInfoPage extends BasePage {
    private static final Logger logger = Logger.getLogger(MyInfoPage.class.getName());

	public MyInfoPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
        logger.info("MyInfoPage initialized");

	}

	//Methods
	 By myInfoPageBtn = By.xpath("//span[normalize-space()='My Info']"); 
	 By verifNavigateToInfoPage = By.xpath("//h6[normalize-space()='Personal Details']"); 
	 By firstNameField = By.cssSelector(".orangehrm-firstname"); 
	 By middNameField = By.cssSelector(".orangehrm-middlename"); 
	 By lastNameField = By.cssSelector(".orangehrm-lastname"); 
	 By employeeIdField = By.xpath("(//input[@class='oxd-input oxd-input--active'])[2]"); 
	 By otherIdField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[2]/div/div[2]/input"); 
	 By driverLicenseNumField = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/input"); 
	 By licenseExpiryDateField = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[1]"); 
	 By nationalityDropDown = By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]");  
	 By countrySelector = By.xpath("//span[normalize-space()='Algerian']"); 
	 By maritalStatusDropDown = 
			 By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//div[2]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]"); 
	 By dateBirthField = By.xpath("(//input[@placeholder='yyyy-dd-mm'])[2]");
	 By saveBtnPersonalDet = By.xpath("//button[@type=\"submit\"][1]");
	 
	 //methods
	 
	    public void clickTabMyInfoPage() {
	        logger.info("Clicking on My Info Page tab");
	        clickElement(myInfoPageBtn);
	    }

	    public boolean verifyNavigateToMyInfoPage() {
	        logger.info("Checking navigation to My Info Page");
	        boolean isSuccess = isElementDisplayed(verifNavigateToInfoPage);
	        logger.info("Navigated to My Info Page successfully: " + isSuccess);
	        return isSuccess;
	    }

	    public void fillFirstNameField(String firstName) {
	        logger.info("Filling in First Name: " + firstName);
	        typeText(firstNameField, firstName);
	    }

	    public void fillMidNameField(String middleName) {
	        logger.info("Filling in Middle Name: " + middleName);
	        typeText(middNameField, middleName);
	    }

	    public void fillLastNameField(String lastName) {
	        logger.info("Filling in Last Name: " + lastName);
	        typeText(lastNameField, lastName);
	    }

	    public void fillEmployeeIdField(String employeeId) {
	        logger.info("Filling in Employee ID: " + employeeId);
	        typeText(employeeIdField, employeeId);
	    }

	    public void fillOtherIdField(String otherId) {
	        logger.info("Filling in Other ID: " + otherId);
	        typeText(otherIdField, otherId);
	    }

	    public void fillDriverLicenseNumField(String driverLicenseNum) {
	        logger.info("Filling in Driver License Number: " + driverLicenseNum);
	        typeText(driverLicenseNumField, driverLicenseNum);
	    }

	    public void fillLicenseExpiryDateField(String licenseExpiryDate) {
	        logger.info("Filling in License Expiry Date: " + licenseExpiryDate);
	        typeText(licenseExpiryDateField, licenseExpiryDate);
	    }
	    
	    public void selectNationality(String nationality) {
	        logger.info("Selecting nationality: " + nationality);
	        clickElement(nationalityDropDown);
	        By countrySelector = By.xpath("//span[normalize-space()='" + nationality + "']");
	        clickElement(countrySelector);
	    }

	    public void selectMaritalStatus(String maritalStatus) {
	        logger.info("Selecting marital status: " + maritalStatus);
	        clickElement(maritalStatusDropDown);
	        By maritalStatusSelector = By.xpath("//span[normalize-space()='" + maritalStatus + "']");
	        clickElement(maritalStatusSelector);
	    }

	    public void fillDateOfBirthField(String dateOfBirth) {
	        logger.info("Filling in Date of Birth: " + dateOfBirth);
	        typeText(dateBirthField, dateOfBirth);
	    }

	    public void clickSaveButton() {
	        logger.info("Clicking Save button");
	        clickElement(saveBtnPersonalDet);
	    }
	    
	    
	    
	 
	 
	 
}
