package ru.mail.track.ui11.uifinalwork.task04;

import io.qameta.allure.Step;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.Domain;
import ru.mail.track.ui11.selenidetestcore.navigation.PageUrl;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;
import ru.mail.track.ui11.uifinalwork.task04.components.Slider;

@UrlPattern("http[s]?://pets.mail.ru/")
@PageUrl("/")
@Domain("https://pets.mail.ru")
public class PetsMailPage extends PageObject<PetsMailPage> {

    @Step("Находим слайдер консультаций на странице")
    public Slider findSlider() {
        return new Slider();
    }
}
