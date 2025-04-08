package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class HomePage {
    WebDriverWait wait;
    WebDriver driver;
    HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    @FindBy(xpath="//button[text()='Create New Campaign']")
    WebElement createNewCampaignButton;

    public void clickCreateNewCampaign(){
        wait.until(ExpectedConditions.elementToBeClickable(createNewCampaignButton));
        createNewCampaignButton.click();
    }
}
