package ru.mail.track.ui11.uifinalwork.task02;

import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

@UrlPattern("http[s]?://deti.mail.ru/[\\w_\\-]+/[\\w_\\-]+/.*")
public class ArticleDetiMailPage extends PageObject<ArticleDetiMailPage> {

    private String caption;

    private final String headerSelector = "//div[@data-module='BreadcrumbAdmin']/following-sibling::*//h1";

    ArticleDetiMailPage(String caption) {
        checkPageUrl();
        this.caption = caption;
    }

    public ArticleDetiMailPage checkHeader() {
        assertTrue($(By.xpath(headerSelector)).getText().contains(caption));
        return this;
    }
}
