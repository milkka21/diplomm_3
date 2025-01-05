package login;

import org.junit.Test;
import io.qameta.allure.junit4.DisplayName;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObject.LoginPage;
import pageObject.MainPage;
import pageObject.ProfilePage;

import java.time.Duration;

import static pageObject.LoginPage.ConstructorElement;

public class AccountLoginTest extends base.BaseTest {
    @Test
    @DisplayName("Проверь переход по клику на «Личный кабинет»")
    public void accountLogin() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.clickAccountButton();
        loginPage.enterEmailAndPassword();
        loginPage.clickSignInButton();
        mainPage.clickAccountButton();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(ConstructorElement));
        profilePage.checkLogoutButton();
    }
}
