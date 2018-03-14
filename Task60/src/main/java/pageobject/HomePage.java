package pageobject;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends Page {
    private static String TITLE = "Входящие - Почта Mail.Ru";
    private static final By LOG_OUT_LINK = By.id("PH_logoutLink");
    WebDriver driver = Driver.getDriver();

    public HomePage() {
        super(TITLE);
    }

    public String getTitle() {
        return TITLE;
    }

    private WebElement LogoutLink() {
        return driver.findElement(LOG_OUT_LINK);
    }

    public HomePage clickLogoutLink() {
        LogoutLink().click();
        return this;
    }

    public LoginPage logout() {
        clickLogoutLink();
        return new LoginPage();
    }

     @Override
     public boolean isDisplayed() {
        return driver.getTitle().endsWith(TITLE);
    }
}
