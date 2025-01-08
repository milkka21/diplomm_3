package register;

import info.User;
import info.UserClient;
import com.github.javafaker.Faker;
import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.junit.After;
import org.junit.Test;
import pageobject.LoginPage;
import pageobject.MainPage;
import pageobject.RegisterPage;

public class ValidRegTest extends base.BaseTest {
    protected UserClient client = new UserClient();
    protected Faker faker = new Faker();
    protected String name = faker.name().firstName();
    protected String email = faker.internet().emailAddress();
    protected String password = faker.internet().password(6, 9);

    @Test
    @DisplayName("Проверь успешную регистрацию")
    public void successfulRegistration() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.clickAccountButton();
        loginPage.clickRegisterButton();
        registerPage.inputName(name);
        registerPage.inputEmail(email);
        registerPage.inputPassword(password);
        registerPage.clickFinallyRegisterButton();
        loginPage.checkRegistrationIsSuccessfully();

        ValidatableResponse response = client.loginUser(new User(email, password));
        String accessToken = client.getToken(response);
        ValidatableResponse deleteResponse = client.deleteUser(accessToken);
        client.userDeleted(deleteResponse);
    }
    @After
    public void tearDown() {
        driver.quit();
    }
}