package Praktikum.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderFormPageAboutRent {
    private WebDriver driver;
    private By deliveryDateField = By.cssSelector("[placeholder='* Когда привезти самокат']");
    private By rentPeriod = By.className("Dropdown-arrow");
    private By scooterColorBlack = By.id("black");
    private By commentField = By.cssSelector("[placeholder='Комментарий для курьера']");
    private By orderButtonInOrderForm = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    private By  yesButton = By.xpath(".//button[text()='Да']");
    public OrderFormPageAboutRent(WebDriver driver){ this.driver = driver; }
    public void setDeliveryDate(String deliveryDate){
        driver.findElement(deliveryDateField).sendKeys(deliveryDate);
    }
    public void selectRentPeriod(){
        driver.findElement(rentPeriod).click();
        driver.findElement(By.xpath(".//div[text()='трое суток']")).click();
    }
    public void selectScooterColor(){
        driver.findElement(scooterColorBlack).click();
    }
    public void setComment(String comment){
        driver.findElement(commentField).sendKeys(comment);
    }
    public void clickOrderButtonInOrderForm(){
        driver.findElement(orderButtonInOrderForm).click();
    }
    public void clickYesButton(){
        driver.findElement(yesButton).click();
    }
    public void waitForLoadOrderFormAboutRent(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[text()='Про аренду']")));
    }
    public void waitForLoadConfirmationDialog(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".Order_ModalHeader__3FDaJ")));
    }
    public void fillOrderFormAboutRent(String deliveryDate, String comment){
        setDeliveryDate(deliveryDate);
        selectRentPeriod();
        selectScooterColor();
        setComment(comment);
    }
}
