package ru.mail.track.ui11.hw05.task02;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.mail.track.ui11.seleniumtestcore.data.BrowserFactory;
import ru.mail.track.ui11.seleniumtestcore.drivers.WebDriverFactory;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.TextStyle;
import java.util.Locale;

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
        LocalDate first = LocalDate.of(2015, Month.JUNE, 10);
        LocalDate second = LocalDate.of(Year.now().getValue(), Month.APRIL, 17);
        new CalendarPogodaMailPage(driver)
                .open("prognoz", "easter_island",
                        String.valueOf(first.getDayOfMonth()) + "-"
                                + String.valueOf(first.getMonth().getDisplayName(TextStyle.FULL, Locale.US)).toLowerCase(),
                        String.valueOf(first.getYear()))
                .openCalendar()
                .checkMonthInCalendar(Month.JUNE)
                .navigate(NavigateButton.PREV)
                .navigate(NavigateButton.PREV)
                .navigate(NavigateButton.PREV)
                .checkMonthInCalendar(Month.MARCH)
                .navigate(NavigateButton.NEXT)
                .checkMonthInCalendar(Month.APRIL)
                .goToDay(first.plusWeeks(1).getDayOfMonth())
                .checkDayInList(second);
    }
}
