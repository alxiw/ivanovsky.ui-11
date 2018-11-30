package ru.mail.track.ui11.hw04.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.hw04.navigation.Domain;
import ru.mail.track.ui11.hw04.navigation.PageUrl;

import java.util.List;
import java.util.Objects;

import static org.junit.Assert.assertTrue;

@Domain("https://horo.mail.ru")
@PageUrl("/namesecret")
public class NameSecretHoroMailPage extends AbstractPage<NameSecretHoroMailPage> {

    @FindBy(name = "q")
    private WebElement nameInputField;

    @FindBy(name = "g")
    private WebElement genderList;

    @FindBy(css = "[class='filter__item']")
    private List<WebElement> letterButton;

    @FindBy(css = "[class='suggest__inner js-suggest__render'")
    private WebElement suggestMenu;

    public NameSecretHoroMailPage(WebDriver driver) {
        super(driver);
    }

    public NameSecretHoroMailPage typeSearchName(String text){
        nameInputField.sendKeys(text);
        return this;
    }

    public NameSecretHoroMailPage submitInput() {
        nameInputField.submit();
        return this;
    }

    public NameSecretHoroMailPage clickFirstSuggestedItem() {
        String suggestNamesLocator = "//div[@class='newsitem newsitem_vertical newsitem_special newsitem_border_bottom']";
        List<WebElement> suggestElements = driver.findElements(By.xpath(suggestNamesLocator));
        assertTrue("В выпадающем меню должна быть возможность выбора имён", !suggestElements.isEmpty());
        suggestElements.get(0).click();
        return this;
    }

    public NameSecretHoroMailPage checkInfoAboutSelectedName() {
        String nameInfoElement = "//div[@class='newsitem newsitem_vertical newsitem_namesecret']";
        assertTrue("Должна появиться информация об имени",
                standardWaiter.waitForCondition(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(nameInfoElement))));
        return this;
    }

    public NameSecretHoroMailPage pressLetterButton(String letter) {
        letterButton.stream()
                .filter((button) -> Objects.equals(button.getText(), letter))
                .findFirst()
                .get()
                .click();
        return this;
    }

    public NameSecretHoroMailPage checkActiveLetterButton(String letter) {
        String letterOpenButtonSelector = "[class='filter__item filter__item_active']";
        assertTrue(String.format("Должен быть выбран список имен начинающихся с буквы \"%s\"", letter),
                standardWaiter.waitForCondition(ExpectedConditions
                        .textToBe(By.cssSelector(letterOpenButtonSelector), letter)));
        return this;
    }

    public NameSecretHoroMailPage checkSuggestionsInPopUp() {
        assertTrue("Должно появиться выпадающее меню",
                standardWaiter.waitForCondition(ExpectedConditions
                        .visibilityOf(suggestMenu)));
        return this;
    }

    public NameSecretHoroMailPage pressSuggestedElementInPopUp() {
        String suggestElementLocator = "//div[@class ='suggest__item js-suggest__item']";
        List<WebElement> suggestElements = driver.findElements(By.xpath(suggestElementLocator));
        assertTrue("В выпадающем меню должна быть возможность выбора имён", !suggestElements.isEmpty());
        suggestElements.get(0).click();
        return this;
    }

    public NameSecretHoroMailPage openGenderPopUp() {
        String genderSelectLocator = "//div[@class ='dropdown dropdown_scrollable dropdown_scrollable dropdown_scrollable js-select js-module']";
        String genderListLocator = "//div[@class ='suggest__inner js-select__options__list js-scrollable__view dropdown__scroll']";
        driver.findElement(By.xpath(genderSelectLocator)).click();
        assertTrue("Меню выбора пола должно появиться",
                standardWaiter.waitForCondition(ExpectedConditions
                        .presenceOfElementLocated(By.xpath(genderListLocator))));
        return this;
    }

    public NameSecretHoroMailPage selectGenderInPopUp() {
        String womanSelectElementLocator = "//div[@class ='suggest__item js-select__options__item' and text()='Женские']";
        driver.findElement(By.xpath(womanSelectElementLocator)).click();
        return this;
    }

}
