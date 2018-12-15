package ru.mail.track.ui11.hw05.task04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.seleniumtestcore.navigation.*;
import ru.mail.track.ui11.seleniumtestcore.AbstractPage;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;

@UrlPattern("/[\\w_\\-]+/[\\w_\\-]+/[\\d]{8}/")
@UrlParam({
        @Url(name = "news", url = "/news/%1/%2/")
})
@Domain("https://sportmail.ru")
public class NewsSportMailPage extends AbstractPage<NewsSportMailPage> {

    private final String error = "//div[contains(@class, 'error-page__container')]";

    public NewsSportMailPage(WebDriver driver) {
        super(driver);
    }

    public NewsSportMailPage checkAbsenceOfErrorTextOnPage() {
        assertTrue("Страница не найдена",
                standardWaiter.waitForCondition(
                        not(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(error)))));
        return this;
    }
}
