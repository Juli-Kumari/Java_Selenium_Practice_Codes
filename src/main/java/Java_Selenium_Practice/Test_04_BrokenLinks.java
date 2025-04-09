package Java_Selenium_Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class Test_04_BrokenLinks {
    public static void brokenLinks(String link) throws IOException {
        URL url = new URL(link);

        HttpURLConnection httpConnection = (HttpURLConnection) url.openConnection();
        httpConnection.connect();

        if (httpConnection.getResponseCode() != 200) {
            System.out.println("Broken Link: " + url);
        }
    }

    public static void main (String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://bstackdemo.com/");

        List<WebElement> links = driver.findElements(By.tagName("a"));
        for(WebElement link: links) {
            String url = link.getAttribute("href");
            brokenLinks(url);

        }
        driver.close();
    }
}
