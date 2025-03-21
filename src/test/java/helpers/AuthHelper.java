package helpers;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class AuthHelper {
    private WebDriver driver;
    private LoginPage loginPage;

    public AuthHelper(WebDriver driver) {
        this.driver = driver;
        this.loginPage = new LoginPage(driver);
    }

    public void performValidLogin() {
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickLoginButton();
        // Optionally, add verification for successful login here
    }
}
