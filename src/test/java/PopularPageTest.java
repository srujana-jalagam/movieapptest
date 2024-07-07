import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.PopularPage;

import java.time.Duration;

public class PopularPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    PopularPage popularPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Coding_Softwares\\Softwares\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver= new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        popularPage = new PopularPage(driver);
        loginPage.LoginToApplication("rahul", "rahul@2021");
        loginPage.clickingLoginButton();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }

    @Test
    public void testingPopularPageUI(){
        homePage.clickingPopular();
        popularPage.moviesDisplay();
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
