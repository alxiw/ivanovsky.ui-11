package ru.mail.track.ui11.hw05.task01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.mail.track.ui11.hw04.data.BrowserFactory;
import ru.mail.track.ui11.hw04.drivers.WebDriverFactory;

public class PogodaMailPageTest {

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
    public void add_city_in_favorites() {
        new PogodaMailPage(driver)
                .open()
                .pageShallBeOpened()
                .cityDropdownShouldBeNotPresent()
                .moveCursorToCityButton()
                .cityDropdownShouldBeNotPresent()
                .typeSearchText("Киев")
                .suggestShouldBeEnabled()
                .pressCity()
                .pageWithForecastShouldBeOpen()
                .addCityToFavorites()
                .moveCursorToCityButton()
                .cityShouldBePresented();
    }
}
