package pageobject;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.StringStartsWith.startsWith;

public class RegisterPage {
    //поле ввода логина в окне регистрации
    private final By nameField = By.xpath(".//label[text()='Имя']/following-sibling::input");
    //поле ввода Email в окне регистрации
    private final By emailField = By.xpath(".//label[text()='Email']/following-sibling::input");
    //поле ввода пароля в окне регистрации
    private final By passwordField = By.xpath(".//*[text()='Пароль']/following-sibling::input");
    //большая кнопка Зарегистрироваться под окном пароля
    private final By registerButton = By.xpath(".//button[text()='Зарегистрироваться']");
    //сообщение о некорректном пароле при вводе менее 6 символов
    private final By shortPasswordError = By.xpath(".//p[text()='Некорректный пароль']");
    //кнопка Войти в меню регистрации внизу страницы
    private final By signInButton = By.xpath(".//a[text()='Войти']");

    private final WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    //ввод имени в поле имени
    public void inputName(String text) {
        driver.findElement(nameField).sendKeys(text);
    }

    //ввод email в поле email
    public void inputEmail(String text) {
        driver.findElement(emailField).sendKeys(text);
    }

    //ввод пароля в поле пароля
    public void inputPassword(String text) {
        driver.findElement(passwordField).sendKeys(text);
    }

    //клик на кнопку Регистрация
    public void clickFinallyRegisterButton() {
        driver.findElement(registerButton).click();
    }

    //проверка наличия сообщения об ошибке
    public void checkShortPasswordError() {
        String textOfError = driver.findElement(shortPasswordError).getText();
        MatcherAssert.assertThat("Вход", textOfError, startsWith("Некорректный пароль"));
    }

    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
}
