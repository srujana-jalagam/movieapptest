import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.SearchPage;

import java.time.Duration;

public class SearchPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    SearchPage searchPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Coding_Softwares\\Softwares\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        searchPage = new SearchPage(driver);
        loginPage.LoginToApplication("rahul", "rahul@2021");
        loginPage.clickingLoginButton();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

    }
    @Test(priority = 1)
    public void testingSearchFunctionality(){
        searchPage.clickingSearchButton();
        searchPage.sendingInputTest();
        searchPage.clickingInputSearchButton();


        searchPage.sendingInvalidInput();
        searchPage.clickingInputSearchButton();
        String expectedMsg = "Your search for Godgilla did not find any matches.";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("not-found-search-paragraph")));
        Assert.assertEquals(searchPage.notFoundMsg(), expectedMsg, "not match");

        Assert.assertTrue(searchPage.image());



    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
