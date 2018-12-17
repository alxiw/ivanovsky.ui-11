package ru.mail.track.ui11.uifinalwork.task01;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.Domain;
import ru.mail.track.ui11.selenidetestcore.navigation.PageUrl;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.TextStyle;
import java.util.Locale;

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

    private final String dateSelector = "//*[@data-module='DateCustomSelects']//*[contains(@class, 'text')]";
    private final String buttonSelector = "//button//*[contains(text(), 'Показать все гороскопы')]";

    public HoroMailPage rememberTheDateOnThePage() {
        assertEquals("Неверный размер данных для получения даты", 3, $$(By.xpath(dateSelector)).texts().size());
        date = fetchDateFromCollection($$(By.xpath(dateSelector)));
        return this;
    }

    public PredictionHoroMailPage clickShowAllButton() {
        assertTrue("Кнопка недоступна", $(By.xpath(buttonSelector)).has(Condition.visible));
        $(By.xpath(buttonSelector)).click();
        return new PredictionHoroMailPage(date);
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
