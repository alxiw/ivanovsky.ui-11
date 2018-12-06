package ru.mail.track.ui11.hw05.task05;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.mail.track.ui11.hw04.data.BrowserFactory;
import ru.mail.track.ui11.hw04.drivers.WebDriverFactory;

public class ArticlePetsMailPageTest {

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
    public void check_existence_of_publication_date() {
        new ArticlePetsMailPage(driver)
                .open()
                .pageShallBeOpened()
                .checkExistenceOfPublicationTime();
    }
}
