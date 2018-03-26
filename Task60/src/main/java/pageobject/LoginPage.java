package pageobject;

import org.openqa.selenium.By;

public class LoginPage extends Page {
    private static final String TITLE = "Mail.Ru: почта, поиск в интернете, новости, игры";
    private static final By usernameInput = By.id("mailbox:login");
    private static final By passwordInput = By.id("mailbox:password");
    private static final By loginButton = By.xpath("//label[@id='mailbox:submit']/input");

    public LoginPage() {
        super(TITLE);
    }

    public String getTitle() {
        return TITLE;
    }

    public HomePage login(String username, String password ) {
        driver.findElement(usernameInput).sendKeys(username);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
        return new HomePage();
    }
}
