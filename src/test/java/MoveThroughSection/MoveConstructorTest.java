package MoveThroughSection;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageObject.MainPage;

public class MoveConstructorTest extends base.BaseTest {
    @Test
    @DisplayName("Проверь, что работают переходы к разделам:«Булки», «Соусы», «Начинки».")
    public void navigationThroughMenu() {
        MainPage mainPage = new MainPage(driver);

        mainPage.clickFillingsButton();
        mainPage.checkGoToTheFillingsSection();
        mainPage.clickSaucesButton();
        mainPage.checkGoToTheSaucesSection();
        mainPage.clickBunsButton();
        mainPage.checkGoToTheBunsSection();
    }
}
