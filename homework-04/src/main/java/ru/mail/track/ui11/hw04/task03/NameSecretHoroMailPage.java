package ru.mail.track.ui11.hw04.task03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.seleniumtestcore.AbstractPage;
import ru.mail.track.ui11.seleniumtestcore.log.TestLogger;
import ru.mail.track.ui11.seleniumtestcore.navigation.Domain;
import ru.mail.track.ui11.seleniumtestcore.navigation.PageUrl;
import ru.mail.track.ui11.seleniumtestcore.navigation.UrlPattern;

import java.util.List;

import static org.junit.Assert.assertTrue;

@UrlPattern("/[a-z]+/")
@PageUrl("/namesecret/")
@Domain("https://horo.mail.ru")
public class NameSecretHoroMailPage extends AbstractPage<NameSecretHoroMailPage> {

    TestLogger logger = new TestLogger();

    @FindBy(name = "q")
    private WebElement nameInputField;

    @FindBy(name = "g")
    private WebElement genderList;

    @FindBy(css = "[class='filter__item']")
    private List<WebElement> letterButton;

    @FindBy(css = "[class='suggest__inner js-suggest__render'")
    private WebElement suggestMenu;

    private String suggestNamesLocator = "//div[@class='newsitem newsitem_vertical newsitem_special newsitem_border_bottom']";
    private String nameInfoElement = "//div[@class='newsitem newsitem_vertical newsitem_namesecret']";
    private String letterOpenButtonSelector = "[class='filter__item filter__item_active']";
    private String suggestElementLocator = "//div[@class ='suggest__item js-suggest__item']";
    private String genderSelectLocator = "//div[@class ='dropdown dropdown_scrollable dropdown_scrollable dropdown_scrollable js-select js-module']";
    private String genderListLocator = "//div[@class ='suggest__inner js-select__options__list js-scrollable__view dropdown__scroll']";

    public NameSecretHoroMailPage(WebDriver driver) {
        super(driver);
    }

    public NameSecretHoroMailPage typeSearchName(String text) {
        logger.log("Enter \"" + text + "\" in the search field");
        nameInputField.sendKeys(text);
        return this;
    }

    public NameSecretHoroMailPage submitInput() {
        logger.log("Press enter button");
        nameInputField.submit();
        return this;
    }

    public NameSecretHoroMailPage clickFirstSuggestedItem() {
        logger.log("Choose first suggested name");
        List<WebElement> suggestElements = driver.findElements(By.xpath(suggestNamesLocator));
        assertTrue("В выпадающем меню должна быть возможность выбора имён", !suggestElements.isEmpty());
        suggestElements.get(0).click();
        return this;
    }

    public NameSecretHoroMailPage checkInfoAboutSelectedName() {
        logger.log("Check availability of information about suggested name");
        assertTrue("Должна появиться информация об имени",
                standardWaiter.waitForCondition(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(nameInfoElement))));
        return this;
    }

    public NameSecretHoroMailPage pressLetterButton(String letter) {
        logger.log("Press the button with letter \"" + letter + "\"");
        letterButton.stream()
                .filter(button -> button.getText().equals(letter))
                .findFirst().ifPresent(WebElement::click);
        return this;
    }

    public NameSecretHoroMailPage checkActiveLetterButton(String letter) {
        logger.log("Check activity of button with chosen letter \"" + letter + "\"");
        assertTrue(String.format("Должен быть выбран список имен начинающихся с буквы \"%s\"", letter),
                standardWaiter.waitForCondition(ExpectedConditions
                        .textToBe(By.cssSelector(letterOpenButtonSelector), letter)));
        return this;
    }

    public NameSecretHoroMailPage checkSuggestionsInPopUp() {
        logger.log("Check availability of suggestions in popup");
        assertTrue("Должно появиться выпадающее меню",
                standardWaiter.waitForCondition(ExpectedConditions
                        .visibilityOf(suggestMenu)));
        return this;
    }

    public NameSecretHoroMailPage pressSuggestedElementInPopUp() {
        logger.log("Press suggested name in popup");
        List<WebElement> suggestElements = driver.findElements(By.xpath(suggestElementLocator));
        assertTrue("В выпадающем меню должна быть возможность выбора имён", !suggestElements.isEmpty());
        suggestElements.get(0).click();
        return this;
    }

    public NameSecretHoroMailPage openGenderMenu() {
        logger.log("Check activity of gender menu");
        driver.findElement(By.xpath(genderSelectLocator)).click();
        assertTrue("Меню выбора пола должно появиться",
                standardWaiter.waitForCondition(ExpectedConditions
                        .presenceOfElementLocated(By.xpath(genderListLocator))));
        return this;
    }

    public NameSecretHoroMailPage selectGenderInMenu(String gender) {
        logger.log("Select gender in menu");
        String womanSelectElementLocator = String.format("//div[@class ='suggest__item js-select__options__item' and text()='%s']", gender);
        driver.findElement(By.xpath(womanSelectElementLocator)).click();
        return this;
    }
}
