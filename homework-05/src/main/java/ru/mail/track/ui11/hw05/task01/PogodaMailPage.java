package ru.mail.track.ui11.hw05.task01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.hw04.navigation.Domain;
import ru.mail.track.ui11.hw04.navigation.PageUrl;
import ru.mail.track.ui11.hw04.navigation.UrlPattern;
import ru.mail.track.ui11.hw04.pages.AbstractPage;

import static org.junit.Assert.assertTrue;

@UrlPattern("/prognoz/[\\w]{1,20}/")
@PageUrl("/")
@Domain("https://pogoda.mail.ru")
public class PogodaMailPage extends AbstractPage<PogodaMailPage> {

    @FindBy(css = ".pm-toolbar__button__text_dropdown")
    private WebElement toolbarCityButton;

    @FindBy(css = ".pm-toolbar__search__input")
    private WebElement searchInputField;

    @FindBy(css = "span[class=\"pm-toolbar__suggests__group__item  pm-toolbar__suggests__group__item_with-caption\"]:first-child > span > span > span:first-child")
    private WebElement cityElement;

    @FindBy(xpath = "//div[@class='information__header__left__place']/h1[text()='Киев']")
    private WebElement cityOnPage;

    @FindBy(css = "span[class=\"icon icon_fav-flag js-toggle_fav\"]")
    private WebElement addToFavoritesElement;

    private final String cityDropdownSelector = "[data-class='pm-dropdown']";
    private final String cityInFavorites = "//span[@class='city-select__item clearfix city-select__item_current']//span[@class='city-select__item__city']";

    private String city = "";

    public PogodaMailPage(WebDriver driver) {
        super(driver);
    }

    public PogodaMailPage moveCursorToCityButton() {
        new Actions(driver)
                .moveToElement(toolbarCityButton)
                .build()
                .perform();
        return this;
    }

    public PogodaMailPage cityDropdownShouldBeNotPresent() {
        assertTrue("Выпадающее меню города отображается на странице",
                standardWaiter.waitForCondition(ExpectedConditions.not(ExpectedConditions
                        .attributeContains(By.cssSelector(cityDropdownSelector),
                                "class", "toolbar__dropdown_show"))));
        return this;
    }

    public PogodaMailPage typeSearchText(String text) {
        searchInputField.sendKeys(text);
        city = text;
        return this;
    }


    public PogodaMailPage suggestShouldBeEnabled() {
        assertTrue("Саджесты отображаются на странице",
                standardWaiter.waitForCondition(ExpectedConditions.not(ExpectedConditions
                        .attributeContains(By.cssSelector(cityDropdownSelector),
                                "class", "pm-toolbar__suggests"))));
        return this;
    }

    public PogodaMailPage pressCity() {
        new Actions(driver)
                .moveToElement(cityElement)
                .click()
                .build()
                .perform();
        return this;
    }

    public PogodaMailPage pageWithForecastShouldBeOpen() {
        assertTrue("Город отображается на странице",
                standardWaiter.waitForCondition((
                        ExpectedConditions.visibilityOf(cityOnPage))));
        return this;
    }

    public PogodaMailPage addCityToFavorites() {
        new Actions(driver)
                .moveToElement(addToFavoritesElement)
                .click()
                .build()
                .perform();
        return this;
    }

    public PogodaMailPage cityShouldBePresented() {
        assertTrue("Должен быть выбран город \"" + city + "\"",
                standardWaiter.waitForCondition(ExpectedConditions
                        .textToBe(By.xpath(cityInFavorites), city)));
        return this;
    }
}
