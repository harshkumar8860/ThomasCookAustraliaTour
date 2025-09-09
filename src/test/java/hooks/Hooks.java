package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.ConfigReader;
import utilities.DriverFactory;
import utilities.ScreenshotUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void beforeScenario() {
        String browser = ConfigReader.get("browser");
        DriverFactory.initDriver(browser);
        DriverFactory.getDriver().get(ConfigReader.get("baseUrl"));
    }

    @After
    public void afterScenario(Scenario scenario) {
        if (DriverFactory.getDriver() != null) {
            if (scenario.isFailed()) {
                // Take actual screenshot bytes
                byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                        .getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            }
            // Quit only once
            DriverFactory.quitDriver();
        }
    }
}
