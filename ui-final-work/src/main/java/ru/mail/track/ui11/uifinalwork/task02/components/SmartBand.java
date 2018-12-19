package ru.mail.track.ui11.uifinalwork.task02.components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.component.ComponentObject;
import ru.mail.track.ui11.selenidetestcore.component.Component;
import ru.mail.track.ui11.uifinalwork.task02.ArticleDetiMailPage;

@Component(xpath = "//section[@data-module='Feed']")
public class SmartBand extends ComponentObject<SmartBand> {

    private final String newsSelector = ".//span[contains(@class, 'caption')]/span[contains(@class, 'title')] | .//div[contains(@class, 'header')]";

    @Step("Нажимаем плитку новости и запоминаем её заголовок")
    public ArticleDetiMailPage clickNewsItem(int index) {
        ElementsCollection list = component.$$(By.xpath(newsSelector)).shouldBe(CollectionCondition.sizeGreaterThan(0));
        index = (index < 1 || index > list.size()) ? index - 1 : 0;
        SelenideElement item = list.get(index).shouldBe(Condition.visible);
        String caption = item.getText();
        item.click();
        return new ArticleDetiMailPage(caption);
    }
}
