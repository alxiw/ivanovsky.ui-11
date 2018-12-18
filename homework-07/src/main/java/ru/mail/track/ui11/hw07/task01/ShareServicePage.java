package ru.mail.track.ui11.hw07.task01;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.hw07.task01.enumeration.Service;

import static org.junit.Assert.assertTrue;

public class ShareServicePage extends PageObject<ShareServicePage> {

    private ArticleNewsMailPage page;
    private Service service;

    ShareServicePage(ArticleNewsMailPage page, Service service) {
        this.page = page;
        this.service = service;
    }

    public ArticleNewsMailPage closeShareWindow() {
        WebDriver a = Selenide.switchTo().window(1);
        Selenide.sleep(3000);
        assertTrue(a.getCurrentUrl().contains(service.toString().toLowerCase()));
        a.close();
        Selenide.switchTo().window(0);
        return page;
    }
}
