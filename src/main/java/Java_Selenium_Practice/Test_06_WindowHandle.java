package Java_Selenium_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Test_06_WindowHandle {

        public static void main(String[] args) throws InterruptedException {
            WebDriver driver = new ChromeDriver();

            // Open the first window
            driver.get("https://www.google.com");
            String firstWindowHandle = driver.getWindowHandle();
            System.out.println("First window handle: " + firstWindowHandle);

            // Open a new window by name
            WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);
            newWindow.navigate().to("https://www.selenium.dev");
            String newWindowHandle = newWindow.getWindowHandle();
            System.out.println("New window handle: " + newWindowHandle);

            // Switch back to the first window
            driver.switchTo().window(firstWindowHandle);
            System.out.println("Switched back to the first window.");

            // Open a new tab
            driver.switchTo().newWindow(WindowType.TAB).navigate().to("https://www.bing.com");
            System.out.println("Opened a new tab.");

            // Keep browser open for a moment to see the actions
            Thread.sleep(3000);

            // Close all windows
            driver.quit();
        }
}
