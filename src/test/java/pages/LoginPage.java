package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By logoEle = By.className("login-website-logo");
    By headingTextEle = By.className("sign-in-heading");
    By nameTextEle = By.xpath("//*[@id=\"root\"]/div/div[2]/form/div[1]/label");
    By passwordTextEle = By.xpath("//*[@id=\"root\"]/div/div[2]/form/div[2]/label");
    By userNameEle = By.id("usernameInput");
    By userPassword = By.id("passwordInput");
    By button = By.className("login-button");
    By errorMessage = By.className("error-message");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isLogoImageDisplayed() {
        return driver.findElement(logoEle).isDisplayed();
    }

    public String isHeadingTextIsSame() {
        return driver.findElement(headingTextEle).getText();
    }

    public String isUserNameSame() {
        return driver.findElement(nameTextEle).getText();
    }

    public String isPasswordTextSame() {
        return driver.findElement(passwordTextEle).getText();
    }

    public void clickingLoginButton(){
         driver.findElement(button).click();
    }

    public String getErrorMsg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
        WebElement errorMsg = driver.findElement(errorMessage);
        return errorMsg.getText();
    }


    public void enteruserName(String userName){
        driver.findElement(userNameEle).sendKeys(userName);
    }
    public void enterPassword(String password){
        driver.findElement(userPassword).sendKeys(password);
    }

    public void LoginToApplication(String userName, String password){
        enteruserName(userName);
        enterPassword(password);
        clickingLoginButton();

    }
}
