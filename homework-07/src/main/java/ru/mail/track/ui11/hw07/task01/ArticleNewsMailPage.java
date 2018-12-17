package ru.mail.track.ui11.hw07.task01;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;
import ru.mail.track.ui11.hw07.task01.enumeration.Service;

import static com.codeborne.selenide.Selenide.$;

@UrlPattern("http[s]?://news.mail.ru/economics/\\d{1,10}/")
public class ArticleNewsMailPage extends PageObject<ArticleNewsMailPage> {

    private final String shareButtonSelectorFormat = "//div[@data-module='Shares.Total']/div[contains(@class, 'list')]/a//span[contains(text(), '%s')]";

    ArticleNewsMailPage() {
        checkPageUrl();
    }

    public ShareServicePage clickShareButton(Service service) {
        SelenideElement shareButton = $(By.xpath(String.format(shareButtonSelectorFormat, service.getName())));
        shareButton.click();
        return new ShareServicePage(this, service);
    }
}
