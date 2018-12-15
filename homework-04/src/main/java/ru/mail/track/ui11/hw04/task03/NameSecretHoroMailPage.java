package ru.mail.track.ui11.hw04.task03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.hw04.task03.enumeration.Gender;
import ru.mail.track.ui11.seleniumtestcore.AbstractPage;
import ru.mail.track.ui11.seleniumtestcore.log.TestLogger;
import ru.mail.track.ui11.seleniumtestcore.navigation.*;

import java.util.List;

import static org.junit.Assert.assertTrue;

@UrlPattern("/[a-z]+/")
@PageUrl("/namesecret/")
@Domain("https://horo.mail.ru")
public class NameSecretHoroMailPage extends AbstractPage<NameSecretHoroMailPage> {

    private final TestLogger logger = new TestLogger();

    private String letter;
    private String name;

    @FindBy(name = "q")
    private WebElement inputField;

    @FindBy(xpath = "//*[@data-module='CustomSelect']")
    private WebElement genderMenu;

    @FindBy(xpath = "//button/descendant::*[text()='Узнать тайну имени']")
    private WebElement submitButton;

    private final String letterSelectorFormat = "//div[contains(@class, 'filter')]/descendant::*[contains(@class, 'item')]/*[text()='%s']";
    private final String namesSelectorFormat = "//div[contains(@class, 'p-terms-list')]//*[contains(text(), '%s')]";
    private final String cellWithNameSelectorFormat = "//div[contains(@class, 'newsitem')]/descendant::*[contains(text(), '%s')]/ancestor::span[@class='cell']";
    private final String cellNameFromCellSelector = "a/span";
    private final String suggestionsSelector = "//*[@name='q']/ancestor::*[contains(@class, 'input')]/following-sibling::*//*[contains(@class, 'item')]";
    private final String gendersSelector = "//*[@data-module='CustomSelect']//div[contains(@class, 'item')]";

    public NameSecretHoroMailPage(WebDriver driver) {
        super(driver);
    }

    public NameSecretHoroMailPage clickLetter(String letter) {
        letter = letter.toUpperCase();
        logger.log("Click the letter \"" + letter + "\"");
        assertTrue("Буквы \"" + letter + "\" нет на странице",
                standardWaiter.waitForCondition(ExpectedConditions
                        .visibilityOfElementLocated(By.xpath(String.format(letterSelectorFormat, letter)))));
        driver.findElement(By.xpath(String.format(letterSelectorFormat, letter))).click();
        this.letter = letter;
        return this;
    }

    public NameSecretHoroMailPage checkPresenceOfNamesStartsWithChosenLetter() {
        logger.log("Check activity of button with chosen letter \"" + letter + "\"");
        assertTrue(String.format("Имена на букву \"%s\" отсутствуют", letter),
                standardWaiter.waitForCondition(ExpectedConditions
                        .visibilityOfAllElementsLocatedBy(By.xpath(String.format(namesSelectorFormat, letter)))));
        return this;
    }

    public NameSecretHoroMailPage enterNameInInputField(String name) {
        logger.log("Enter \"" + name + "\" in the search field");
        assertTrue("Поле для ввода имени не отображается на странице",
                standardWaiter.waitForCondition(ExpectedConditions
                        .visibilityOf(inputField)));
        inputField.sendKeys(name);
        this.name = name;
        return this;
    }

    public NameSecretHoroMailPage submitInput() {
        logger.log("Press submit button");
        assertTrue("Кнопка не отображается на странице",
                standardWaiter.waitForCondition(ExpectedConditions
                        .visibilityOf(submitButton)));
        submitButton.click();
        return this;
    }

    public NameHoroMailPage clickItemCompletelyMatchesTheName() {
        logger.log("Click found name which completely matches entered name");
        assertTrue("Имя отсутствует среди результатов",
                standardWaiter.waitForCondition(ExpectedConditions
                        .elementToBeClickable(By.xpath(String.format(cellWithNameSelectorFormat, name)))));
        List<WebElement> cells = driver.findElements(By.xpath(String.format(cellWithNameSelectorFormat, name)));
        for (WebElement cell : cells) {
            if (cell.findElement(By.xpath(cellNameFromCellSelector)).getText().toLowerCase().startsWith(name.toLowerCase())) {
                cell.click();
                return new NameHoroMailPage(driver, name);
            }
        }
        WebElement cell = cells.get(0);
        name = cell.findElement(By.xpath(cellNameFromCellSelector)).getText();
        cell.click();
        return new NameHoroMailPage(driver, name);
    }

    public NameHoroMailPage clickName(String name) {
        logger.log(String.format("Click name \"%s\"", name));
        assertTrue("Имя отсутствует среди результатов",
                standardWaiter.waitForCondition(ExpectedConditions
                        .elementToBeClickable(By.xpath(String.format(namesSelectorFormat, name)))));
        driver.findElement(By.xpath(String.format(namesSelectorFormat, name))).click();
        return new NameHoroMailPage(driver, name);
    }

    public NameSecretHoroMailPage clickFirstElementStartsWithEnteredNameInSuggestions() {
        logger.log("Press suggested name in popup");
        assertTrue("Предложения при вводе не отображаются",
                standardWaiter.waitForCondition(ExpectedConditions
                        .visibilityOfAllElementsLocatedBy(By.xpath(suggestionsSelector))));
        List<WebElement> suggestElements = driver.findElements(By.xpath(suggestionsSelector));
        suggestElements.stream().filter(element -> element.getText().toLowerCase().startsWith(name.toLowerCase())).findFirst().ifPresent(WebElement::click);
        return this;
    }

    public NameSecretHoroMailPage openGenderMenu() {
        logger.log("Open gender menu");
        assertTrue("Меню выбора пола невозможно открыть",
                standardWaiter.waitForCondition(ExpectedConditions
                        .elementToBeClickable(genderMenu)));
        genderMenu.click();
        return this;
    }

    public NameSecretHoroMailPage selectGender(Gender gender) {
        logger.log("Select gender in the menu");
        assertTrue("Меню выбора пола невозможно открыть",
                standardWaiter.waitForCondition(ExpectedConditions
                        .presenceOfAllElementsLocatedBy(By.xpath(gendersSelector))));
        driver.findElements(By.xpath(gendersSelector)).stream().filter(element -> element.getText().equalsIgnoreCase(gender.getName())).findFirst().ifPresent(WebElement::click);
        return this;
    }
}
