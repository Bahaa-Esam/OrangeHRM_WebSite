package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.logging.Logger;
public class RecruitmentPage extends BasePage {

	public RecruitmentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Identify elements
	private By recruitmentPageTap = 
			By.cssSelector("a[class='oxd-main-menu-item active'] svg");
	private By addButton = By.cssSelector(".oxd-icon.bi-plus.oxd-button-icon");
	private By firstnameField = By.cssSelector("input[placeholder='First Name']");
	private By middlenameField = By.cssSelector("input[placeholder='Middle Name']");
	private By lastnameField = By.cssSelector("input[placeholder='Middle Name']");
	private By vacancyDropDown = By.cssSelector("div[tabindex='0']");
	private By emailField = By.cssSelector("input[class='oxd-input oxd-input--active oxd-input--error']");
	private By numberConField = By.xpath("(//input[@placeholder='Type here'])[2]");
	private By browseButton = By.cssSelector(".oxd-file-button");
	private By keywordsField = By.cssSelector("input[placeholder='Enter comma seperated words...']");
	private By saveButton = By.cssSelector("button[type='submit']");
	
	//Methods
	public void clickTapRecruitmentPage() {
		clickElement(recruitmentPageTap);
	}
	
	public void clickAddButton() {
		clickElement(addButton);
	}
	
	public void fillFirstNameField(String firstname) {
		typeText(firstnameField, firstname);
	}
	
	public void fillMidNameField(String midtname) {
		typeText(middlenameField, midtname);
	}
	
	public void fillLastNameField(String lastname) {
		typeText(lastnameField, lastname);
	}
	
	public void clickvacancyDropDown() {
		clickElement(vacancyDropDown);
	}
	
	
	
	public void clickSaveButton() {
		clickElement(saveButton);
	}
	
}
