package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PopularPage {
    WebDriver driver;
    WebDriverWait wait;



    public PopularPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        PageFactory.initElements(this.driver, this);
    }
    public boolean moviesDisplay(){
        List<WebElement> movies = driver.findElements(By.className("search-movies-container"));
        for (int i=0; i<movies.size(); i++){
            return movies.get(i).isDisplayed();
        }
        return false;
    }
}

