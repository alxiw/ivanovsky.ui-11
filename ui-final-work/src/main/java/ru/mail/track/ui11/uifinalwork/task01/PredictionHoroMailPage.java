package ru.mail.track.ui11.uifinalwork.task01;

import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.Assert.assertTrue;

@UrlPattern("http[s]?://horo.mail.ru/prediction/[\\w_\\-]+/today/")
public class PredictionHoroMailPage extends PageObject<PredictionHoroMailPage> {

    private LocalDate date;

    private final String birthdaySelector = "//span[contains(text(), 'Прогноз')]/ancestor::span[contains(@class, 'link')]/following-sibling::span[contains(@class, 'link')]/span";
    private final String captionsSelector = "//div[contains(@class, 'cols')]//div[contains(@class, 'p-item')]//div[contains(@class, 'cell')]//div[contains(@class, 'gray')]";

    PredictionHoroMailPage(LocalDate date) {
        this.date = date;
        checkPageUrl();
    }

    public PredictionHoroMailPage checkBirthday() {
        String birthdayString = $(By.xpath(birthdaySelector)).getText().toLowerCase();
        boolean a = birthdayString.contains(date.getMonth().getDisplayName(TextStyle.FULL, new Locale("ru")).substring(0, 3).toLowerCase());
        boolean b = birthdayString.contains(String.valueOf(date.getDayOfMonth()));
        boolean c = birthdayString.contains(String.valueOf(date.getYear()));
        assertTrue("Заданная дата отсутствует на странице", a && b && c);
        return this;
    }

    public PredictionHoroMailPage checkCaptions(String... args) {
        List<String> arguments = new ArrayList(Arrays.asList(args));
        List<String> captions = $$(By.xpath(captionsSelector)).texts();
        assertTrue("Заданые заголовки отсутствует на странице", captions.stream().anyMatch(arguments::contains));
        return this;
    }
}
