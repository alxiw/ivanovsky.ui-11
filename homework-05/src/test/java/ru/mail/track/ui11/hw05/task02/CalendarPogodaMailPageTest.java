package ru.mail.track.ui11.hw05.task02;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.mail.track.ui11.hw04.data.BrowserFactory;
import ru.mail.track.ui11.hw04.drivers.WebDriverFactory;

public class CalendarPogodaMailPageTest {

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
    public void choose_date_in_calendar() {
        new CalendarPogodaMailPage(driver)
                .open()
                .pageShallBeOpened()
                .openCalendar()
                .checkMonthInCalendar("Июнь")
                .goToPrevMonth()
                .checkMonthInCalendar("Май")
                .goToNextMonth()
                .checkMonthInCalendar("Июнь")
                .goToDay(11)
                .checkDayInList("Июнь", 11);
    }
}
