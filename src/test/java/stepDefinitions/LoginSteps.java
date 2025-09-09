package stepDefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;
import utilities.DriverFactory;
import utilities.ScreenshotUtil;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage();
    private WebDriverWait wait;
    
    @Given("I am on the ThomasCook login page")
    public void i_am_on_the_thomascook_login_page() {
        loginPage.openLoginPage();
    }
    
    @When("I enter login details {string} and send OTP")
    public void i_enter_login_details_and_send_otp(String loginId) {
        loginPage.login(loginId); // same method as before, just parameterized
    }

    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.clickFinalLogin();
        loginPage.handleMultipleSessionAlert();
    }

    
    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid"), 
                          "Expected error not shown");
        ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), "login_error");
    }

    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful");
        ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), "login_success");
    }

}
