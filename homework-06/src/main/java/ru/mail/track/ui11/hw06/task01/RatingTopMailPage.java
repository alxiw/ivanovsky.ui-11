package ru.mail.track.ui11.hw06.task01;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.selenidetestcore.navigation.Domain;
import ru.mail.track.ui11.selenidetestcore.navigation.PageUrl;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.*;

@UrlPattern("^http[s]?://top.mail.ru/Rating/All/Today/Visitors/(\\d{1,2}\\.html)?$")
@PageUrl("/Rating/All/Today/Visitors/")
@Domain("https://top.mail.ru")
public class RatingTopMailPage extends PageObject<RatingTopMailPage> {

    private final String pageNumberSelectorFormat = "//form[@id='select']/following-sibling::div//a[contains(text(), '%d')]";

    private ElementsCollection numbersOnPage = $$(By.xpath("//form[@id='select']/div/table//td[1]"));

    @Step("Нажимаем на кнопку страницы с номером {number}")
    public RatingTopMailPage clickPageNumber(int number) {
        SelenideElement pageButtonElement = $(By.xpath(String.format(pageNumberSelectorFormat, number)));
        pageButtonElement.click();
        return this;
    }

    @Step("Получаем список номеров со страницы")
    public List<String> getListWithNumbersOnPage() {
        return numbersOnPage.stream().map(SelenideElement::getText).collect(Collectors.toList());
    }
}
