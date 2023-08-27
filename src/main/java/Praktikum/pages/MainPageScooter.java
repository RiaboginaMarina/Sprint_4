package Praktikum.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPageScooter {
    private WebDriver driver;
    private By orderButtonTop = By.xpath(".//button[@class='Button_Button__ra12g']");
    private By orderButtonBottom = By.cssSelector(".Button_Middle__1CSJM");
    private By accordionComponent = By.cssSelector(".accordion");
    private  By cookieButton = By.className("App_CookieButton__3cvqF");

 public MainPageScooter(WebDriver driver){
        this.driver = driver;
    }
    public void clickOrderButtonTop(){
        driver.findElement(orderButtonTop).click();
    }
    public void clickOrderButtonBottom(){
        driver.findElement(orderButtonBottom).click();
    }
    public void clickCookieButton(){
     driver.findElement(cookieButton).click();
    }
    public void waitForLoadAccordionComponent(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(accordionComponent));
    }

}
