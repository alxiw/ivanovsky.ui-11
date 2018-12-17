package ru.mail.track.ui11.hw07.task02;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.Assert.assertTrue;

@UrlPattern("http[s]?://sport[\\.]?mail.ru/news/[\\w_\\-]+/\\d{1,10}/")
public class ArticleSportMailPage extends PageObject<ArticleSportMailPage> {

    private final String textSelector = "//div[contains(@data-module, 'FoundMistake')]//div[contains(@class, 'article')]/p";
    private final String closeButtonOnPopupSelectorFromPopup = "//div[contains(@class, 'popup')]//span[contains(@class, 'close')]";
    private final String popupSelector = "//div[contains(@class, 'popup_narrow')]";

    ArticleSportMailPage() {
        checkPageUrl();
    }

    public ArticleSportMailPage selectText() {
        Selenide.actions()
                .moveToElement($$(By.xpath(textSelector)).first().hover(), 1, 1)
                .clickAndHold().moveByOffset(40, 10)
                .release()
                .perform();
        return this;
    }

    public ArticleSportMailPage pressControlAndEnter() {
        Selenide.actions().sendKeys(Keys.chord(Keys.CONTROL, Keys.ENTER)).build().perform();
        return this;
    }

    public ArticleSportMailPage closePopup() {
        $(By.xpath(closeButtonOnPopupSelectorFromPopup)).click();
        return this;
    }

    public ArticleSportMailPage checkThatPopupIsClosed() {
        SelenideElement element = $(By.xpath(popupSelector));
        assertTrue("Выпадающее окно не закрыто", element.waitUntil(Condition.hidden, 2000).exists());
        return this;
    }
}
