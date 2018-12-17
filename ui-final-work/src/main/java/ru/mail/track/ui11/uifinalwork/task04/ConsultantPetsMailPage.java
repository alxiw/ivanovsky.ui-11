package ru.mail.track.ui11.uifinalwork.task04;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

@UrlPattern("http[s]?://pets.mail.ru/[\\w_\\-]+/[\\w_\\-]+/[\\w_\\-]+/\\d{1,3}/")
public class ConsultantPetsMailPage extends PageObject<ConsultantPetsMailPage> {

    private String caption;

    private final String headerSelector = "//h1";

    public ConsultantPetsMailPage(String caption) {
        checkPageUrl();
        this.caption = caption;
    }

    public ConsultantPetsMailPage checkHeader() {
        assertTrue("Имя консультанта отсутствует на странице", $(By.xpath(headerSelector)).shouldBe(Condition.visible).getText().contains(caption));
        return this;
    }
}
