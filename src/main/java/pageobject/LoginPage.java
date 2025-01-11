package pageobject;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.StringStartsWith.startsWith;

public class LoginPage  {
    //маленькая кнопка Зарегистрироваться внизу страницы
    private final By registerButton = By.xpath(".//a[(@class = 'Auth_link__1fOlj' and text()= 'Зарегистрироваться')]");
    //кнопка Восстановить пароль
    private final By restorePasswordButton = By.xpath(".//a[text()='Восстановить пароль']");
    //кнопка Войти
    private final By signInButton = By.xpath(".//button[text()='Войти']");
    //поле ввода почты в окне входа
    private final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    //поле ввода пароля в окне входа
    private final By passwordField = By.xpath(".//*[text()='Пароль']/following-sibling::input");

    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    //клик на кнопку Зарегистрироваться
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }

    //проверка на наличие кнопки восстановления пароля
    public void checkRegistrationIsSuccessfully() {
        String textOfRestorePasswordButton = driver.findElement(restorePasswordButton).getText();
        MatcherAssert.assertThat(textOfRestorePasswordButton, startsWith("Восстановить пароль"));
    }

    //ввести почту и пароль в окне авторизации
    public void enterEmailAndPassword(String email, String password) {
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password);
    }

    // клик на кнопку Войти
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    //клик на кнопку Восстановить пароль
    public void clickRestorePasswordButton() {
        driver.findElement(restorePasswordButton).click();
    }
}
