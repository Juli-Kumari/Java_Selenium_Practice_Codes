package pages;

import org.jboss.aerogear.security.otp.Totp;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class AuthPage {
    WebDriver driver;
    WebDriverWait wait; //explicit wait
    String twoFactorCode;

    // constructor
    public AuthPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this); // initialize WebElements
        wait = new WebDriverWait(driver, Duration.ofSeconds(120));
    }

    // locate elements
    @FindBy(css = "input[name='username']") WebElement emailInputBox;
    @FindBy(xpath = "//button[text()='Next']") WebElement nextButton;

    // Google Authenticator
    @FindBy(css = "input#identifierId") WebElement emailInputField;
    @FindBy(xpath = "//span[text()='Next']") WebElement nextSignInStep;

    @FindBy(css = "input[name='Passwd']") WebElement passwordInputField;

    @FindBy(xpath = "//button[span[text()='Try another way']]") WebElement tryAnotherWayButton;
    @FindBy(xpath = "//li[contains(div, 'Google Authenticator')]") WebElement googleAuthenticatorOption;
    @FindBy(id = "totpPin") WebElement otpPinInputBox;
    @FindBy(css = "img[alt='Google SignIn']") WebElement signInWithGoogleButton;

    public void signIn(String username, String password, String faKeyValue) throws IOException, InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(emailInputBox));
        emailInputBox.sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(nextButton));
        nextButton.click();

        handleGoogleSignIn();

        // Handle the new window
        String parentWindowHandle = driver.getWindowHandle();
        Set<String> allWindowHandles = driver.getWindowHandles();

        // Switch to the new window (Google sign-in page)
        for (String windowHandle : allWindowHandles) {
            if (!windowHandle.equals(parentWindowHandle)) {
                driver.switchTo().window(windowHandle); // Iterates through all open window handles and switches to the one that is not the parent.
                break;
            }
        }

        // By using googleAuthenticatorOption
        wait.until(ExpectedConditions.visibilityOf(emailInputField));
        emailInputField.sendKeys(Keys.CONTROL, "a");
        emailInputField.sendKeys(username);
        wait.until(ExpectedConditions.elementToBeClickable(nextSignInStep));
        nextSignInStep.click();
        wait.until(ExpectedConditions.visibilityOf(passwordInputField));
        passwordInputField.sendKeys(password);
        wait.until(ExpectedConditions.elementToBeClickable(nextSignInStep));
        nextSignInStep.click();

        try {
            // Handle "Try Another Way" for 2FA
            wait.until(ExpectedConditions.elementToBeClickable(tryAnotherWayButton));
            tryAnotherWayButton.click();
        } catch (StaleElementReferenceException | ElementClickInterceptedException e) {
            wait.until(ExpectedConditions.elementToBeClickable(tryAnotherWayButton));  // Re-fetch the element
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", tryAnotherWayButton);
        }

        // Wait for Google Authenticator option to appear
        wait.until(ExpectedConditions.elementToBeClickable(googleAuthenticatorOption));
        googleAuthenticatorOption.click();

        // Wait for OTP input field
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("totpPin")));
        wait.until(ExpectedConditions.elementToBeClickable(otpPinInputBox));

        // Fetch the 2FA code
        twoFactorCode = twoFAKey(faKeyValue);
        otpPinInputBox.sendKeys(twoFactorCode);

        // Click next
        wait.until(ExpectedConditions.elementToBeClickable(nextSignInStep));
        nextSignInStep.click();

        // Final sleep to ensure the process completes
        Thread.sleep(5000);  // Give it a minute for the process to complete

        driver.switchTo().window(parentWindowHandle); // switch back to parent window
    }

    public String twoFAKey(String faKey) throws IOException {
        String otpKeyStr = faKey;  // Load the 2FA secret key
        Totp totp = new Totp(otpKeyStr); //TOTP (Time-based One-Time Password)
        String twoFactorCode = totp.now();
        System.out.println("Generated OTP: " + twoFactorCode);
        return twoFactorCode;
    }

    public void handleGoogleSignIn() {
        try {
            wait.until(ExpectedConditions.visibilityOf(signInWithGoogleButton));
            wait.until(ExpectedConditions.elementToBeClickable(signInWithGoogleButton));
            signInWithGoogleButton.click();
        } catch (Exception e) {
            System.out.println("Google sign-in button not available; assuming default Google sign-in.");
        }
    }
}
