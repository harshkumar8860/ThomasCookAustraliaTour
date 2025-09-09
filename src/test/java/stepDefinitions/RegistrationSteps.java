//package stepDefinitions;
//
//import pages.LoginPage;
//import io.cucumber.java.en.*;
//import org.testng.Assert;
//import pages.RegistrationPage;
//import utilities.DriverFactory;
//import utilities.ScreenshotUtil;
//import io.cucumber.java.en.When;
//import pages.RegistrationPage;
//import utilities.ExcelUtil;
//import utilities.ScenarioContext;
//
//public class RegistrationSteps {
//    private RegistrationPage regPage = new RegistrationPage();
//    private LoginPage loginPage = new LoginPage();
//
////    @When("user navigates to registration page")
////    public void user_navigates_to_registration_page() {
////        regPage.openRegistrationPage();
////    }
////
//////    @When("user enters valid registration details")
//////    public void user_enters_valid_registration_details() {
//////        // Updated to include all required fields
//////        regPage.register(
//////            "Mr",               // title
//////            "def",             // firstName
//////            "ghi",              // lastName
//////            "biwin91898@mirarmax.com", // email
//////            "biwin91898",        // password
////////            "Passw0rd!",        // confirmPassword
//////            "9824394355"        // mobile
//////        );
//////    }'
////    
////    @When("user enters an email or number that is already registered")
////    public void user_enters_an_email_that_is_already_registered() {
////    	// Load Excel file
////    	ExcelUtil.setExcelFile("src/test/resources/testdata/TestData.xlsx", "Sheet1");
////    	
////    	// Example: pick first row of data (row 1 because row 0 is header)
////    	String title = ExcelUtil.getCellData(1, 0);
////    	String firstName = ExcelUtil.getCellData(1, 1);
////    	String lastName = ExcelUtil.getCellData(1, 2);
////    	String email = ExcelUtil.getCellData(1, 3);
////    	String mobile = ExcelUtil.getCellData(1, 4);
////    	String password = ExcelUtil.getCellData(1, 5);
////    	
////    	// Call page method
////    	regPage.register(title, firstName, lastName, email, password, mobile);
////    }
////
////    @When("user enters valid username, number and password")
////    public void user_enters_valid_registration_details() {
////    	// Load Excel file
////    	ExcelUtil.setExcelFile("src/test/resources/testdata/TestData.xlsx", "Sheet1");
////    	
////    	// Example: pick first row of data (row 1 because row 0 is header)
////    	String title = ExcelUtil.getCellData(2, 0);
////    	String firstName = ExcelUtil.getCellData(2, 1);
////    	String lastName = ExcelUtil.getCellData(2, 2);
////    	String email = ExcelUtil.getCellData(2, 3);
////    	String mobile = ExcelUtil.getCellData(2, 4);
////    	String password = ExcelUtil.getCellData(2, 5);
////    	
////    	// Call page method
////    	regPage.register(title, firstName, lastName, email, password, mobile);
////    }
////    
////
//////    @When("user enters an email that is already registered")
//////    public void user_enters_an_email_that_is_already_registered() {
//////        // Updated to include all required fields
//////        regPage.register(
//////            "Master",                   // title
//////            "Harsh",                 // firstName
//////            "Kumar",                  // lastName
//////            "harshkumar8860@gmail.com", // email
//////            "Project@09",            // password
////////            "Passw0rd!",            // confirmPassword
//////            "8882124449"            // mobile
//////        );
//////    }
////
////    @Then("account should be created successfully")
////    public void account_should_be_created_successfully() {
////        Assert.assertTrue(loginPage.isLoginSuccessful(), "Registration was not successful");
////        ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), "registration_success");
////    }
////    
////    @Then("{string} should be displayed")
////    public void error_message_should_be_displayed(String expectedMsg) {
////        String actual = regPage.getErrorMessage();
////        Assert.assertTrue(actual.contains(expectedMsg), "Expected error not shown. Actual: " + actual);
////        ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), "registration_error");
////    }
//    
//    @Given("I open the Thomas Cook website")
//    public void i_open_the_thomas_cook_website() {
//        regPage.openWebsite();
//    }
//
//    @And("I navigate to the registration page")
//    public void i_navigate_to_the_registration_page() {
//        // Click Login/Logout toggle + Register button
//        regPage.navigateToRegistrationPage();
//    }
//
//    @When("I select title {string}")
//    public void i_select_title(String title) {
//        regPage.selectTitle(title);
//    }
//
//    @When("I enter first name {string}")
//    public void i_enter_first_name(String firstName) {
//        regPage.enterFirstName(firstName);
//    }
//
//    @When("I enter last name {string}")
//    public void i_enter_last_name(String lastName) {
//        regPage.enterLastName(lastName);
//    }
//
//    @When("I enter email {string}")
//    public void i_enter_email(String email) {
//        regPage.enterEmail(email);
//    }
//
//    @When("I enter password {string}")
//    public void i_enter_password(String password) {
//        regPage.enterPassword(password);
//    }
//
//    @When("I enter confirm password {string}")
//    public void i_enter_confirm_password(String confirmPwd) {
//        regPage.enterConfirmPassword(confirmPwd);
//    }
//
//    @When("I enter mobile number {string}")
//    public void i_enter_mobile_number(String mobile) {
//        regPage.enterMobile(mobile);
//    }
//
//    @And("I click on Register button")
//    public void i_click_on_register_button() {
//        regPage.clickRegisterButton();
//    }
//
//    @Then("I should see error messages for invalid inputs")
//    public void i_should_see_error_messages_for_invalid_inputs() {
//        String error = regPage.getErrorMessage();
//        Assert.assertTrue(error.contains("Email Id is already registered") 
//                       || error.contains("Invalid"), 
//                       "Unexpected error message: " + error);
//    }
//
//    @Then("I should be redirected to the home page without error")
//    public void i_should_be_redirected_to_home_page_without_error() {
//        Assert.assertTrue(loginPage.isLoginSuccessful(), "Registration failed");
//    }
//    
////    @Then("I should see error messages for invalid inputs")
////    public void i_should_see_error_messages_for_invalid_inputs() {
////        String error = regPage.getErrorMessage();
////        Assert.assertTrue(error.length() > 0, "Expected error but none found");
////    }
////
////    @Then("I should be redirected to the home page without error")
////    public void i_should_be_redirected_to_home_page() {
////        Assert.assertTrue(loginPage.isLoginSuccessful(), "Registration failed unexpectedly");
////    }
//
//}


