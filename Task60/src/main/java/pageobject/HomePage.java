package pageobject;

import org.openqa.selenium.By;

public class HomePage extends Page {
    private static final String TITLE = "Входящие - Почта Mail.Ru";
    private static final By logoutLink = By.id("PH_logoutLink");

    public HomePage() {
        super(TITLE);
    }

    public String getTitle() {
        return TITLE;
    }

    public LoginPage logout() {
        driver.findElement(logoutLink).click();
        return new LoginPage();
    }

     @Override
     public boolean isDisplayed() {
        return driver.getTitle().endsWith(TITLE);
    }
}
