package ru.mail.track.ui11.hw07.task02;

import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.Domain;
import ru.mail.track.ui11.selenidetestcore.navigation.PageUrl;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

import static com.codeborne.selenide.Selenide.$;

@UrlPattern("http[s]?://sport[\\.]?mail.ru/")
@PageUrl("/")
@Domain("https://sport.mail.ru")
public class SportMailPage extends PageObject<SportMailPage> {

    private final String mainArticleSelector = "//div[contains(@data-module, 'TrackBlocks')]//td[contains(@class, 'main')]//a";

    public ArticleSportMailPage clickMainArticleOnThePage() {
        $(By.xpath(mainArticleSelector)).click();
        return new ArticleSportMailPage();
    }
}
