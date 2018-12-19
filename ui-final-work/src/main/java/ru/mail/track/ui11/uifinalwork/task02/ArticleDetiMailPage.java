package ru.mail.track.ui11.uifinalwork.task02;

import io.qameta.allure.Step;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

@UrlPattern("http[s]?://deti.mail.ru/[\\w_\\-]+/[\\w_\\-]+/\\?from=smartlenta")
public class ArticleDetiMailPage extends PageObject<ArticleDetiMailPage> {

    private String caption;

    public ArticleDetiMailPage(String caption) {
        checkPageUrl();
        this.caption = caption;
    }

    @Step("Проверяем заголовок новости")
    public ArticleDetiMailPage checkHeader() {
        checkPageHeader(caption);
        return this;
    }
}
