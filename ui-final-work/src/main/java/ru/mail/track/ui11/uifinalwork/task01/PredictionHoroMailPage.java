package ru.mail.track.ui11.uifinalwork.task01;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;
import ru.mail.track.ui11.uifinalwork.task01.date.MonthDayInterval;

import java.time.LocalDate;
import java.time.MonthDay;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@UrlPattern("http[s]?://horo.mail.ru/prediction/[\\w_\\-]+/today/")
public class PredictionHoroMailPage extends PageObject<PredictionHoroMailPage> {

    private LocalDate date;
    private Map<String, MonthDayInterval> signs;

    private final String birthdaySelector = "//span[contains(text(), 'Дата рождения')]";
    private final String titlesSelector = "//div[@class='cell']//div[contains(@class, 'gray')]";

    PredictionHoroMailPage(LocalDate date, Map signs) {
        this.date = date;
        this.signs = signs;
        checkPageUrl();
    }

    @Step("Проверяем соответствие даты рождения с указанной ранее")
    public PredictionHoroMailPage checkBirthday() {
        String birthdayString = $(By.xpath(birthdaySelector)).getText()
                .toLowerCase()
                .replace("дата рождения:", "")
                .replace("г.", "")
                .trim();
        LocalDate newDate = LocalDate.parse(birthdayString, DateTimeFormatter.ofPattern("d MMMM yyyy", new Locale("ru")));
        assertEquals("Дата рождения не совпадает с заданной", date, newDate);
        return this;
    }

    @Step("Проверяем соответствие знака зодиака с датой рождения")
    public PredictionHoroMailPage checkSign() {
        String sign = getPageHeader()
                .toLowerCase()
                .replace("гороскоп на сегодня:", "")
                .trim();
        MonthDay md = MonthDay.of(date.getMonth(), date.getDayOfMonth());
        boolean check = false;
        for (Map.Entry<String, MonthDayInterval> entry : signs.entrySet()) {
            if (entry.getKey().equals(sign) && entry.getValue().isMonthDayBelongToTheInterval(md)) {
                check = true;
                break;
            }
        }
        assertTrue("Знак зодиака не совпадает", check);
        return this;
    }

    @Step("Проверяем наличие заголовков статей на странице")
    public PredictionHoroMailPage checkTitles(String... args) {
        List<String> arguments = new ArrayList(Arrays.asList(args));
        List<String> captions = $$(By.xpath(titlesSelector)).texts();
        assertTrue("Заголовки статей отсутствует на странице", captions.stream().anyMatch(arguments::contains));
        return this;
    }
}
