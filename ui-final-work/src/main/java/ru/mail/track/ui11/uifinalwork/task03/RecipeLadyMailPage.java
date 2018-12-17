package ru.mail.track.ui11.uifinalwork.task03;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.Domain;
import ru.mail.track.ui11.selenidetestcore.navigation.PageUrl;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

import static com.codeborne.selenide.Selenide.$;

@UrlPattern("http[s]?://lady.mail.ru/[\\w_\\-]+/[\\w_\\-]+/[\\w_\\-]+/")
@PageUrl("/recipe/week/rating/")
@Domain("https://lady.mail.ru/")
public class RecipeLadyMailPage extends PageObject<RecipeLadyMailPage> {

    private final String popButtonSelector = "//span[contains(text(), 'популярные')]/ancestor::a";
    private final String newButtonSelector = "//span[contains(text(), 'новые')]/ancestor::a";

    public RecipeLadyMailPage checkPopViewIsActive() {
        $(By.xpath(popButtonSelector)).waitUntil(Condition.attribute("class", "filter__item filter__item_active"), 1000);
        return this;
    }

    public RecipeLadyMailPage clickNewButton() {
        $(By.xpath(newButtonSelector)).click();
        return this;
    }

    public RecipeLadyMailPage checkNewViewIsActive() {
        $(By.xpath(newButtonSelector)).waitUntil(Condition.attribute("class", "filter__item filter__item_active"), 1000);
        return this;
    }

    public RecipeLadyMailPage clickPopButton() {
        $(By.xpath(popButtonSelector)).click();
        return this;
    }
}
