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
import pages.AccountsPage;

import java.time.Duration;

public class AccountPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    AccountsPage accountsPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Coding_Softwares\\Softwares\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountsPage = new AccountsPage(driver);
        loginPage.LoginToApplication("rahul", "rahul@2021");
        loginPage.clickingLoginButton();
        String expectedUrl = "https://qamoviesapp.ccbp.tech/";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));
    }
    @Test
    public void testingAccountPage(){
        homePage.clickingAccountButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/account", "Account Url doesn't match");
        Assert.assertTrue(accountsPage.testingMembership());
        Assert.assertTrue(accountsPage.checkingMembershipUserName());
        Assert.assertTrue(accountsPage.checkingMembershipPasword());
        Assert.assertTrue(accountsPage.checkingPlan());
        accountsPage.checkingLogoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/login", "Logout Url doesn't Match");

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


}
