package ru.mail.track.ui11.hw06.task03;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.Domain;
import ru.mail.track.ui11.selenidetestcore.navigation.PageUrl;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.Assert.assertTrue;

@UrlPattern("http[s]?://otvet.mail.ru/open/")
@PageUrl("/open/")
@Domain("https://otvet.mail.ru")
public class OpenOtvetMailPage extends PageObject<OpenOtvetMailPage> {

    private String name;

    private final String usernameSelectorFromPopup = "//a[contains(@class, 'nick')]";

    private ElementsCollection userpicsSelector = $$(By.xpath("//*[@class='pageQuestions']//*[contains(@class, 'avatar')]"));
    private SelenideElement popupSelector = $(By.xpath("//div[contains(@class, 't-ava user')]"));

    @Step("Передвигаем курсор на изображение пользователя")
    public OpenOtvetMailPage moveToUserpic(int index) {
        index = (index < 1 || index > userpicsSelector.size()) ? index - 1 : 0;
        userpicsSelector.get(index).hover();
        return this;
    }

    @Step("Сохраняем имя пользователя")
    public OpenOtvetMailPage rememberUsername() {
        assertTrue(!popupSelector.waitUntil(Condition.visible, 3000).getAttribute("class").contains("hide"));
        name = popupSelector.$(By.xpath(usernameSelectorFromPopup)).getText();
        return this;
    }

    @Step("Нажимаем на изображение пользователя")
    public ProfileOtvetMailPage clickTheUserpic() {
        userpicsSelector.first().click();
        return new ProfileOtvetMailPage(name);
    }
}
