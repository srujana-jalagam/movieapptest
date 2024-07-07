import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginPageTest {
    public WebDriver driver;

    LoginPage loginPage;

    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Coding_Softwares\\Softwares\\Chrome Driver\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
        String expectedUrl = "https://qamoviesapp.ccbp.tech/login";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(expectedUrl));

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }


    @Test(priority = 1)
    public void testingMainPageUI(){
        Assert.assertTrue(loginPage.isLogoImageDisplayed());

        String heading = loginPage.isHeadingTextIsSame();
        Assert.assertEquals(heading, "Login");

        String usertext = loginPage.isUserNameSame();
        Assert.assertEquals(usertext, "USERNAME");

        String userpasswordText = loginPage.isPasswordTextSame();
        Assert.assertEquals(userpasswordText, "PASSWORD");
    }
    @Test(priority = 2)
    public void testingEmtyInputs(){
        loginPage.clickingLoginButton();
        String actualMsg = loginPage.getErrorMsg();
        Assert.assertEquals(actualMsg,"*Username or password is invalid", "Does not match");
    }
    @Test(priority = 3)
    public void testingWithEmptyUserName(){
        loginPage.enterPassword("Password");
        loginPage.clickingLoginButton();
        Assert.assertEquals(loginPage.getErrorMsg(), "*Username or password is invalid");
    }

    @Test(priority = 4)
    public void testingWithEmptyPassword(){
        loginPage.enteruserName("userName");
        loginPage.clickingLoginButton();
        Assert.assertEquals(loginPage.getErrorMsg(), "*Username or password is invalid");
    }
    @Test(priority = 5)
    public void testingWithInvalidCred(){
        loginPage.LoginToApplication("rahul", "rahul@2024");
        loginPage.clickingLoginButton();
        Assert.assertEquals(loginPage.getErrorMsg(), "*username and password didn't match");
    }

    @Test(priority = 6)
    public void testingWithValidCred() {
        loginPage.LoginToApplication("rahul", "rahul@2021");
        loginPage.clickingLoginButton();

    }



}
