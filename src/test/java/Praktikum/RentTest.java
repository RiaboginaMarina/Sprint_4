package Praktikum;
import Praktikum.pages.MainPageScooter;
import Praktikum.pages.OrderFormPageAboutRent;
import Praktikum.pages.OrderFormPageAboutUser;
import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.hamcrest.CoreMatchers.containsString;

@RunWith(Parameterized.class)
public class RentTest {
    private final String username;
    private final String userSurname;
    private final String userAddress;
    private final String userPhoneNumber;
    private final String deliveryDate;
    private final String comment;
    private final String isDisplayed;

    public RentTest(String username, String userSurname, String userAddress, String userPhoneNumber, String deliveryDate, String comment, String isDisplayed){
        this.username = username;
        this.userSurname = userSurname;
        this.userAddress = userAddress;
        this.userPhoneNumber = userPhoneNumber;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.isDisplayed = isDisplayed;
    }
    @Parameterized.Parameters
    public static Object[][] getRegisterFormAboutUser() {
        return new Object[][]{
                {"Марина", "Рябогина", "Петрова", "+79638527412", "03.09.2023", "Домофон не работает", "Заказ оформлен"},
                {"Наташа", "Рябогина", "Юрина", "+77418529632", "03.09.23", "нет", "Заказ оформлен"},
        };
    }
    @Rule
    public DriverRule driverRule = new DriverRule();

    @Test
    public void rentScooterTopButton(){
        WebDriver driver = driverRule.getDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPageScooter objMainPage = new MainPageScooter(driver);
        objMainPage.clickOrderButtonTop();
        OrderFormPageAboutUser objFormPageAboutUser = new OrderFormPageAboutUser(driver);
        objFormPageAboutUser.waitForLoadOrderFormAboutUser();
        objFormPageAboutUser.fillOrderFormAboutUser(username, userSurname, userAddress, userPhoneNumber);
        objFormPageAboutUser.clickNextButton();
        OrderFormPageAboutRent objOrderFormAboutRent = new OrderFormPageAboutRent(driver);
        objOrderFormAboutRent.waitForLoadOrderFormAboutRent();
        objOrderFormAboutRent.fillOrderFormAboutRent(deliveryDate, comment);
        objOrderFormAboutRent.clickOrderButtonInOrderForm();
        objOrderFormAboutRent.waitForLoadConfirmationDialog();
        objOrderFormAboutRent.clickYesButton();
        String orderPlacedSuccessfullyMessageIsDisplayed = driver.findElement(By.className("Order_ModalHeader__3FDaJ")).getText();
        MatcherAssert.assertThat("Не появилось всплывающее окно с сообщением об успешном создании заказа.", orderPlacedSuccessfullyMessageIsDisplayed, containsString(isDisplayed));

    }
    @Test
    public  void rentScooterBottomButton(){
        WebDriver driver = driverRule.getDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");
        MainPageScooter objMainPage = new MainPageScooter(driver);
        objMainPage.clickCookieButton();
        WebElement element = driver.findElement(By.cssSelector(".Button_Middle__1CSJM"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        objMainPage.clickOrderButtonBottom();
        OrderFormPageAboutUser objFormPageAboutUser = new OrderFormPageAboutUser(driver);
        objFormPageAboutUser.waitForLoadOrderFormAboutUser();
        objFormPageAboutUser.fillOrderFormAboutUser(username, userSurname, userAddress, userPhoneNumber);
        objFormPageAboutUser.clickNextButton();
        OrderFormPageAboutRent objOrderFormAboutRent = new OrderFormPageAboutRent(driver);
        objOrderFormAboutRent.waitForLoadOrderFormAboutRent();
        objOrderFormAboutRent.fillOrderFormAboutRent(deliveryDate, comment);
        objOrderFormAboutRent.clickOrderButtonInOrderForm();
        objOrderFormAboutRent.waitForLoadConfirmationDialog();
        objOrderFormAboutRent.clickYesButton();
        String orderPlacedSuccessfullyMessageIsDisplayed = driver.findElement(By.className("Order_ModalHeader__3FDaJ")).getText();
        MatcherAssert.assertThat("Не появилось всплывающее окно с сообщением об успешном создании заказа.", orderPlacedSuccessfullyMessageIsDisplayed, containsString(isDisplayed));
    }
}
