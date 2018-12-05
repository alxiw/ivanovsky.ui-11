package ru.mail.track.ui11.hw04.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.mail.track.ui11.hw04.data.BrowsersData;

import java.util.concurrent.TimeUnit;

public final class WebDriverFactory {

    public static WebDriver getWebDriverInstance(BrowsersData browser) {
        switch (browser) {
            case Chrome:
                WebDriver driver = new ChromeDriver(getBaseChromeOptions());
                driver.manage().timeouts().implicitlyWait(
                        Long.parseLong(System.getProperty("webdriver.timeouts.implicitlywait")),
                        TimeUnit.MILLISECONDS);
                return driver;
            default:
                return null;
        }
    }

    private static ChromeOptions getBaseChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--no-first-run");
        chromeOptions.addArguments("--homepage=about:blank");
        chromeOptions.addArguments("--ignore-certificate-errors");
        return chromeOptions;
    }
}