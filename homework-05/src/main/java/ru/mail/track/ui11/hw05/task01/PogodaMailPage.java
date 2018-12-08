package ru.mail.track.ui11.hw05.task01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.seleniumtestcore.navigation.Domain;
import ru.mail.track.ui11.seleniumtestcore.navigation.PageUrl;
import ru.mail.track.ui11.seleniumtestcore.navigation.UrlPattern;
import ru.mail.track.ui11.seleniumtestcore.AbstractPage;

import static org.junit.Assert.assertTrue;

@UrlPattern("/prognoz/[\\w_\\-]+/")
@PageUrl("/")
@Domain("https://pogoda.mail.ru")
public class PogodaMailPage extends AbstractPage<PogodaMailPage> {

    @FindBy(css = ".pm-toolbar__button__text_dropdown")
    private WebElement toolbarCityButton;

    @FindBy(css = ".pm-toolbar__search__input")
    private WebElement searchInputField;

    @FindBy(xpath = "//span[contains(@title, 'Добавить в избранные')]")
    private WebElement addToFavoritesElement;

    private final String cityDropdownSelector = "[data-class='pm-dropdown']";
    private final String cityInFavorites = "//span[@class='city-select__item clearfix city-select__item_current']//span[@class='city-select__item__city']";

    private String city = "";

    public PogodaMailPage(WebDriver driver) {
        super(driver);
    }

    public PogodaMailPage cityDropdownShallBeNotPresent() {
        assertTrue("Выпадающее меню города отображается на странице",
                standardWaiter.waitForCondition(ExpectedConditions.not(ExpectedConditions
                        .attributeContains(By.cssSelector(cityDropdownSelector),
                                "class", "toolbar__dropdown_show"))));
        return this;
    }

    public PogodaMailPage moveCursorToCityButton() {
        new Actions(driver)
                .moveToElement(toolbarCityButton)
                .build()
                .perform();
        return this;
    }

    public PogodaMailPage cityDropdownShallBePresent() {
        assertTrue("Выпадающее меню города не отображается на странице",
                standardWaiter.waitForCondition(ExpectedConditions
                        .attributeContains(By.cssSelector(cityDropdownSelector),
                                "class", "toolbar__dropdown_show")));
        return this;
    }

    public PogodaMailPage typeSearchText(String text) {
        searchInputField.sendKeys(text);
        city = text;
        return this;
    }

    public PogodaMailPage suggestShallBeEnabled() {
        assertTrue("Саджесты отображаются на странице",
                standardWaiter.waitForCondition(ExpectedConditions.not(ExpectedConditions
                        .attributeContains(By.cssSelector(cityDropdownSelector),
                                "class", "pm-toolbar__suggests"))));
        return this;
    }

    public PogodaMailPage pressFirstSuggestedCity() {
        String firstSuggestedCity = String.format("//span[@class='pm-toolbar__suggests__group__item  pm-toolbar__suggests__group__item_with-caption']//span[text()='%s']", city);
        WebElement firstSuggestedCityElement = driver.findElement(By.xpath(firstSuggestedCity));
        new Actions(driver)
                .moveToElement(firstSuggestedCityElement)
                .click()
                .build()
                .perform();
        return this;
    }

    public PogodaMailPage pageWithForecastShouldBeOpen() {
        assertTrue("Город отображается на странице",
                standardWaiter.waitForCondition((
                        ExpectedConditions.visibilityOf(driver.findElement(By.xpath(String.format("//div[@class='information__header__left__place']/h1[text()='%s']", city)))))));
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

    public PogodaMailPage cityShouldBePresentedInDropdown() {
        assertTrue(String.format("Должен быть выбран город \"%s\"", city),
                standardWaiter.waitForCondition(ExpectedConditions
                        .textToBe(By.xpath(cityInFavorites), city)));
        return this;
    }
}
