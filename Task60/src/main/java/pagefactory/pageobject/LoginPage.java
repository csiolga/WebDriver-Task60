package pagefactory.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import waits.Wait;

public class LoginPage extends Page {
    private static final String TITLE = "Mail.Ru: почта, поиск в интернете, новости, игры";

    @FindBy(id = "mailbox:login")
    private WebElement usernameInput;

    @FindBy(id = "mailbox:password")
    private WebElement passwordInput;

    @FindBy(xpath = "//label[@id='mailbox:submit']/input")
    private WebElement loginButton;

    public LoginPage() {
        super(TITLE);
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return TITLE;
    }

    public HomePage login(String username, String password ) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        Wait.waitForTitleChange(TITLE);

        return new HomePage();
    }
}
