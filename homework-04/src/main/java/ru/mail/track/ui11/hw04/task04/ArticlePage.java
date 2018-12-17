package ru.mail.track.ui11.hw04.task04;

import org.openqa.selenium.WebDriver;
import ru.mail.track.ui11.seleniumtestcore.AbstractPage;
import ru.mail.track.ui11.seleniumtestcore.navigation.*;

@UrlPattern("(/[\\w_\\-\\.#]*)+")
@UrlParam({
    @Url(name = "articles", url = "/articles/%1"),
    @Url(name = "articles-economic", url = "/articles/economic/%1"),
    @Url(name = "prognoz", url = "/prognoz/%1/%2/#%3/%4")
})
@PageUrl("/articles")
@Domain("https://test.mail.ru")
public class ArticlePage extends AbstractPage<ArticlePage> {

    public ArticlePage(WebDriver driver) {
        super(driver);
    }
}
