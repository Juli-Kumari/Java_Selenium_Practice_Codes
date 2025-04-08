package step_definitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import pages.AuthPage;
import pages.MediaAisleHomePage;
import io.github.cdimascio.dotenv.Dotenv;

import java.io.IOException;

public class mediaAislePlatformSignInStepDefinition {

    WebDriver driver;
    MediaAisleHomePage homePage;
    private Dotenv dotenv;
    AuthPage authPage;

    @Before
    public void setUp() throws IOException, InterruptedException {
        // Load the .env file
        dotenv = Dotenv.load();
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        homePage = new MediaAisleHomePage(driver);
        authPage = new AuthPage(driver); // define auth page
        driver.manage().window().maximize();
    }

    @Given("Open the media app link")
    public void open_the_media_app_link() throws InterruptedException {
        String url = dotenv.get("URL");
        driver.get(url);
    }
    @When("I enter the credential")
    public void i_enter_the_credential() throws InterruptedException, IOException {
        // Get email, password, and phone number from the .env file
        String email = dotenv.get("EMAIL");
        String password = dotenv.get("PASSWORD");
        String fa_key = dotenv.get("2FA_Key");
        // Sign In with your goggle account
        authPage.signIn(email, password, fa_key);
    }
    @Then("I am on the home page of the Loop app")
    public void i_am_on_the_home_page_of_the_loop_app() {
        String title = driver.getTitle();
        System.out.println("title= "+ title);
        Assert.assertEquals(title, "Loblaw Authentication");
        Assert.assertTrue(homePage.isLogoutButtonDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}