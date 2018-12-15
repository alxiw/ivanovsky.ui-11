package ru.mail.track.ui11.hw05.task01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.seleniumtestcore.AbstractPage;

import static org.junit.Assert.assertTrue;

public abstract class AbstractCityPogodaMailPage<T> extends AbstractPage<AbstractCityPogodaMailPage<T>> {

    protected String city;

    @FindBy(xpath = "//*[@data-class='pm-dropdown']")
    protected WebElement cityDropdown;

    @FindBy(name = "name")
    protected WebElement searchInputField;

    private final String cityDropdownButtonFromCityDropdownSelector = "preceding-sibling::*";
    private final String currentCitySelector = "//*[@data-class='pm-dropdown']/preceding-sibling::*/span[@bem-id='18']/span";

    public AbstractCityPogodaMailPage(WebDriver driver) {
        super(driver);
    }

    public T moveCursorToCityDropdown() {
        assertTrue("Выпадающее меню города развёрнуто",
                standardWaiter.waitForCondition(ExpectedConditions.not(ExpectedConditions
                        .attributeContains(cityDropdown, "class", "pm-toolbar__dropdown_show"))));
        new Actions(driver)
                .moveToElement(cityDropdown.findElement(By.xpath(cityDropdownButtonFromCityDropdownSelector)))
                .build()
                .perform();
        return (T) this;
    }

    public T checkCurrentCity() {
        assertTrue("Выпадающее меню города свёрнуто",
                standardWaiter.waitForCondition(ExpectedConditions
                        .attributeContains(cityDropdown, "class", "pm-toolbar__dropdown_show")));
        city = driver.findElement(By.xpath(currentCitySelector)).getText();
        return (T) this;
    }
}
