package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.DriverFactory;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
    }

    // universal Login/Logout toggle locator
    private By loginLogoutToggel = By.id("LoginLogoutToggel");

    // method to check if user is logged in (shared by Login & Registration)
    public boolean isUserLoggedIn() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            String text = wait.until(
                ExpectedConditions.visibilityOfElementLocated(loginLogoutToggel)
            ).getText().trim();

            return !text.equalsIgnoreCase("Login"); // if not "Login", then logged in
        } catch (Exception e) {
            return false;
        }
    }
}
