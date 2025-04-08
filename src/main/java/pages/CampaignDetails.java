package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CampaignDetails {
    WebDriverWait wait;
    WebDriver driver;
    CampaignDetails(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }
    @FindBy(id = "name")
    WebElement campaignNameInputBox;

    @FindBy(id = "startDate-datepicker")
    WebElement startDateInputBox;

    @FindBy(id = "endDate-datepicker")
    WebElement endDateInputBox;

    @FindBy(id = "budget")
    WebElement budgetInputBox;

    @FindBy(id="advertiserId-select")
    WebElement advertiserDropDown;

    @FindBy (xpath = "(//ul[@aria-labelledby=\"advertiserId-select-label\"]//li)[1]")
    WebElement advertiseroption1;

    @FindBy(id="purchaseOrderNumber")
    WebElement purchaseOrderNoInputBox;

    @FindBy(id="advendioId")
    WebElement advendioIdInputBox;

    @FindBy(xpath = "//button[text()=\"Save & Continue\"]")
    WebElement saveAndContinueButton;


}
