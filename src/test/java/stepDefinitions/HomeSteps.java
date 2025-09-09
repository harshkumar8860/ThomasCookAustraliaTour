package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;
import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.ScreenshotUtil;

public class HomeSteps {
    private HomePage home = new HomePage();
    private String title;

    @Given("user opens the application")
    public void user_opens_the_application() {
        String browser = ConfigReader.get("browser"); // default comes from config
        DriverFactory.initDriver(browser);
        DriverFactory.getDriver().get(ConfigReader.get("baseUrl"));
    }

    @When("user captures the title")
    public void user_captures_the_title() {
        title = home.getTitle();
        // take screenshot on pass (as requested)
        ScreenshotUtil.takeScreenshot(DriverFactory.getDriver(), "homepage_pass");
    }

    @Then("title should contain \"Thomas Cook\"")
    public void title_should_contain_thomas_cook() {
        try {
            Assert.assertTrue(title != null && title.contains("Thomas Cook"), "Title does not contain expected text");
            // screenshot already taken on pass
        } finally {
            DriverFactory.quitDriver();
        }
    }
}
