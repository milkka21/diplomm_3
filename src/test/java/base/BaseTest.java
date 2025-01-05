package base;

import browser.Browser;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;

import pageObject.MainPage;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {
    public WebDriver driver;

    @Before
    public void setUpChrome () throws IOException {
        Browser browser = new Browser();
        driver = browser.initDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        MainPage mainPage = new MainPage(driver);
        mainPage.open();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}