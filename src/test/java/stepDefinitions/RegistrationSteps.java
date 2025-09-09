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
