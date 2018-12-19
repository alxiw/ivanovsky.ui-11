package ru.mail.track.ui11.uifinalwork.task04.components;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.component.Component;
import ru.mail.track.ui11.selenidetestcore.component.ComponentObject;
import ru.mail.track.ui11.uifinalwork.task04.ConsultantPetsMailPage;

@Component(xpath = "//div[contains(@data-module, 'Slider')]")
public class Slider extends ComponentObject<Slider> {

    private final String consultantSelector = ".//*[contains(@class, 'selected')]//*[contains(@class, 'consultant')]/a";

    @Step("Нажимаем плитку консультанта и запоминаем его имя")
    public ConsultantPetsMailPage clickAnyConsultantOnThePage() {
        ElementsCollection list = component.$$(By.xpath(consultantSelector)).shouldBe(CollectionCondition.sizeGreaterThan(0));
        SelenideElement item = list.find(Condition.visible);
        String name = item.getText();
        item.click();
        return new ConsultantPetsMailPage(name);
    }
}
