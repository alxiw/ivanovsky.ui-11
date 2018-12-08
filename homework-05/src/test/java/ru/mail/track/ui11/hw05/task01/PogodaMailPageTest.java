package ru.mail.track.ui11.hw05.task01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.mail.track.ui11.seleniumtestcore.data.BrowserFactory;
import ru.mail.track.ui11.seleniumtestcore.drivers.WebDriverFactory;

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
                .cityDropdownShallBeNotPresent()
                .moveCursorToCityButton()
                .cityDropdownShallBePresent()
                .typeSearchText("Берлин")
                .suggestShallBeEnabled()
                .pressFirstSuggestedCity()
                .pageWithForecastShouldBeOpen()
                .addCityToFavorites()
                .moveCursorToCityButton()
                .cityShouldBePresentedInDropdown();
    }
}
