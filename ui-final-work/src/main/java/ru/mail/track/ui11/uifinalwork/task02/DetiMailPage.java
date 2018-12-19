package ru.mail.track.ui11.uifinalwork.task02;

import io.qameta.allure.Step;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.Domain;
import ru.mail.track.ui11.selenidetestcore.navigation.PageUrl;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;
import ru.mail.track.ui11.uifinalwork.task02.components.SmartBand;

@UrlPattern("http[s]?://deti.mail.ru/")
@PageUrl("/")
@Domain("https://deti.mail.ru")
public class DetiMailPage extends PageObject<DetiMailPage> {

    @Step("Находим умную ленту на странице")
    public SmartBand findSmartBand() {
        return new SmartBand();
    }
}
