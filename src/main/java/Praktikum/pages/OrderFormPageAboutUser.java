package Praktikum.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class OrderFormPageAboutUser {
    private WebDriver driver;
    private By nameField = By.cssSelector("[placeholder='* Имя']");
    private By surnameField = By.cssSelector("[placeholder='* Фамилия']");
    private By addressField = By.cssSelector("[placeholder='* Адрес: куда привезти заказ']");
    private By metroStation = By.cssSelector("[placeholder='* Станция метро']");
    private By telephoneNumber = By.cssSelector("[placeholder='* Телефон: на него позвонит курьер']");
    private By nextButton = By.xpath(".//button[text()='Далее']");
    public OrderFormPageAboutUser(WebDriver driver){
        this.driver = driver;
    }
    public void setUsername(String username){
        driver.findElement(nameField).sendKeys(username);
    }
    public void setUserSurname(String userSurname){
        driver.findElement(surnameField).sendKeys(userSurname);
    }
    public void setAddress(String userAddress){
        driver.findElement(addressField).sendKeys(userAddress);
    }
    public void selectMetroStation(){
        driver.findElement(metroStation).click();
        driver.findElement(By.xpath(".//div[text()='Сокольники']")).click();
    }
    public void setTelephoneNumber(String userPhoneNumber){
        driver.findElement(telephoneNumber).sendKeys(userPhoneNumber);
    }
    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }
    public void waitForLoadOrderFormAboutUser(){
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions
                        .visibilityOfElementLocated(By.cssSelector(".Order_Form__17u6u")));
    }
    public void fillOrderFormAboutUser(String username, String userSurname, String userAddress, String userPhoneNumber){
        setUsername(username);
        setUserSurname(userSurname);
        setAddress(userAddress);
        selectMetroStation();
        setTelephoneNumber(userPhoneNumber);
    }

}
