package ru.mail.track.ui11.hw05.task02;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.mail.track.ui11.seleniumtestcore.navigation.*;
import ru.mail.track.ui11.seleniumtestcore.AbstractPage;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.List;
import java.util.Locale;

@UrlPattern("/prognoz/[\\w_\\-]{1,40}/[\\d]{1,2}-[\\w_-]{1,10}/#[\\d]{4}")
@UrlParam({
        @Url(name = "prognoz", url = "/prognoz/%1/%2/#%3")
})
@Domain("https://pogoda.mail.ru")
public class CalendarPogodaMailPage extends AbstractPage<CalendarPogodaMailPage> {

    @FindBy(xpath = "//div[contains(text(), 'Календарь погоды')]")
    private WebElement calendar;

    @FindBy(xpath = "//div[contains(@class, 'block')]/following-sibling::div[contains(@class, 'block')]//div[contains(@class, 'heading')]")
    private List<WebElement> daysHeaders;

    private final String monthPath = "//div[contains(@class, 'calendar-popup')]//span[contains(@class, 'calendar__month')]";

    public CalendarPogodaMailPage(WebDriver driver) {
        super(driver);
    }

    public CalendarPogodaMailPage openCalendar() {
        calendar.click();
        return this;
    }

    public CalendarPogodaMailPage checkMonthInCalendar(Month month) {
        WebElement monthElement = driver.findElement(By.xpath(monthPath));
        String expected = month.getDisplayName(TextStyle.FULL, new Locale("ru")).substring(0, 3).toUpperCase();
        String actual = monthElement.getText().substring(0, 3).toUpperCase();
        Assert.assertEquals("Неверный месяц в календаре", expected, actual);
        return this;
    }

    public CalendarPogodaMailPage navigate(NavigateButton button) {
        String pathToNavigateButton = String.format("//span[contains(@class, 'calendar__control_%s')]", button.getName().toLowerCase());
        driver.findElement(By.xpath(pathToNavigateButton)).click();
        return this;
    }

    public CalendarPogodaMailPage goToDay(int day) {
        driver.findElement(By.xpath(String.format("//table[contains(@class, 'calendar')]//a[text() = '%d']", day))).click();
        return this;
    }

    public CalendarPogodaMailPage checkDayInList(LocalDate date) {
        String month = date.getMonth().getDisplayName(TextStyle.FULL, new Locale("ru")).substring(0, 3).toUpperCase();
        String regex = String.format("^%d\\s%s.+\\s\\d{4}$", date.getDayOfMonth(), month);
        Assert.assertTrue("Несовпадение даты в списке",
                        daysHeaders.stream().map(WebElement::getText)
                                .allMatch(elem -> elem.matches(regex)));
        return this;
    }
}
