package Java_Code;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class TC_10_WaitsInSelenium {

        public static void main(String[] args) {

            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com/");
            driver.manage().window().maximize();
            // 1. implicit waits
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));

            // 2. explicit waits
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
            wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("APjFqb"))));

            // 3. fluent waits
            Wait<WebDriver> fluentWait = new FluentWait<WebDriver>(driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(NoSuchElementException.class);

            driver.close();
        }
    }

