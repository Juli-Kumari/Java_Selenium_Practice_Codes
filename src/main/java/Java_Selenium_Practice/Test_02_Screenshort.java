package Java_Selenium_Practice;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;


public class Test_02_Screenshort {
    public static void main (String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com/login.php");
        TakesScreenshot sc =  (TakesScreenshot) driver;
        File source = sc.getScreenshotAs(OutputType.FILE);
        File destination = new File("/home/juli/Downloads/SC/"+ Math.random()+".png");
        FileUtils.copyFile(source, destination);
        driver.close();
    }
}
