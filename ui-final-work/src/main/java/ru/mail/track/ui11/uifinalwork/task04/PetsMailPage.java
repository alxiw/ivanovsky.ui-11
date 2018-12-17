package ru.mail.track.ui11.uifinalwork.task04;

import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.Domain;
import ru.mail.track.ui11.selenidetestcore.navigation.PageUrl;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

import static com.codeborne.selenide.Selenide.$$;

@UrlPattern("http[s]?://pets.mail.ru/")
@PageUrl("/")
@Domain("https://pets.mail.ru")
public class PetsMailPage extends PageObject<PetsMailPage> {

    private final String consultantSelector = "//*[contains(@class, 'selected')]//*[contains(@class, 'consultant')]/a";

    public ConsultantPetsMailPage clickAnyConsultantOnThePage() {
        ElementsCollection list = $$(By.xpath(consultantSelector)).shouldBe(CollectionCondition.sizeGreaterThan(0));
        SelenideElement item = list.find(Condition.visible);
        String caption = item.getText();
        item.click();
        return new ConsultantPetsMailPage(caption);
    }
}
