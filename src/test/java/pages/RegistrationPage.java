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
