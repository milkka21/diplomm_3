package pageobject;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import static constants.Constants.BASE_URI;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.StringStartsWith.startsWith;

public class MainPage  {
    //кнопка "Личный кабинет":
    private final By personalAccountButton = By.xpath(".//p[text()='Личный Кабинет']");
    //кнопка Войти в аккаунт
    private final By signInButton = By.xpath(".//button[text()='Войти в аккаунт']");
    //кнопка Оформить заказ
    private final By makeOrderButton = By.xpath(".//button[contains(text(),'Оформить заказ')]");
    //кнопка Булки
    private final By bunsButton = By.xpath(".//div[span[text()='Булки']]");
    //кнопка Соусы
    private final By saucesButton = By.xpath(".//div[span[text()='Соусы']]");
    //кнопка Начинки
    private final By fillingsButton = By.xpath(".//*[text()='Начинки']");

    public static final By CONSTRUCTOR_ELEMENT = By.xpath("//p[text()='Конструктор']");

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    //открыть сайт
    public void open() {
        driver.get(BASE_URI);
    }

    //клик на кнопку Личный кабинет
    public void clickAccountButton() {
        driver.findElement(personalAccountButton).click();
    }

    //клик на кнопку Войти в аккаунт
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }

    //проверка наличия кнопки заказа
    public void checkOrderButton() {
        String textOrderButton = driver.findElement(makeOrderButton).getText();
        MatcherAssert.assertThat(textOrderButton, startsWith("Оформить заказ"));
    }

    //клик на кнопку Булки
    public void clickBunsButton() {
        driver.findElement(bunsButton).click();
    }

    //клик на кнопку Соусы
    public void clickSaucesButton() {
        driver.findElement(saucesButton).click();
    }

    //клик на кнопку Начинки
    public void clickFillingsButton() {
        driver.findElement(fillingsButton).click();
    }

    public void checkGoToTheBunsSection() {
        String text = driver.findElement(By.xpath(".//div[@style]/div[1]")).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("tab_tab__1SPyG"));
    }

    public void checkGoToTheSaucesSection() {
        String text = driver.findElement(By.xpath(".//div[@style]/div[2]")).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("tab_tab__1SPyG"));
    }

    public void checkGoToTheFillingsSection() {
        String text = driver.findElement(By.xpath(".//div[@style]/div[3]")).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("tab_tab__1SPyG"));
    }
}
