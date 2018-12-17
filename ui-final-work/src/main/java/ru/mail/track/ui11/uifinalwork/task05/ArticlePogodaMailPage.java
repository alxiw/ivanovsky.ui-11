package ru.mail.track.ui11.uifinalwork.task05;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

@UrlPattern("http[s]?://[\\w_-]+.mail.ru/[\\w_-]+/[\\w_-]+/")
public class ArticlePogodaMailPage extends PageObject<ArticlePogodaMailPage> {

    private String caption;

    public ArticlePogodaMailPage(String caption) {
        checkPageUrl();
        this.caption = caption;
    }

    public ArticlePogodaMailPage closeArticleWindow() {
        WebDriver a = Selenide.switchTo().window(1);
        Selenide.sleep(3000);
        assertTrue(a.getCurrentUrl().contains("mail"));
        $("h1").shouldBe(text(caption));
        a.close();
        Selenide.switchTo().window(0);
        return this;
    }
}
