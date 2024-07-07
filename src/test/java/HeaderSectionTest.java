import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
import java.util.List;

public class HeaderSectionTest {
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
    @Test(priority = 1)
    public void headerSectionUI(){
        Assert.assertTrue(homePage.getLogo());
        Assert.assertTrue(homePage.navbarDisplay());
        Assert.assertTrue(homePage.navbarHomeDisplay());
        Assert.assertTrue(homePage.navbarPopularDisplay());
    }
    @Test(priority = 2)
    public void headerSectionFunctionalities(){
        homePage.clickingHome();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/", "Home Url doesn,t match");
        homePage.clickingPopular();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/popular", "popular Url doesn't match");

        homePage.clickingAccountButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/account", "Account Url doesn't match");

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
