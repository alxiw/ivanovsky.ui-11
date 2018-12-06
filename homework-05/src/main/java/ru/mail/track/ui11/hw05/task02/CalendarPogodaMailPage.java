package ru.mail.track.ui11.hw05.task02;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.mail.track.ui11.hw04.navigation.Domain;
import ru.mail.track.ui11.hw04.navigation.PageUrl;
import ru.mail.track.ui11.hw04.navigation.UrlPattern;
import ru.mail.track.ui11.hw04.pages.AbstractPage;

import java.util.List;

@UrlPattern("/prognoz/easter_island/[\\d]{1,2}-[\\w]{1,10}/#[\\d]{4}")
@PageUrl("/prognoz/easter_island/10-june/#2015")
@Domain("https://pogoda.mail.ru")
public class CalendarPogodaMailPage extends AbstractPage<CalendarPogodaMailPage> {

    @FindBy(xpath = "//div[contains(text(), 'Календарь')]")
    private WebElement calendar;

    @FindBy(xpath = "//span[contains(@class, 'calendar__month')]")
    private WebElement calendarMonth;

    @FindBy(xpath = "//span[contains(@class, 'calendar__control_prev')]")
    private WebElement prevMonth;

    @FindBy(xpath = "//span[contains(@class, 'calendar__control_next')]")
    private WebElement nextMonth;

    @FindBy(xpath = "//div[contains(@class, 'heading heading_minor heading_line')]")
    private List<WebElement> daysHeaders;

    public CalendarPogodaMailPage(WebDriver driver) {
        super(driver);
    }

    public CalendarPogodaMailPage openCalendar() {
        calendar.click();
        return this;
    }

    public CalendarPogodaMailPage checkMonthInCalendar(String month) {
        Assert.assertEquals("Неверный месяц в календаре", month, calendarMonth.getText());
        return this;
    }

    public CalendarPogodaMailPage goToPrevMonth() {
        prevMonth.click();
        return this;
    }

    public CalendarPogodaMailPage goToNextMonth() {
        nextMonth.click();
        return this;
    }

    public CalendarPogodaMailPage goToDay(int day) {
        driver.findElement(By.xpath("//table[contains(@class, 'calendar')]//a[text() = '" + day + "']")).click();
        return this;
    }

    public CalendarPogodaMailPage checkDayInList(String month, int day) {
        String firstThreeLettersOfMonthName = month.substring(0, 3).toUpperCase();
        String regex = day + "\\s" + firstThreeLettersOfMonthName + "\\W*\\s\\d{4}";
        Assert.assertTrue("Несовпадение месяца в календаре и списке",
                        daysHeaders.stream()
                                .map(WebElement::getText)
                                .allMatch(elem -> elem.matches(regex)));
        return this;
    }



}
