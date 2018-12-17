package ru.mail.track.ui11.hw05.task01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.seleniumtestcore.navigation.Domain;
import ru.mail.track.ui11.seleniumtestcore.navigation.PageUrl;
import ru.mail.track.ui11.seleniumtestcore.navigation.UrlPattern;

import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

@UrlPattern("/prognoz/[\\w_\\-]+/")
@PageUrl("/")
@Domain("https://pogoda.mail.ru")
public class DefaultCityPogodaMailPage extends AbstractCityPogodaMailPage<DefaultCityPogodaMailPage> {

    private final String citiesInFavoritesSelector = "//*[contains(@data-class, 'pm-dropdown')]//*[contains(@class, 'item__city')]";
    private final String suggestionsSelector = "//span[@class='s-suggest']//span[contains(@class, 'city')]";

    public DefaultCityPogodaMailPage(WebDriver driver) {
        super(driver);
    }

    public DefaultCityPogodaMailPage onlyCurrentCityShallBeInFavorites() {
        assertTrue("В избранном присутствуют города",
                standardWaiter.waitForCondition(ExpectedConditions
                        .numberOfElementsToBe(By.xpath(citiesInFavoritesSelector), 1)));
        assertTrue("В избранном присутствуют города",
                standardWaiter.waitForCondition(ExpectedConditions
                        .textToBe(By.xpath(citiesInFavoritesSelector), city)));
        return this;
    }

    public DefaultCityPogodaMailPage typeSearchText(String text) {
        assertTrue("Поле для ввода города недоступно",
                standardWaiter.waitForCondition(ExpectedConditions
                        .visibilityOf(searchInputField)));
        searchInputField.sendKeys(text);
        assertNotEquals("Введён текущий город", city, text);
        city = text;
        return this;
    }

    public NewCityPogodaMailPage clickFirstSuggestedCity() {
        assertTrue("Саджесты отображаются на странице",
                standardWaiter.waitForCondition(ExpectedConditions.not(ExpectedConditions
                        .attributeContains(cityDropdown, "class", "pm-toolbar__suggests"))));
        List<WebElement> suggestElements = driver.findElements(By.xpath(suggestionsSelector));
        suggestElements.stream().filter(element -> element.getText().toLowerCase().startsWith(city.toLowerCase())).findFirst().ifPresent(WebElement::click);
        return new NewCityPogodaMailPage(driver, city);
    }
}
