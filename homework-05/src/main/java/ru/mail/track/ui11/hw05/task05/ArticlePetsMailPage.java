package ru.mail.track.ui11.hw05.task05;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.seleniumtestcore.navigation.Domain;
import ru.mail.track.ui11.seleniumtestcore.navigation.PageUrl;
import ru.mail.track.ui11.seleniumtestcore.navigation.UrlPattern;
import ru.mail.track.ui11.seleniumtestcore.AbstractPage;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

@UrlPattern("/how-to/[\\w_\\-]+/")
@PageUrl("/how-to/nyanya-dlya-sobak-i-koshek-kak-podgotovitsya-k-raz/")
@Domain("https://pets.mail.ru")
public class ArticlePetsMailPage extends AbstractPage<ArticlePetsMailPage> {

    @FindBy(xpath = "//time")
    private WebElement time;

    public ArticlePetsMailPage(WebDriver driver) {
        super(driver);
    }

    public ArticlePetsMailPage checkExistenceOfPublicationTime(){
        Pattern p = Pattern.compile("^\\d{1,2}\\s.+\\s\\d{4}$");
        Matcher m = p.matcher(time.getText());
        assertTrue("Дата публикации не отображается",
                standardWaiter.waitForCondition((
                        ExpectedConditions.visibilityOf(time))) && m.find());
        return this;
    }
}
