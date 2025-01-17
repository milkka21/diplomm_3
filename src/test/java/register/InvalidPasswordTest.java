package register;

import com.github.javafaker.Faker;

import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;

public class InvalidPasswordTest extends base.BaseTest {
    Faker faker = new Faker();

    @Test
    @DisplayName("Проверь ошибку для некорректного пароля. Минимальный пароль — шесть символов.")
    public void shortPasswordError() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickAccountButton();
        loginPage.clickRegisterButton();
        registerPage.inputName(faker.name().firstName());
        registerPage.inputEmail(faker.internet().emailAddress());
        registerPage.inputPassword(faker.internet().password(3, 5));
        registerPage.clickFinallyRegisterButton();
        registerPage.checkShortPasswordError();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}