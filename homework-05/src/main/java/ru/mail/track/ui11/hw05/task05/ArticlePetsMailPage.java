package ru.mail.track.ui11.hw05.task05;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.hw04.navigation.Domain;
import ru.mail.track.ui11.hw04.navigation.PageUrl;
import ru.mail.track.ui11.hw04.navigation.UrlPattern;
import ru.mail.track.ui11.hw04.pages.AbstractPage;

import static org.junit.Assert.assertTrue;

@UrlPattern("/how-to/.*")
@PageUrl("/how-to/nyanya-dlya-sobak-i-koshek-kak-podgotovitsya-k-raz/")
@Domain("https://pets.mail.ru")
public class ArticlePetsMailPage extends AbstractPage<ArticlePetsMailPage> {

    @FindBy(xpath = "//time")
    private WebElement time;

    public ArticlePetsMailPage(WebDriver driver) {
        super(driver);
    }

    public ArticlePetsMailPage checkExistenceOfPublicationTime(){
        assertTrue("Дата публикации не отображается",
                standardWaiter.waitForCondition((
                        ExpectedConditions.visibilityOf(time))));
        return this;
    }
}