package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.RegistrationPage;
import utilities.DriverFactory;
import utilities.ScreenshotUtil;

public class RegistrationSteps {

    private RegistrationPage regPage = new RegistrationPage();

    @Given("I open the Thomas Cook website")
    public void i_open_the_thomas_cook_website() {
        regPage.openRegistrationPage();
    }

    @And("I navigate to the registration page")
    public void i_navigate_to_the_registration_page() {
        regPage.clickRegisterForm();
    }

    @When("I select title {string}")
    public void i_select_title(String title) {
        regPage.enterTitle(title);
    }

    @And("I enter first name {string}")
    public void i_enter_first_name(String firstName) {
        regPage.enterFirstName(firstName);
    }

    @And("I enter last name {string}")
    public void i_enter_last_name(String lastName) {
        regPage.enterLastName(lastName);
    }

    @And("I enter email {string}")
    public void i_enter_email(String email) {
        regPage.enterEmail(email);
    }

    @And("I enter password {string}")
    public void i_enter_password(String password) {
        regPage.enterPassword(password);
    }

    @And("I enter confirm password {string}")
    public void i_enter_confirm_password(String confirmPwd) {
        regPage.enterConfirmPassword(confirmPwd);
    }

    @And("I enter mobile number {string}")
    public void i_enter_mobile_number(String mobile) {
        regPage.enterMobile(mobile);
    }

    @And("I click on Register button")
    public void i_click_on_register_button() {
        regPage.clickRegisterButton();
    }

    @Then("I should see error messages for invalid inputs")
    public void i_should_see_error_messages_for_invalid_inputs() {
        String error = regPage.getErrorMessage();
        Assert.assertTrue(error != null && !error.isEmpty(), "Unexpected error message!");
        ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), "registration_error");
    }

    @Then("I should be redirected to the home page without error")
    public void i_should_be_redirected_to_home_page_without_error() {
        Assert.assertTrue(regPage.isUserLoggedIn(), "Registration failed");
        ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), "registration_success");
    }
}
