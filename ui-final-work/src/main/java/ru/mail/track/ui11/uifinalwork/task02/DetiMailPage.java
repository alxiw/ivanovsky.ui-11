package ru.mail.track.ui11.uifinalwork.task02;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.Domain;
import ru.mail.track.ui11.selenidetestcore.navigation.PageUrl;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

import static com.codeborne.selenide.Selenide.$$;

@UrlPattern("http[s]?://deti.mail.ru/")
@PageUrl("/")
@Domain("https://deti.mail.ru")
public class DetiMailPage extends PageObject<DetiMailPage> {

    private final String newsSelector = "//*[text()='Новости']/ancestor::*[contains(@class, 'inner')]/following-sibling::*/span";

    public ArticleDetiMailPage clickNewsItem(int index) {
        ElementsCollection list = $$(By.xpath(newsSelector)).shouldBe(CollectionCondition.sizeGreaterThan(0));
        index = (index < 1 || index > list.size()) ? index - 1 : 0;
        SelenideElement item = list.get(index).shouldBe(Condition.visible);
        String caption = item.getText();
        item.click();
        return new ArticleDetiMailPage(caption);
    }
}
