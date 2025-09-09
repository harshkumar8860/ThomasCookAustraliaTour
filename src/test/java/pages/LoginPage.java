package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

	private By loginLogoutToggel = By.id("LoginLogoutToggel"); // TODO: update locator
	private By FirstLogin = By.id("mainLogIn"); // TODO: update locator
	private By EmailPlaceHolder = By.id("loginId"); // TODO: update locator
	private By SendOTP = By.id("sendOTP"); // TODO: update locator
	private By EnterOTP = By.id("loginOTP"); // TODO: update locator
	private By SecondLogin = By.id("loginButton"); // TODO: update locator
	private By errorMsg = By.cssSelector(".error"); // TODO: update locator
	private WebDriverWait wait;

	public void openLoginPage() {
		driver.get("https://www.thomascook.in/");
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // default 20s wait
	}

	public void login(String email) {
		wait.until(ExpectedConditions.elementToBeClickable(loginLogoutToggel)).click();
		wait.until(ExpectedConditions.elementToBeClickable(FirstLogin)).click();

		wait.until(ExpectedConditions.elementToBeClickable(EmailPlaceHolder)).sendKeys(email);
		wait.until(ExpectedConditions.elementToBeClickable(SendOTP)).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(EnterOTP)).click();

		try {
			Thread.sleep(40000); // TODO: replace with explicit wait later
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void clickFinalLogin() {
		driver.findElement(SecondLogin).click();
		try {
			Thread.sleep(20000); // TODO: replace with explicit wait later
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public boolean isLoginSuccessful() {
		try {
			return new WebDriverWait(driver, Duration.ofSeconds(30)).until(d -> {
				String text = driver.findElement(loginLogoutToggel).getText().trim();
				return !text.equalsIgnoreCase("Login");
			});
		} catch (Exception e) {
			return false;
		}
	}

	public String getErrorMessage() {
		return driver.findElement(errorMsg).getText();
	}

	public void handleMultipleSessionAlert() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			String alertText = alert.getText();
			System.out.println("Alert appeared: " + alertText);

			// Accept the alert (logout other sessions and continue)
			alert.accept();

			// OR use dismiss() if you want to continue without logout
			// alert.dismiss();

		} catch (Exception e) {
			System.out.println("No alert appeared.");
		}
	}

}
