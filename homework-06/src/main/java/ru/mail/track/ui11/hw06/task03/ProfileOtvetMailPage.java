package ru.mail.track.ui11.hw06.task03;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertEquals;

@UrlPattern("http[s]?://otvet.mail.ru/profile/id\\d{1,10}/")
public class ProfileOtvetMailPage extends PageObject<ProfileOtvetMailPage> {

    private String name;

    private final String nameSelectorFormat = "//div[contains(text(), '%s')]";

    ProfileOtvetMailPage(String name) {
        this.name = name;
        checkPageUrl();
    }

    @Step("Проверяем отображение имени пользователя на странице")
    public ProfileOtvetMailPage checkTheUsernamePresentedOnThePage() {
        assertEquals($(By.xpath(String.format(nameSelectorFormat, name))).getText(), name);
        return this;
    }
}
