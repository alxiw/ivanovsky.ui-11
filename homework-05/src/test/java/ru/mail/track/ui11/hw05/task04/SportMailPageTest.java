package ru.mail.track.ui11.hw05.task04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.mail.track.ui11.seleniumtestcore.data.BrowserFactory;
import ru.mail.track.ui11.seleniumtestcore.drivers.WebDriverFactory;

public class SportMailPageTest {

    private WebDriver driver;

    @Before
    public void init() {
        driver = WebDriverFactory.getWebDriverInstance(BrowserFactory.getBrowser(System.getProperty("webdriver.driver")));
    }

    @After
    public void killSession() {
        driver.close();
        driver.quit();
    }

    @Test
    public void check_error_on_news_sport_page() {
        new SportMailPage(driver)
                .open()
                .checkAbsenceOfErrorTextOnPage();
        new NewsSportMailPage(driver)
                .open()
                .checkAbsenceOfErrorTextOnPage();
    }
}
