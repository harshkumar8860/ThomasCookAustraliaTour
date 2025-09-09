package pages;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

//    private By usernameField = By.id("loginEmail");     // TODO: update locator
//    private By passwordField = By.id("loginPassword");  // TODO: update locator
    private By loginLogoutToggel   = By.id("LoginLogoutToggel");       // TODO: update locator
    private By FirstLogin   = By.id("mainLogIn");       // TODO: update locator
    private By EmailPlaceHolder   = By.id("loginId");       // TODO: update locator
    private By SendOTP   = By.id("sendOTP");       // TODO: update locator
    private By EnterOTP   = By.id("loginOTP");       // TODO: update locator
    private By SecondLogin   = By.id("loginButton");       // TODO: update locator
    private By errorMsg = By.cssSelector(".error"); // TODO: update locator
    private WebDriverWait wait;
    
    public void openLoginPage() {
        driver.get("https://www.thomascook.in/");
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(20)); // default 20s wait   
    }

//    public void login(String email) {
//    	driver.findElement(loginLogoutToggel).click();
//    	driver.findElement(FirstLogin).click();
//    	driver.findElement(EmailPlaceHolder).sendKeys(email);
//    	driver.findElement(SendOTP).click();
//    	driver.findElement(EnterOTP).click();
//    	
//    	 try {
//			Thread.sleep(40000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//    	 
////    	Thread.wait(180000);
//    	 // Set implicit wait to 180 seconds
////        driver.manage().timeouts().implicitlyWait(180, TimeUnit.SECONDS);
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
////    	  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(180));
////    	    wait.until(ExpectedConditions.elementToBeClickable(SecondLogin));
////    	    
//    	driver.findElement(SecondLogin).click();
//       
////        driver.findElement(loginButton).click();
//    }
    
    public void login(String email) {
//        driver.findElement(loginLogoutToggel).click();
//        driver.findElement(FirstLogin).click();
    	wait.until(ExpectedConditions.elementToBeClickable(loginLogoutToggel)).click();
    	wait.until(ExpectedConditions.elementToBeClickable(FirstLogin)).click();

//        driver.findElement(EmailPlaceHolder).sendKeys(email);
        wait.until(ExpectedConditions.elementToBeClickable(EmailPlaceHolder)).sendKeys(email);
//        driver.findElement(SendOTP).click();
//        driver.findElement(EnterOTP).click();
//         Wait until SendOTP is clickable
        wait.until(ExpectedConditions.elementToBeClickable(SendOTP)).click();

        // Wait until OTP input is visible (optional, can also be manual)
        wait.until(ExpectedConditions.visibilityOfElementLocated(EnterOTP)).click();

        try {
            Thread.sleep(40000); // TODO: replace with explicit wait later
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Don’t click SecondLogin here, move it to separate method
    }

    public void clickFinalLogin() {
        driver.findElement(SecondLogin).click();
        try {
            Thread.sleep(20000); // TODO: replace with explicit wait later
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//    	wait.until(ExpectedConditions.elementToBeClickable(SecondLogin)).click();
    }


    public boolean isLoginSuccessful() {
        try {
            return new WebDriverWait(driver, Duration.ofSeconds(30))
                    .until(d -> {
                        String text = driver.findElement(loginLogoutToggel).getText().trim();
                        return !text.equalsIgnoreCase("Login");
                    });
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {
        return driver.findElement(errorMsg).getText();
    }
    
    
    

    public void handleMultipleSessionAlert() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            String alertText = alert.getText();
            System.out.println("Alert appeared: " + alertText);

            // Accept the alert (logout other sessions and continue)
            alert.accept();

            // OR use dismiss() if you want to continue without logout
            // alert.dismiss();

        } catch (Exception e) {
            System.out.println("No alert appeared.");
        }
    }

}
