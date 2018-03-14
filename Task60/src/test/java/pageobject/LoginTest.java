package pageobject;

import driver.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    private static final String USERNAME = "seleniumtests10";
    private static final String PASSWORD = "060788avavav";
    WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;

    @BeforeMethod
    public void setup() {
        Driver.open();
        driver = Driver.getDriver();
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void teardown() {
        Driver.close();
    }

    @Test
    public void login() {
        homePage = loginPage.login(USERNAME,PASSWORD);
        waitForTitleChange(loginPage.getTitle());

        Assert.assertTrue(homePage.isDisplayed(),
                "Expected title is '" + homePage.getTitle() + "' but actual title is '" + driver.getTitle() + "'.");
    }

    @Test
    public void logout() {
        homePage = loginPage.login(USERNAME,PASSWORD);
        waitForTitleChange(loginPage.getTitle());
        loginPage = homePage.logout();

        Assert.assertTrue(loginPage.isDisplayed(),
                "Expected title is '" + loginPage.getTitle() + "' but actual title is '" + driver.getTitle() + "'.");
    }

    public void waitForTitleChange(String title) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.not(ExpectedConditions.titleIs(title)));
    }
}