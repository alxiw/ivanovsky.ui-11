package ru.mail.track.ui11.hw04.pages;

import org.openqa.selenium.WebDriver;
import ru.mail.track.ui11.hw04.log.TestLogger;
import ru.mail.track.ui11.hw04.navigation.Domain;
import ru.mail.track.ui11.hw04.navigation.PageUrl;
import ru.mail.track.ui11.hw04.navigation.Url;
import ru.mail.track.ui11.hw04.navigation.UrlParam;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

@Domain("https://test.mail.ru")
@PageUrl("/articles")
@UrlParam({
    @Url(name = "articles", url = "/articles/%1"),
    @Url(name = "articles-economic", url = "/articles/economic/%1")
})
public class ArticlePage extends AbstractPage<ArticlePage> {

    public ArticlePage(WebDriver driver) {
        super(driver);
    }

    public ArticlePage checkPageUrl() {
        TestLogger.log("Check address of opened page");
        Pattern pattern = Pattern.compile(getDomain() + "(/[\\w-\\.]*)+");
        Matcher matcher = pattern.matcher(driver.getCurrentUrl());
        assertTrue(String.format("Должна быть открыта страница, содержащая в URL %s",
                getPageUrl()), matcher.find());
        return this;
    }
}
