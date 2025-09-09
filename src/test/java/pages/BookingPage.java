package pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BookingPage extends BasePage {

    // -------------------- Locators --------------------

    // Navigation
    private final By holidayMenu = By.id("navbarDropdown");
    private final By australiaLink = By.xpath(
        "//a[contains(normalize-space(@href), '/holidays/international-tour-packages/australia-tour-packages')]"
    );

    // Package selection
    private final By firstPackageLink = By.xpath(
        "//*[@id='package_detail_PKG014023']/div[1]/div[1]/div/div[2]/div/div[1]/div[1]/h2/a"
    );
    private final By ScrollToNoOfAdults = By.cssSelector(
        ".col-6.col-sm-6.col-md-6.col-lg-3.p-r-0.no_of_adults"
    );
    private final By travelDateInput = By.cssSelector(".col-xs-6.col-sm-4.padd-left0");
    private final By dateOfTravelling = By.id("18-10-2025"); // hardcoded for now

    // Contact
    private final String email = "defghi23@gmail.com";
    private final String number = "8249470947";
    private final By emailField = By.id("userEmailId");  // TODO: update locator later
    private final By phoneField = By.id("userMobileNo"); // TODO: update locator later

    private final By calculateAmount = By.xpath("//button[text()='Calculate Package Price']");
    private final By continueButton = By.xpath("//button[contains(@data-bind, 'submitPkg')]");

    // Booking Summary
    private final By bookingSummaryContButton = By.id("pre-continueBtn");
    private final By SingnInContinueButton = By.xpath(
        "//*[@id=\"preContent\"]/div[2]/div[2]/div/div[3]/div/div[2]/div[1]/div/div[2]/button"
    );

    // Traveller details
    private final String title1 = "MR.";
    private final String title2 = "MR.";
    private final By TitleOfTraveller = By.xpath("//*[@id=\"room1_adultTitle1\"]");
    private final By TravellerFName = By.xpath("//*[@id=\"room1_adultFName1\"]");
    private final By TravellerLName = By.xpath("//*[@id=\"room1_adultLName1\"]");
    private final By PassportNumber = By.xpath("//*[@id=\"room1_adultPassportNo1\"]");

    // Payment
    private final By PaymentPayer = By.id("payer1_1");
    private final By PanCardName = By.xpath("//*[@id=\"pancardname1_1\"]");
    private final By PanCardNumber = By.id("pancardnumber1_1");

    // Address
    private final By ScrollToFillAddress = By.xpath(
        "//*[@id=\"preContent\"]/div[2]/div[2]/div/div[5]/div/div[2]/div/div[4]/div[1]/div[1]/span"
    );
    private final By AdressFName = By.id("fName-address");
    private final By AdressLName = By.id("lName-address");
    private final By AddressDetails = By.xpath(
        "//*[@id=\"preContent\"]/div[2]/div[2]/div/div[5]/div/div[2]/div/div[4]/div[1]/div[3]/form/div[2]/textarea"
    );
    private final By CityName = By.id("city");
    private final By PinCode = By.id("pincode-address");

    // Traveler inputs (generic)
    private final By travelerInput = By.id("travelers");
    private final By continueBtn = By.id("continueBtn");
    private final By nameField = By.id("travelerName");
    private final By passportField = By.id("passportNumber");

    // Payment (generic)
    private final By paymentCard = By.id("cardNumber");
    private final By expiryField = By.id("cardExpiry");
    private final By cvvField = By.id("cardCvv");
    private final By confirmBtn = By.id("confirmBtn");

    // Messages
    private final By bookingMsg = By.cssSelector(".booking-confirm");
    private final By errorMsg = By.cssSelector(".error");

    private final WebDriverWait wait;

    public BookingPage() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }


    public void openHomePage() {
        driver.get("https://www.thomascook.in/");
    }

    public void openAustraliaPackage() {
        WebElement menu = wait.until(ExpectedConditions.visibilityOfElementLocated(holidayMenu));
        new Actions(driver).moveToElement(menu).perform();

        WebElement australia = wait.until(ExpectedConditions.elementToBeClickable(australiaLink));
        australia.click();
    }

    public void selectTourPackage() {
        WebElement pkg = wait.until(ExpectedConditions.elementToBeClickable(firstPackageLink));
        pkg.click();
    }

    public void selectTravelDate() {
    	scrollToElement(ScrollToNoOfAdults);
        WebElement datePicker = wait.until(ExpectedConditions.elementToBeClickable(travelDateInput));
        datePicker.click();
        WebElement date = wait.until(ExpectedConditions.elementToBeClickable(dateOfTravelling)); // dynamic
        date.click();
    }
    
    public void clickCalculatePrice() {
        driver.findElement(calculateAmount).click();
    }

    public void payFullAmountAndContinue() {
    	 scrollToElement(continueButton);
         WebElement contBtn = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
         contBtn.click();
    }
    
    /** Handles booking summary flow. */
    public void bookingSummary() {
        scrollToElement(bookingSummaryContButton);
        WebElement contBtn = wait.until(ExpectedConditions.elementToBeClickable(bookingSummaryContButton));
        contBtn.click();

        WebElement againContBtn = wait.until(ExpectedConditions.elementToBeClickable(SingnInContinueButton));
        againContBtn.click();
    }

    /** Navigates through traveller details step. */
    public void enterTravellerDetails() {
        WebElement contBtn = wait.until(ExpectedConditions.elementToBeClickable(bookingSummaryContButton));
        contBtn.click();

        WebElement againContBtn = wait.until(ExpectedConditions.elementToBeClickable(SingnInContinueButton));
        againContBtn.click();

        scrollToElement(ScrollToFillAddress);
    }

    // -------------------- Optional Methods (commented for reference) --------------------
    
    public void selectDatesAndTravelers(String date, int adults, int children) {
        WebElement datePicker = wait.until(ExpectedConditions.elementToBeClickable(travelDateInput));
        datePicker.sendKeys(date);

        WebElement traveler = wait.until(ExpectedConditions.visibilityOfElementLocated(travelerInput));
        traveler.clear();
        traveler.sendKeys(adults + " Adults, " + children + " Children");

        WebElement contBtn = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        contBtn.click();
    }

    public void enterTravelerDetails(String fname, String lname, String passport) {
        WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        name.clear();
        name.sendKeys(fname + " " + lname);

        WebElement pass = wait.until(ExpectedConditions.visibilityOfElementLocated(passportField));
        pass.clear();
        pass.sendKeys(passport);

        WebElement contBtn = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        contBtn.click();
    }

    public void makePayment(String card, String expiry, String cvv) {
        WebElement cardField = wait.until(ExpectedConditions.visibilityOfElementLocated(paymentCard));
        cardField.sendKeys(card);

        WebElement expiryFieldEl = wait.until(ExpectedConditions.visibilityOfElementLocated(expiryField));
        expiryFieldEl.sendKeys(expiry);

        WebElement cvvFieldEl = wait.until(ExpectedConditions.visibilityOfElementLocated(cvvField));
        cvvFieldEl.sendKeys(cvv);

        WebElement contBtn = wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        contBtn.click();

        WebElement confirm = wait.until(ExpectedConditions.elementToBeClickable(confirmBtn));
        confirm.click();
    }
    

    /** Checks if booking is confirmed. */
    public boolean isBookingConfirmed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(bookingMsg)).isDisplayed();
    }

    /** Returns the error message text. */
    public String getErrorMessage() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMsg)).getText();
    }

    // -------------------- Helpers --------------------

    /** Scrolls the page until the given element is visible in the viewport. */
    public void scrollToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].scrollIntoView({block: 'center', inline: 'nearest'});", element
        );
    }
}
