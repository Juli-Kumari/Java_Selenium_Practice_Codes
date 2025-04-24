package Java_Selenium_Practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Test_05_AlertPopUp {

    public static void main(String[] args){
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.selenium.dev/selenium/web/alerts.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));

        driver.findElement(By.id("alert")).click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        System.out.println("alert text: "+alertText);

        driver.close();
    }
}
