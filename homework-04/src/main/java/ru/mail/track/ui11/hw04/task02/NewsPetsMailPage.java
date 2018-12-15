package ru.mail.track.ui11.hw04.task02;

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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@UrlPattern("/[a-z]+/")
@PageUrl("/news/")
@Domain("https://pets.mail.ru")
public class NewsPetsMailPage extends AbstractPage<NewsPetsMailPage> {

    private final TestLogger logger = new TestLogger();

    private final List<List<WebElement>> storage = new ArrayList<>();

    @FindBy(xpath = "//button/descendant::*[text()='Показать еще']")
    private WebElement expandButton;

    private final String newsItemSelector = "//div[contains(@class, 'item')]/descendant::*[text()='Новости']";

    public NewsPetsMailPage(WebDriver driver) {
        super(driver);
    }

    public NewsPetsMailPage captureInitialNewsItems() {
        logger.log("Check presence news grid on the page and capture initial news items");
        assertTrue("Новости не отображаются на странице",
                standardWaiter.waitForCondition(ExpectedConditions
                        .visibilityOfAllElementsLocatedBy(By.xpath(newsItemSelector))));
        storage.add(fetchNewsItems());
        return this;
    }

    public NewsPetsMailPage pressExpandButton() {
        logger.log("Press expand button");
        assertTrue("Кнопка не отображается на странице",
                standardWaiter.waitForCondition(ExpectedConditions
                        .visibilityOf(expandButton)));
        expandButton.click();
        return this;
    }

    public NewsPetsMailPage captureNewsItemsAfterExpansion() {
        logger.log("Capture news items on the page after expansion");
        assertTrue("Количество новостей не изменилось",
                standardWaiter.waitForCondition(ExpectedConditions
                        .numberOfElementsToBeMoreThan(By.xpath(newsItemSelector),
                                storage.get(0).size())));
        storage.add(fetchNewsItems());
        return this;
    }

    public NewsPetsMailPage checkThatNumberOfNewsItemsIncreased() {
        logger.log("Check that former news not miss from the page");
        assertTrue("Старые новости отсутствуют на странице",
                storage.get(1).containsAll(storage.get(0)));
        return this;
    }

    private List<WebElement> fetchNewsItems() {
        return driver.findElements(By.xpath(newsItemSelector));
    }
}
