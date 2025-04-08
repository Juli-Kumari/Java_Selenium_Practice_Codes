package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class MediaAisleHomePage {
    WebDriverWait wait;
    WebDriver driver;


    public MediaAisleHomePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Initialize WebElements using PageFactory
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[text()='Logout']")
    WebElement logoutButton;

    public boolean isLogoutButtonDisplayed() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
       return logoutButton.isDisplayed();
    }

}
