package ru.mail.track.ui11.uifinalwork.task05;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

@UrlPattern("http[s]?://(?!pogoda)[\\w_\\-]+.mail.ru/[\\w_\\-]+/[\\w_\\-]+/")
public class ArticlePogodaMailPage extends PageObject<ArticlePogodaMailPage> {

    private String caption;

    private WebDriver helper;

    public ArticlePogodaMailPage(String caption) {
        this.caption = caption;
    }

    @Step("Проверяем заголовок новости и адрес её страницы")
    public ArticlePogodaMailPage checkAndCloseArticleWindow() {
        try {
            helper = Selenide.switchTo().window(1);
        } catch (NoSuchWindowException e) {
            Selenide.close();
        }
        checkPageHeader(caption);
        checkPageUrl();
        try {
            Selenide.switchTo().window(0);
            helper.close();
        } catch (NoSuchWindowException e) {
            Selenide.close();
        }
        return this;
    }
}
