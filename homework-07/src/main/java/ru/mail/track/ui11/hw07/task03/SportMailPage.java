package ru.mail.track.ui11.hw07.task03;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.Domain;
import ru.mail.track.ui11.selenidetestcore.navigation.PageUrl;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

@UrlPattern("http[s]?://sport[\\.]?mail.ru/")
@PageUrl("/")
@Domain("https://sport.mail.ru")
public class SportMailPage extends PageObject<SportMailPage> {

    private final String inputFieldSelector = "//input[@name='q']";
    private final String loupeSelector = "//span[contains(@class, 'pm-toolbar')]//span[@bem-id='353']//span[contains(@class, 'search')]/ancestor::span[@role='button']";
    private final String searchButtonSelector = "//input[@name='q']/ancestor::span[@bem-id='375']/following-sibling::span";

    public SportMailPage clickSearchButton() {
        assertTrue("Поле ввода присутствует на странице", $(By.xpath(inputFieldSelector)).has(Condition.hidden));
        $(By.xpath(loupeSelector)).shouldBe(Condition.not(Condition.disabled)).click();
        return this;
    }

    public SportMailPage clickYellowSearchButton() {
        assertTrue("Кнопка поиска не присутствует на странице", $(By.xpath(inputFieldSelector)).waitUntil(Condition.visible, 1000).exists());
        $(By.xpath(searchButtonSelector)).waitUntil(Condition.enabled, 1000).click();
        return this;
    }

    public SportMailPage checkThatPageRemainsTheSameWithoutRefreshing() {
        checkPageUrl();
        assertTrue("Поле ввода не присутствует на странице", $(By.xpath(inputFieldSelector)).has(Condition.visible));
        assertTrue("Кнопка поиска не присутствует на странице", $(By.xpath(searchButtonSelector)).has(Condition.not(Condition.disabled)));
        assertTrue("Лупа присутствует на странице", $(By.xpath(loupeSelector)).has(Condition.attribute("aria-disabled", "true")));
        return this;
    }
}