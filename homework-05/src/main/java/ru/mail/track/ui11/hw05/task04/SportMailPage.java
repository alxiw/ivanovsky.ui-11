package ru.mail.track.ui11.hw05.task04;

import jdk.nashorn.internal.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.seleniumtestcore.navigation.Domain;
import ru.mail.track.ui11.seleniumtestcore.navigation.PageUrl;
import ru.mail.track.ui11.seleniumtestcore.navigation.UrlPattern;
import ru.mail.track.ui11.seleniumtestcore.AbstractPage;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;

@UrlPattern("/")
@PageUrl("/")
@Domain("https://sportmail.ru")
public class SportMailPage extends AbstractPage<SportMailPage> {

    private final String error = "//div[contains(@class, 'error-page__container')]";

    public SportMailPage(WebDriver driver) {
        super(driver);
    }

    public SportMailPage checkAbsenceOfErrorTextOnPage() {
        assertTrue("Страница не найдена",
                standardWaiter.waitForCondition(
                        not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(error)))));
        return this;
    }
}
