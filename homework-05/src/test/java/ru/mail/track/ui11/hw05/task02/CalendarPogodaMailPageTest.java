package ru.mail.track.ui11.hw05.task02;

import org.junit.Test;
import ru.mail.track.ui11.hw05.BaseTest;
import ru.mail.track.ui11.hw05.task02.enumeration.NavigateButton;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

public class CalendarPogodaMailPageTest extends BaseTest {

    @Test
    public void check_selecting_date_in_calendar() {
        LocalDate first = LocalDate.of(2015, Month.JUNE, 10);
        LocalDate second = LocalDate.of(Year.now().getValue(), Month.APRIL, 17);
        new CalendarPogodaMailPage(driver)
                .open("prognoz", "easter_island", first)
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
