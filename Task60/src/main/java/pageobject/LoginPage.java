package pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Page {
    private static final String TITLE = "Mail.Ru: почта, поиск в интернете, новости, игры";

    public LoginPage() {
        super(TITLE);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "mailbox:login")
    private WebElement UsernameInput;

    @FindBy(id = "mailbox:password")
    private WebElement PasswordInput;

    @FindBy(xpath = "//label[@id='mailbox:submit']/input")
    private WebElement SubmitButton;

    public String getTitle() {
        return TITLE;
    }

    public LoginPage setUsername(String username) {
        UsernameInput.sendKeys(username);
        return this;
    }

    public LoginPage setPassword(String password) {
        PasswordInput.sendKeys(password);
        return this;
    }

    public LoginPage clickSubmitButton() {
        SubmitButton.click();
        return this;
    }

    public HomePage login(String username, String password ) {
        setUsername(username);
        setPassword(password);
        clickSubmitButton();
        return new HomePage();
    }
}
