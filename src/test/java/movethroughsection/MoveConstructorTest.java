package movethroughsection;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.MainPage;

public class MoveConstructorTest extends base.BaseTest {

    private MainPage mainPage;

    @Before
    public void setUp() {
        mainPage = new MainPage(driver);
    }

    @Test
    @DisplayName("Проверь, что работают переходы к разделу «Начинки».")
    public void navigationToFillings() {
        mainPage.clickFillingsButton();
        mainPage.checkGoToTheFillingsSection();
    }
    @Test
    @DisplayName("Проверь, что работают переходы к разделу «Соусы».")
    public void navigationToSauces() {
        mainPage.clickSaucesButton();
        mainPage.checkGoToTheSaucesSection();
    }
    @Test
    @DisplayName("Проверь, что работает переход к разделу «Булки».")
    public void navigationToBuns() {
        mainPage.checkGoToTheBunsSection();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}
