package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    @FindBy(className="website-logo")
    WebElement logoImage;

    @FindBy(css = "div.home-bottom-container > div:nth-child(1) > h1")
    WebElement headingEle1;

    @FindBy(css = "div.home-bottom-container > div:nth-child(2) > h1")
    WebElement headingEle2;

    @FindBy (className ="contact-us-paragraph")
    WebElement contactUsEle;

    @FindBy (className ="home-movie-play-button")
    WebElement playButton;

    @FindBy(css = "div:nth-child(1) > div > div > div > div > div:nth-child(1) > div > a > div > img")
    WebElement firstImg;

    @FindBy(css = "div:nth-child(1) > div > div > div > div > div:nth-child(4) > div > a > div > img")
    WebElement lastImage;

    @FindBy(xpath ="//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div/div/div[1]/div/a/div/img")
    WebElement firstOriginalImg;

    @FindBy(xpath ="//*[@id=\"root\"]/div/div[2]/div[2]/div/div/div/div/div[4]/div/a/div/img")
    WebElement lastOriginalImg;

    @FindBy(className = "nav-header")
    WebElement navbar;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/nav/div[1]/ul/li[1]/a")
    WebElement navbarHomeEle;

    @FindBy(xpath = "//*[@id=\"root\"]/div/div[1]/nav/div[1]/ul/li[2]/a")
    WebElement navbarPopularEle;



    @FindBy(className = "avatar-button")
    WebElement accountSection;

     @FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div[1]/div/div/div/div/div[1]/div/a/div/img")
     WebElement homeImage;

     @FindBy(xpath = "//*[@id=\"root\"]/div/div")
     WebElement imagelogo;



    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public boolean getLogo(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("website-logo")));
        return logoImage.isDisplayed();
    }

    public String getHeading1(){
        return headingEle1.getText();
    }
    public String getHeading2(){
        return headingEle2.getText();
    }
    public boolean getContact(){
        return contactUsEle.isDisplayed();
    }
    public boolean playButtonDisplayed(){
        return playButton.isDisplayed();
    }
    public boolean trendingNowImage1(){
        return firstImg.isDisplayed();
    }

    public boolean trendingNowImage2(){
        return lastImage.isDisplayed();
    }

    public boolean orinalImgfirst(){
        return firstOriginalImg.isDisplayed();
    }

    public boolean orinalImgLast(){
        return lastOriginalImg.isDisplayed();
    }
    public boolean navbarDisplay(){
        return navbar.isDisplayed();
    }
    public boolean navbarHomeDisplay(){
        return navbarHomeEle.isDisplayed();

    }

    public boolean navbarPopularDisplay(){
        return navbarPopularEle.isDisplayed();
    }

    public void clickingHome(){
        navbarHomeEle.click();
    }
    public void clickingPopular(){
        navbarPopularEle.click();
    }
    public void clickingAccountButton(){
        accountSection.click();
    }

    public void clickingHomeImg(){
        homeImage.click();
    }
    public boolean displayingImg(){
        return imagelogo.isDisplayed();
    }


}
