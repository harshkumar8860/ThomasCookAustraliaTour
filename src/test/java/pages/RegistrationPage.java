//package pages;
//
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class RegistrationPage extends BasePage {
//
//	private By loginLogoutToggel = By.id("LoginLogoutToggel"); // TODO: update locator
//	private By FirstRegisterButton = By.className("show_register_form"); // TODO: update locator
//
//	private By titleDropdown = By.id("regTitle"); // dropdown: Mr/Ms
//	private By firstNameField = By.id("registerFName");
//	private By lastNameField = By.id("registerLName");
//	private By emailField = By.id("registerEmailId");
//	private By passwordField = By.id("registerPwd");
//	private By confirmPassword = By.id("registerConfirmPwd");
//	private By mobileField = By.id("registerMobileNo");
//	private By checkBox = By.id("tandc");
//	private By FinalregisterButton = By.id("registerButton");
//	private By successMsg = By.cssSelector(".success");
//	private By errorMsg = By.cssSelector(".error");
//
//	private By LoginText = By.xpath("//span[normalize-space()='Login']");
//	
//
////	public void openRegistrationPage() {
////		driver.get("https://www.thomascook.in/");
////		
////		// You may need to click login/logout toggle -> then switch to Register form
////	}
////
////	public void register(String title, String firstName, String lastName, String email, String password,
////			String mobile) {
//////
////		driver.findElement(loginLogoutToggel).click();
////		driver.findElement(FirstRegisterButton).click();
////
////		driver.findElement(titleDropdown).sendKeys(title);
////		driver.findElement(firstNameField).sendKeys(firstName);
////		driver.findElement(lastNameField).sendKeys(lastName);
////		driver.findElement(emailField).sendKeys(email);
////		driver.findElement(passwordField).sendKeys(password);
////		driver.findElement(confirmPassword).sendKeys(password);
////		driver.findElement(mobileField).sendKeys(mobile);
//////		driver.findElement(checkBox).click();
////
////		driver.findElement(FinalregisterButton).click();
////		try {
////			Thread.sleep(10000);
////		} catch (InterruptedException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////	}
//
//	public void openWebsite() {
//	    driver.get("https://www.thomascook.in/");
//	}
//
//	public void navigateToRegistrationPage() {
//	    driver.findElement(loginLogoutToggel).click();
//	    driver.findElement(FirstRegisterButton).click();
//	}
//
//	public void selectTitle(String title) {
//	    driver.findElement(titleDropdown).sendKeys(title);
//	}
//
//	public void enterFirstName(String firstName) {
//	    driver.findElement(firstNameField).sendKeys(firstName);
//	}
//
//	public void enterLastName(String lastName) {
//	    driver.findElement(lastNameField).sendKeys(lastName);
//	}
//
//	public void enterEmail(String email) {
//	    driver.findElement(emailField).sendKeys(email);
//	}
//
//	public void enterPassword(String password) {
//	    driver.findElement(passwordField).sendKeys(password);
//	}
//
//	public void enterConfirmPassword(String confirmPwd) {
//	    driver.findElement(confirmPassword).sendKeys(confirmPwd);
//	}
//
//	public void enterMobile(String mobile) {
//	    driver.findElement(mobileField).sendKeys(mobile);
//	}
//
//	public void clickRegisterButton() {
//	    driver.findElement(FinalregisterButton).click();
//	}
//
//	public String getErrorMessage() {
//	    return driver.findElement(errorMsg).getText();
//	}
//
//}

//
//package pages;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//
//public class RegistrationPage extends BasePage {
//
//    private By titleDropdown = By.id("title");
//    private By firstNameField = By.id("firstName");
//    private By lastNameField = By.id("lastName");
//    private By emailField = By.id("email");
//    private By passwordField = By.id("password");
//    private By confirmPasswordField = By.id("confirmPassword");
//    private By mobileNumberField = By.id("mobileNumber");
//    private By registerButton = By.id("registerButton");
//
//    public RegistrationPage(WebDriver driver) {
//        super(driver);
//    }
//
//    public void selectTitle(String title) {
//        driver.findElement(titleDropdown).sendKeys(title);
//    }
//
//    public void enterFirstName(String firstName) {
//        driver.findElement(firstNameField).sendKeys(firstName);
//    }
//
//    public void enterLastName(String lastName) {
//        driver.findElement(lastNameField).sendKeys(lastName);
//    }
//
//    public void enterEmail(String email) {
//        driver.findElement(emailField).sendKeys(email);
//    }
//
//    public void enterPassword(String password) {
//        driver.findElement(passwordField).sendKeys(password);
//    }
//
//    public void enterConfirmPassword(String confirmPassword) {
//        driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
//    }
//
//    public void enterMobileNumber(String mobileNumber) {
//        driver.findElement(mobileNumberField).sendKeys(mobileNumber);
//    }
//
//    public void clickRegisterButton() {
//        driver.findElement(registerButton).click();
//    }
//}


package pages;

import org.openqa.selenium.By;

public class RegistrationPage extends BasePage {

    private By loginLogoutToggel = By.id("LoginLogoutToggel");
    private By firstRegisterButton = By.className("show_register_form");

    private By titleDropdown = By.id("regTitle");
    private By firstNameField = By.id("registerFName");
    private By lastNameField = By.id("registerLName");
    private By emailField = By.id("registerEmailId");
    private By passwordField = By.id("registerPwd");
    private By confirmPassword = By.id("registerConfirmPwd");
    private By mobileField = By.id("registerMobileNo");
    private By finalRegisterButton = By.id("registerButton");
    private By errorMsg = By.cssSelector(".error");

    public void openRegistrationPage() {
        driver.get("https://www.thomascook.in/");
    }

    public void clickRegisterForm() {
        driver.findElement(loginLogoutToggel).click();
        driver.findElement(firstRegisterButton).click();
    }

    public void enterTitle(String title) {
        driver.findElement(titleDropdown).sendKeys(title);
    }

    public void enterFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void enterLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void enterConfirmPassword(String confirmPwd) {
        driver.findElement(confirmPassword).sendKeys(confirmPwd);
    }

    public void enterMobile(String mobile) {
        driver.findElement(mobileField).sendKeys(mobile);
    }

    public void clickRegisterButton() {
        driver.findElement(finalRegisterButton).click();
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
}
