package Praktikum;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.File;
import java.time.Duration;


public class DriverRule extends ExternalResource {
    WebDriver driver;
    @Override
    protected void before() throws Throwable {
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("/C:/WebDriver/bin/chromedriver.exe"))
                .build();
        driver = new ChromeDriver(service);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
    @Override
    protected void after() {
        driver.quit();
    }
    public WebDriver getDriver() {
        return driver;
    }
}
