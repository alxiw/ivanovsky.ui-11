package ru.mail.track.ui11.hw05.task02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.hw05.task02.enumeration.NavigateButton;
import ru.mail.track.ui11.seleniumtestcore.navigation.*;
import ru.mail.track.ui11.seleniumtestcore.AbstractPage;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@UrlPattern("/prognoz/[\\w_\\-]{1,40}/[\\d]{1,2}-[\\w_-]{1,10}/#[\\d]{4}")
@UrlParam({
        @Url(name = "prognoz", url = "/prognoz/%1/%2/#%3")
})
@Domain("https://pogoda.mail.ru")
public class CalendarPogodaMailPage extends AbstractPage<CalendarPogodaMailPage> {

    @FindBy(xpath = "//*[text()='Календарь погоды']")
    private WebElement calendar;

    @FindBy(xpath = "//*[contains(@class, 'block')]//div[contains(@class, 'heading')]")
    private List<WebElement> dayHeaders;

    private final String monthSelector = "//*[@class='calendar-popup']//*[contains(@class, 'calendar__month')]";
    private final String navigateButtonLocatorFormat = "//span[contains(@class, 'calendar__control_%s')]";
    private final String dayInMonthSelectorFormat = "//table[contains(@class, 'calendar')]//a[text() = '%d']";

    public CalendarPogodaMailPage(WebDriver driver) {
        super(driver);
    }

    public CalendarPogodaMailPage open(String prognoz, String place, LocalDate date) {
        super.open(prognoz, place, String.valueOf(date.getDayOfMonth()) + "-"
                        + String.valueOf(date.getMonth().getDisplayName(TextStyle.FULL, Locale.US)).toLowerCase(),
                String.valueOf(date.getYear()));
        return this;
    }

    public CalendarPogodaMailPage openCalendar() {
        assertTrue("Невозможно открыть календарь на странице",
                standardWaiter.waitForCondition(ExpectedConditions
                        .elementToBeClickable(calendar)));
        calendar.click();
        return this;
    }

    public CalendarPogodaMailPage checkMonthInCalendar(Month month) {
        String expected = month.getDisplayName(TextStyle.FULL, new Locale("ru")).substring(0, 3).toUpperCase();
        String actual = driver.findElement(By.xpath(monthSelector)).getText().substring(0, 3).toUpperCase();
        assertEquals("Неверный месяц в календаре", expected, actual);
        return this;
    }

    public CalendarPogodaMailPage navigate(NavigateButton button) {
        WebElement navigateButton = driver.findElement(By.xpath(String.format(navigateButtonLocatorFormat, button.getName().toLowerCase())));
        assertTrue("Навигация в календаре по месяцам недоступна",
                standardWaiter.waitForCondition(ExpectedConditions
                        .elementToBeClickable(navigateButton)));
        navigateButton.click();
        return this;
    }

    public CalendarPogodaMailPage goToDay(int day) {
        WebElement dayInCalendar = driver.findElement(By.xpath(String.format(dayInMonthSelectorFormat, day)));
        assertTrue("Навигация в календаре по дням месяца недоступна",
                standardWaiter.waitForCondition(ExpectedConditions
                        .elementToBeClickable(dayInCalendar)));
        dayInCalendar.click();
        return this;
    }

    public CalendarPogodaMailPage checkDayInList(LocalDate date) {
        String month = date.getMonth().getDisplayName(TextStyle.FULL, new Locale("ru")).substring(0, 3).toUpperCase();
        String regex = String.format("^%d\\s%s.+\\s\\d{4}$", date.getDayOfMonth(), month);
        assertTrue("Несовпадение даты в списке",
                        dayHeaders.stream().map(WebElement::getText)
                                .allMatch(elem -> elem.matches(regex)));
        return this;
    }
}
