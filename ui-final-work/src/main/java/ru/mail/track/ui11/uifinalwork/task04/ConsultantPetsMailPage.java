package ru.mail.track.ui11.uifinalwork.task04;

import io.qameta.allure.Step;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

@UrlPattern("http[s]?://pets.mail.ru/[\\w_\\-]+/[\\w_\\-]+/[\\w_\\-]+/\\d{1,3}/")
public class ConsultantPetsMailPage extends PageObject<ConsultantPetsMailPage> {

    private String name;

    public ConsultantPetsMailPage(String name) {
        checkPageUrl();
        this.name = name;
    }

    @Step("Проверяем имя консультанта")
    public ConsultantPetsMailPage checkConsultantName() {
        checkPageHeader(name);
        return this;
    }
}
