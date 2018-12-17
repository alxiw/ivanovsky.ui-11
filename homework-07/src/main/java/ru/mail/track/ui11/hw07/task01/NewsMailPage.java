package ru.mail.track.ui11.hw07.task01;

import com.codeborne.selenide.ElementsCollection;
import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.Domain;
import ru.mail.track.ui11.selenidetestcore.navigation.PageUrl;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;
import ru.mail.track.ui11.hw07.task01.enumeration.Section;

import static com.codeborne.selenide.Selenide.$$;

@UrlPattern("http[s]?://news.mail.ru/")
@PageUrl("/")
@Domain("https://news.mail.ru")
public class NewsMailPage extends PageObject<NewsMailPage> {

    private final String newsListSelectorFormat = "//div[contains(@class, 'block')]//span[contains(text(), '%s')]/ancestor::div/following-sibling::ul//a";

    public ArticleNewsMailPage clickArticleInSection(Section section, int index) {
        ElementsCollection newsList = $$(By.xpath(String.format(newsListSelectorFormat, section.getName())));
        index = (index < 1 || index > newsList.size()) ? index - 1 : 0;
        newsList.get(index).click();
        return new ArticleNewsMailPage();
    }
}
