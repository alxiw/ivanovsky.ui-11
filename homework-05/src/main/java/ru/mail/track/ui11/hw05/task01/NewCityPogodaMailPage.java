package ru.mail.track.ui11.hw05.task01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.seleniumtestcore.navigation.Domain;
import ru.mail.track.ui11.seleniumtestcore.navigation.Url;
import ru.mail.track.ui11.seleniumtestcore.navigation.UrlParam;
import ru.mail.track.ui11.seleniumtestcore.navigation.UrlPattern;

import static org.junit.Assert.assertTrue;

@UrlPattern("/prognoz/[\\w_\\-]+/")
@UrlParam({
        @Url(name = "prognoz-city", url = "/prognoz/%1/")
})
@Domain("https://pogoda.mail.ru")
public class NewCityPogodaMailPage extends AbstractCityPogodaMailPage<NewCityPogodaMailPage> {

    @FindBy(xpath = "//span[contains(@title, 'Добавить в избранные')]")
    private WebElement addToFavoritesElement;

    private final String cityInFavoritesSelectorFormat = "//*[@data-class='pm-dropdown']//*[contains(@class, 'city')]//*[contains(text(), '%s')]";

    public NewCityPogodaMailPage(WebDriver driver, String city) {
        super(driver);
        this.city = city;
        checkPageUrl();
    }

    public NewCityPogodaMailPage addCityToFavorites() {
        addToFavoritesElement.click();
        return this;
    }

    public NewCityPogodaMailPage cityShallBePresentedInDropdown() {
        assertTrue(String.format("Должен быть выбран город \"%s\"", city),
                standardWaiter.waitForCondition(ExpectedConditions
                        .visibilityOfAllElementsLocatedBy(By.xpath(String.format(cityInFavoritesSelectorFormat, city)))));
        return this;
    }
}
