package pageobject;

import org.hamcrest.MatcherAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.StringStartsWith.startsWith;

public class ProfilePage {
    //кнопка Выход
    private final By logoutButton = By.xpath(".//button[text() = 'Выход']");
    //кнопка Конструктор наверху слева
    private final By constructorButton = By.xpath(".//p[text()='Конструктор']");
    //лого
    private final By logoButton = By.xpath(".//div[@class='AppHeader_header__logo__2D0X2']");

    private final WebDriver driver;

    public ProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkLogoutButton() {
        String textOfLogoutButton = driver.findElement(logoutButton).getText();
        MatcherAssert.assertThat(textOfLogoutButton, startsWith("Выход"));
    }

    public void clickLogoutButton() {
        driver.findElement(logoutButton).click();
    }

    public void clickConstructorButton() {
        driver.findElement(constructorButton).click();
    }

    public void clickLogoButton() {
        driver.findElement(logoButton).click();
    }
}
