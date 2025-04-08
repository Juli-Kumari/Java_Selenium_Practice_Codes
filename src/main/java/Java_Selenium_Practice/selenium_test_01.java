package Java_Selenium_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenium_test_01 {

    public static void main(String[] args) {

        // Set up ChromeDriver (ensure chromedriver path is set in system or here)
        WebDriver driver = new ChromeDriver();

        try {
            driver.get("https://fitpeo.com/revenue-calculator");

            // Wait for the element to be present, or add explicit wait (recommended)
            WebElement ele = driver.findElement(By.xpath("//input[@id=':R57alklbrpida:']"));
            ele.sendKeys("2000");
            Thread.sleep(5000);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit(); // Closes all windows and ends session
        }
    }
}
