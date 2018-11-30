package ru.mail.track.ui11.hw04.pages;

import org.openqa.selenium.WebDriver;
import ru.mail.track.ui11.hw04.navigation.*;

@Domain("https://test.mail.ru")
@PageUrl("/articles")
@UrlParam({
    @Url(name = "articles", url = "/articles/%1"),
    @Url(name = "articles-economic", url = "/articles/economic/%1")
})
@UrlPattern("(/[\\w-\\.]*)+")
public class ArticlePage extends AbstractPage<ArticlePage> {

    public ArticlePage(WebDriver driver) {
        super(driver);
    }
}
