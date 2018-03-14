package pageobject;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends Page {
    private static final String TITLE = "Mail.Ru: почта, поиск в интернете, новости, игры";
    private static final By USERNAME_INPUT = By.id("mailbox:login");
    private static final By PASSWORD_INPUT = By.id("mailbox:password");
    private static final By SUBMIT_BUTTON = By.xpath("//label[@id='mailbox:submit']/input");
    WebDriver driver = Driver.getDriver();

    public LoginPage() {
        super(TITLE);
    }

    public String getTitle() {
        return TITLE;
    }

    private WebElement UsernameInput() {
        return driver.findElement(USERNAME_INPUT);
    }

    public LoginPage setUsername(String username) {
        UsernameInput().sendKeys(username);
        return this;
    }

    private WebElement PasswordInput() {
        return driver.findElement(PASSWORD_INPUT);
    }

    public LoginPage setPassword(String password) {
        PasswordInput().sendKeys(password);
        return this;
    }

    private WebElement SubmitButton() {
        return driver.findElement(SUBMIT_BUTTON);
    }

    public LoginPage clickSubmitButton() {
        SubmitButton().click();
        return this;
    }

    public HomePage login(String username, String password ) {
        setUsername(username);
        setPassword(password);
        clickSubmitButton();
        return new HomePage();
    }
}
