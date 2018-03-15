package pageobject;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page {
    private static final String TITLE = "Входящие - Почта Mail.Ru";
    WebDriver driver = Driver.getDriver();

    public HomePage() {
        super(TITLE);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "PH_logoutLink")
    private WebElement LogoutLink;

    public String getTitle() {
        return TITLE;
    }

    public HomePage clickLogoutLink() {
        LogoutLink.click();
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
