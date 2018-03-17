package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends Page {
    private static final String TITLE = "Входящие - Почта Mail.Ru";

    public HomePage() {
        super(TITLE);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "PH_logoutLink")
    private WebElement logoutLink;

    public String getTitle() {
        return TITLE;
    }

    public LoginPage logout() {
        logoutLink.click();
        return new LoginPage();
    }

     @Override
     public boolean isDisplayed() {
        return driver.getTitle().endsWith(TITLE);
    }
}
