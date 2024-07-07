package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountsPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(className = "membership-username")
    WebElement userNameEle;

    @FindBy(className = "membership-password")
    WebElement passwordEle;

    @FindBy(className = "membership-container")
    WebElement membershipEle;

    @FindBy (className = "plan-container")
    WebElement planEle;

    @FindBy (className = "logout-button")
    WebElement logoutEle;

    public AccountsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);

    }
    public boolean testingMembership(){
        return membershipEle.isDisplayed();
    }
    public boolean checkingMembershipUserName(){
        return userNameEle.isDisplayed();

    }
    public boolean checkingMembershipPasword(){
        return passwordEle.isDisplayed();
    }

    public boolean checkingPlan(){
        return planEle.isDisplayed();
    }
    public void checkingLogoutButton(){
        logoutEle.click();
    }
}
