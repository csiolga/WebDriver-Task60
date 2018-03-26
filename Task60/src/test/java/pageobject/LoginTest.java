package pageobject;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import waits.Wait;

public class LoginTest {
    private static final String USERNAME = "seleniumtests10";
    private static final String PASSWORD = "060788avavav";
    private WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setup() {
        driver = Driver.getInstance().open();
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }

    @Test
    public void login() {
        homePage = loginPage.login(USERNAME,PASSWORD);
        Wait.waitForTitleChange(loginPage.getTitle());

        Assert.assertTrue(homePage.isDisplayed(),
                "Expected title is '" + homePage.getTitle() + "' but actual title is '" + driver.getTitle() + "'.");
    }

    @Test
    public void logout() {
        homePage = loginPage.login(USERNAME,PASSWORD);
        Wait.waitForTitleChange(loginPage.getTitle());
        loginPage = homePage.logout();

        Assert.assertTrue(loginPage.isDisplayed(),
                "Expected title is '" + loginPage.getTitle() + "' but actual title is '" + driver.getTitle() + "'.");
    }
}