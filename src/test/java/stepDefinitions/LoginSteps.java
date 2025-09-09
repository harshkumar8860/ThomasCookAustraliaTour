package stepDefinitions;

import io.cucumber.java.en.*;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.LoginPage;
import utilities.DriverFactory;
//import utilities.ExcelUtil;
import utilities.ScreenshotUtil;

public class LoginSteps {
    private LoginPage loginPage = new LoginPage();
    private WebDriverWait wait;
    

//    @When("user navigates to login page")
//    public void user_navigates_to_login_page() {
//        loginPage.openLoginPage();
//    }
    @Given("I am on the ThomasCook login page")
    public void i_am_on_the_thomascook_login_page() {
        loginPage.openLoginPage();
    }
    
    @When("I enter login details {string} and send OTP")
    public void i_enter_login_details_and_send_otp(String loginId) {
        loginPage.login(loginId); // same method as before, just parameterized
    }

//    @When("user enters valid email and otp")
//    public void user_enters_valid_username_and_password() {
////        loginPage.login("biwin91898@mirarmax.com");
//    	
//     // Load Login Data
//        ExcelUtil.setExcelFile("src/test/resources/testdata/TestData.xlsx", "Sheet1");
//        // Example: Pick row 1
//        String email = ExcelUtil.getCellData(1, 3);
////        String password = ExcelUtil.getCellData(1, 1);
//        loginPage.login(email);
//    }
    
    @When("I click on the login button")
    public void i_click_on_the_login_button() {
        // If you want a separate method for clarity
        // Or just leave inside login() if that already clicks SecondLogin
        // To keep flow same, add a small method in LoginPage:
        loginPage.clickFinalLogin();
//        wait.until(driver -> loginPage.isLoginSuccessful());

        loginPage.handleMultipleSessionAlert();
    }

//    @When("user enters invalid email")
//    public void user_enters_valid_username_and_invalid_password() {
////        loginPage.login("biwin91898@mirarmax.com");
//        ExcelUtil.setExcelFile("src/test/resources/testdata/TestData.xlsx", "Sheet1");
//        // Example: Pick row 1
//        String email = ExcelUtil.getCellData(2, 3);
////        String password = ExcelUtil.getCellData(1, 1);
//        loginPage.login(email);
//    }
    
    @Then("I should see an error message")
    public void i_should_see_an_error_message() {
        Assert.assertTrue(loginPage.getErrorMessage().contains("Invalid"), 
                          "Expected error not shown");
        ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), "login_error");
    }

//    @Then("user should be logged in successfully")
//    public void user_should_be_logged_in_successfully() {
//        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful");
//        ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), "login_success");
//    }
    @Then("I should be logged in successfully")
    public void i_should_be_logged_in_successfully() {
        Assert.assertTrue(loginPage.isLoginSuccessful(), "Login was not successful");
        ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), "login_success");
    }

//    @Then("error message {string} should be displayed")
//    public void error_message_should_be_displayed(String msg) {
//        Assert.assertTrue(loginPage.getErrorMessage().contains(msg), "Expected error not shown");
//        ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), "login_error");
//    }
}
