package ru.mail.track.ui11.hw06.task02;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.Domain;
import ru.mail.track.ui11.selenidetestcore.navigation.PageUrl;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

import static com.codeborne.selenide.Selenide.$;
import static org.junit.Assert.assertTrue;

@UrlPattern("http[s]?://tv.mail.ru/([\\w_\\-]+/)?")
@PageUrl("/")
@Domain("https://tv.mail.ru")
public class TvMailPage extends PageObject<TvMailPage> {

    private final String viewSelector = "p-channels ";
    private final String listSelector = "p-channels_list";
    private final String gridSelector = "p-channels_grid";
    private final String activeButtonSelector = "button_active";

    private SelenideElement gridButtonElement = $(By.xpath("//button[@data-type='grid']"));
    private SelenideElement listButtonElement = $(By.xpath("//button[@data-type='list']"));
    private SelenideElement viewElement = $(By.xpath(String.format("//div[contains(@class, '%s')]", viewSelector)));

    @Step("Проверяем, что каналы отображаются сеткой")
    public TvMailPage checkGridViewIsActive() {
        assertTrue(viewElement.waitWhile(Condition.attribute("class", viewSelector + listSelector), 2000).getAttribute("class").contains(gridSelector));
        return this;
    }

    @Step("Нажимаем на кнопку переключения режима отбражения на списковый")
    public TvMailPage clickListButton() {
        assertTrue(gridButtonElement.getAttribute("class").contains(activeButtonSelector));
        listButtonElement.click();
        return this;
    }

    @Step("Проверяем, что каналы отображаются списком")
    public TvMailPage checkListViewIsActive() {
        assertTrue(listButtonElement.getAttribute("class").contains(activeButtonSelector));
        return this;
    }

    @Step("Нажимаем на кнопку переключения режима отбражения на сеточный")
    public TvMailPage clickGridButton() {
        assertTrue(viewElement.waitWhile(Condition.attribute("class", viewSelector + gridSelector), 2000).getAttribute("class").contains(listSelector));
        gridButtonElement.click();
        return this;
    }
}
