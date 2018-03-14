package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class Driver {
    private static final String URL = "https://mail.ru";
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static void open() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(URL);
    }

    public static void close() {
        driver.close();
    }
}
