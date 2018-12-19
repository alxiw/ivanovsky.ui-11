package ru.mail.track.ui11.uifinalwork.task01;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.Domain;
import ru.mail.track.ui11.selenidetestcore.navigation.PageUrl;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;
import ru.mail.track.ui11.uifinalwork.task01.date.MonthDayInterval;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@UrlPattern("http[s]?://horo.mail.ru/")
@PageUrl("/")
@Domain("https://horo.mail.ru")
public class HoroMailPage extends PageObject<HoroMailPage> {

    private LocalDate date;

    private final String signsDatesSelector = "//a[contains(@class, 'imaged-item')]/span[contains(@class, 'date')]";
    private final String dateSelector = "//*[@data-module='DateCustomSelects']//*[contains(@class, 'text')]";
    private final String buttonSelector = "//button//*[contains(text(), 'Показать все гороскопы')]";

    private Map<String, MonthDayInterval> signs = new HashMap<>();

    @Step("Получаем набор знаков зодиака с соответствующими интервалами времени")
    public HoroMailPage parseSigns() {
        ElementsCollection datesRaw = $$(By.xpath(signsDatesSelector));
        for (SelenideElement element : datesRaw) {
            String name = element.$(By.xpath("preceding-sibling::span[contains(@class, 'name')]"))
                    .getText()
                    .toLowerCase();
            String[] pair = element.getText().split(" — ");
            MonthDay one = MonthDay.parse(pair[0], DateTimeFormatter.ofPattern("d MMMM", new Locale("ru")));
            MonthDay two = MonthDay.parse(pair[1], DateTimeFormatter.ofPattern("d MMMM", new Locale("ru")));
            MonthDayInterval interval = new MonthDayInterval(one, two);
            signs.put(name, interval);
        }
        return this;
    }

    @Step("Запоминаем указанную дату рождения на странице")
    public HoroMailPage rememberTheDateOnThePage() {
        assertEquals("Дата рождения считана неверно", 3, $$(By.xpath(dateSelector)).texts().size());
        date = fetchDateFromCollection($$(By.xpath(dateSelector)));
        return this;
    }

    @Step("Нажимаем кнопку для показа информации по знаку зодиака")
    public PredictionHoroMailPage clickShowButton() {
        assertTrue("Кнопка показа недоступна", $(By.xpath(buttonSelector)).has(Condition.visible));
        $(By.xpath(buttonSelector)).click();
        return new PredictionHoroMailPage(date, signs);
    }

    private LocalDate fetchDateFromCollection(ElementsCollection raw) {
        Month month = null;
        String monthRaw = raw.get(1).getText();
        for (Month m : Month.values()) {
            if (monthRaw.startsWith(m.getDisplayName(TextStyle.FULL, new Locale("ru")).substring(0, 3).toLowerCase())) {
                month = m;
                break;
            }
        }
        assertNotNull("Не удалось верно определить месяц", month);
        return LocalDate.of(Integer.parseInt(raw.get(2).getText()), month, Integer.parseInt(raw.get(0).getText()));
    }
}
