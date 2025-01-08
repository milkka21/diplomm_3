package login;

import info.UserClient;
import info.UserCreate;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.ProfilePage;

import java.time.Duration;

import static pageobject.LoginPage.constructorElement;

public class LogoutTest extends base.BaseTest {

    private UserClient userClient;
    private UserCreate testUser;

    @Before
    public void setUp() {
        userClient = new UserClient(); // Инициализация клиента для работы с API
        testUser = new UserCreate("milkka2111", "qwertyi", "milkka2111@gmail.com"); // Создание нового пользователя
        userClient.register(testUser); // Регистрация пользователя через API
    }

    @Test
    @DisplayName("Проверь выход по кнопке «Выйти» в личном кабинете.")
    public void logout() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ProfilePage profilePage = new ProfilePage(driver);

        mainPage.clickAccountButton();
        loginPage.enterEmailAndPassword(testUser.getEmail(), testUser.getPassword());
        loginPage.clickSignInButton();
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(constructorElement));
        mainPage.clickAccountButton();
        profilePage.clickLogoutButton();
        loginPage.checkRegistrationIsSuccessfully();
    }
    @After
    public void tearDown() {
        userClient.deleteUser(testUser.getEmail());
        driver.quit();
    }
}