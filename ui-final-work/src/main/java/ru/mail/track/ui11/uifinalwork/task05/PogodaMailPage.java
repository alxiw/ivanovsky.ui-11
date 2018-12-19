package ru.mail.track.ui11.uifinalwork.task05;

import com.codeborne.selenide.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.Domain;
import ru.mail.track.ui11.selenidetestcore.navigation.PageUrl;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

import static com.codeborne.selenide.Selenide.$$;

@UrlPattern("http[s]?://pogoda.mail.ru/(prognoz/[\\w_\\-]+/)?")
@PageUrl("/")
@Domain("https://pogoda.mail.ru")
public class PogodaMailPage extends PageObject<PogodaMailPage> {

    private final String newsItemSelector = "//*[2][@class='informer']//*[@class='informer__item']/a";

    @Step("Нажимаем плитку новости и запоминаем её заголовок")
    public ArticlePogodaMailPage clickAnyNewsItem() {
        ElementsCollection list = $$(By.xpath(newsItemSelector)).shouldBe(CollectionCondition.sizeGreaterThan(0));
        SelenideElement item = list.find(Condition.visible);
        String caption = item.getText();
        item.click();
        return new ArticlePogodaMailPage(caption);
    }
}
