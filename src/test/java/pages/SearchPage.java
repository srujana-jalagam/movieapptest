package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchPage {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(className = "search-empty-button")
    WebElement searchButtonEle;

    @FindBy(id = "search")
    WebElement inputfieldEle;


    @FindBy(className = "search-button")
    WebElement inputSearchEle;


    @FindBy (className = "not-found-search-paragraph")
    WebElement notfoundEle;

    @FindBy(className = "not-found-search-image")
    WebElement imageEle;

    public SearchPage(WebDriver driver){
        this.driver= driver;
        this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void clickingSearchButton(){
        searchButtonEle.click();
    }
    public void sendingInputTest(){
        inputfieldEle.sendKeys("Titanic");
    }

    public void clickingInputSearchButton(){
        inputSearchEle.click();
    }
    public int getNumberOfMoviesDisplayed(){
        return driver.findElements(By.xpath("//*[@id=\"root\"]/div/ul/li")).size();
    }
    public void sendingInvalidInput(){
        inputfieldEle.clear();
        inputfieldEle.sendKeys("Godgilla");
    }
    public String notFoundMsg(){
        return notfoundEle.getText();
    }
    public boolean image(){
       return imageEle.isDisplayed();
    }
}
