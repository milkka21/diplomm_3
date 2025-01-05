package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Browser {
    protected WebDriver driver;

    public WebDriver initDriver() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/test/resources/Browser.properties"));
        String browserProperty = properties.getProperty("testBrowser");
        BrowserType browserType = BrowserType.valueOf(browserProperty);

        switch (browserType) {
            case CHROME:
                ChromeOptions optionsChrome = new ChromeOptions();
                optionsChrome.addArguments("--start-maximized");
                optionsChrome.addArguments("--remote-allow-origins=");
                System.setProperty("webdriver.chrome.driver", "/Users/milkka/Downloads/chromedriver-mac-arm64-131.0.6778.204/chromedriver");
                driver = new ChromeDriver(optionsChrome);
                break;
            case YANDEX:
                System.setProperty("webdriver.chrome.driver", "/Users/milkka/Downloads/yandexdriver-24.12.0.1772-mac/yandexdriver");
                driver = new ChromeDriver();
                break;
            default:
                throw new RuntimeException("Browser undefined");
        }
        return driver;
    }
}
