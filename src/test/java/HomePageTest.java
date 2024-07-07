import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;

import java.time.Duration;

public class HomePageTest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Coding_Softwares\\Softwares\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        loginPage.LoginToApplication("rahul", "rahul@2021");
        loginPage.clickingLoginButton();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));


    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testingHomePage() {


        Assert.assertEquals(homePage.getHeading1(), "Trending Now", "Heading1 Doesn't Match");
        Assert.assertEquals(homePage.getHeading2(), "Originals", "Heading2 Does't Match");

        Assert.assertTrue(homePage.playButtonDisplayed());
        Assert.assertTrue(homePage.trendingNowImage1());
        Assert.assertTrue(homePage.trendingNowImage2());
        Assert.assertTrue(homePage.orinalImgfirst());
        Assert.assertTrue(homePage.orinalImgLast());
        Assert.assertTrue(homePage.getContact());
    }
}
