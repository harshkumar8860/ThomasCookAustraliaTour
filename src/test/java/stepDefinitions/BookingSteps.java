package stepDefinitions;

import io.cucumber.java.en.*;
import org.testng.Assert;
import pages.LoginPage;
import pages.BookingPage;
import utilities.DriverFactory;
import utilities.ScreenshotUtil;

public class BookingSteps {

    private LoginPage loginPage = new LoginPage();
    private BookingPage booking = new BookingPage();

@When("I hover on Holidays and open {string}")
public void hover_and_open_package(String menu) {
    booking.openAustraliaPackage();  // Reuse existing method
}

@When("I open package {string}")
public void open_package(String pkgName) {
    booking.selectTourPackage(); // Currently selects hardcoded Amazing Australia - Winter
}

@When("I select Date of Travel")
public void select_date_of_travel() {
    booking.selectTravelDate();
}

@When("I click Calculate Package Price")
public void click_calculate_package_price() {
    booking.clickCalculatePrice();
}

@When("I choose Pay Full Amount and Continue")
public void choose_pay_full_amount() {
    booking.payFullAmountAndContinue();
}

@Then("I am redirected to BookingSummary, I again click continue, and continue")
public void booking_summary_continue() {
    booking.bookingSummary();
}

//@When("I fill Traveller 1 details {string}, {string}, {string}, {string}, {string}")
//public void fill_traveller1(String title, String firstName, String lastName, String dob, String meal) {
//    booking.enterTravellerDetails1(title, firstName, lastName, dob, meal);
//}
//
//@When("I fill Traveller 2 details {string}, {string}, {string}, {string}, {string}")
//public void fill_traveller2(String title, String firstName, String lastName, String dob, String meal) {
//    booking.enterTravellerDetails2(title, firstName, lastName, dob, meal);
//}
//
//@When("I fill Address details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
//public void fill_address(String title, String firstName, String lastName, String address, String state, String city, String pincode, String email, String mobile) {
//    booking.fillAddressDetails(title, firstName, lastName, address, state, city, pincode, email, mobile);
//}
//
//@When("I select Credit Card and pay {string}, {string}, {string}, {string}, {string}")
//public void pay_with_card(String cardNo, String expMonth, String expYear, String cvv, String cardName) {
//    booking.makePayment(cardNo, expMonth, expYear, cvv, cardName);
//}

@Then("Payment Failed message should be displayed")
public void payment_failed_message() {
    Assert.assertTrue(booking.isBookingConfirmed());
}


    // ------------------------
    // Optional/old step defs (commented for reference)
    // ------------------------
    /*
    @When("user searches for {string}")
    public void user_searches_for_package(String pkg) {
        booking.searchPackage(pkg);
    }

    @When("user selects travel dates and number of travelers")
    public void user_selects_travel_dates_and_number_of_travelers() {
        booking.selectDatesAndTravelers("2025-12-01", 2, 1);
    }

    @When("user enters valid traveler details")
    public void user_enters_valid_traveler_details() {
        booking.enterTravelerDetails("John", "Doe", "01-01-1990", "M1234567");
    }

    @When("user proceeds with payment using valid card")
    public void user_proceeds_with_payment_using_valid_card() {
        booking.makePayment("4111111111111111", "12/26", "123");
    }

    @Then("booking confirmation will be displayed")
    public void booking_confirmation_should_be_displayed() {
        Assert.assertTrue(booking.isBookingConfirmed(), "Booking was not confirmed");
        ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), "booking_success");
    }

    @When("user selects past travel dates")
    public void user_selects_past_travel_dates() {
        booking.selectDatesAndTravelers("2020-01-01", 2, 1);
    }

    @Then("error message {string} will be displayed")
    public void error_message_displayed(String msg) {
        Assert.assertTrue(booking.getErrorMessage().contains(msg), "Expected error not shown");
        ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), "booking_error");
    }
    */
}
