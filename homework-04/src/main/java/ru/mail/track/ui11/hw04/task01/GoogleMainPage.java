package ru.mail.track.ui11.hw04.task01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.seleniumtestcore.AbstractPage;
import ru.mail.track.ui11.seleniumtestcore.log.TestLogger;
import ru.mail.track.ui11.seleniumtestcore.navigation.Domain;
import ru.mail.track.ui11.seleniumtestcore.navigation.PageUrl;
import ru.mail.track.ui11.seleniumtestcore.navigation.UrlPattern;

import static org.junit.Assert.assertTrue;

@UrlPattern("/(search\\?(&?.+=[\\w]*[^&])*&?q=([^&]+)(&.*)?)?")
@PageUrl("/")
@Domain("https://www.google.com")
public class GoogleMainPage extends AbstractPage<GoogleMainPage> {

    private final TestLogger logger = new TestLogger();

    @FindBy(name = "q")
    private WebElement searchInputField;

    @FindBy(id = "search")
    private WebElement resultHeader;

    @FindBy(id = "resultStats")
    private WebElement resultStats;

    @FindBy(id = "navcnt")
    private WebElement resultCounter;

    public GoogleMainPage(WebDriver driver) {
        super(driver);
    }

    public GoogleMainPage typeSearchText(String text) {
        logger.log(String.format("Enter \"%s\" in the search field", text));
        searchInputField.sendKeys(text);
        return this;
    }

    public GoogleMainPage submitInput(){
        logger.log("Press enter button");
        searchInputField.submit();
        return this;
    }

    public GoogleMainPage resultsShallBeShowed() {
        logger.log("Check availability of the results");
        assertTrue("Результаты должны отображаются на странице",
                standardWaiter.waitForCondition((
                        ExpectedConditions.visibilityOf(resultHeader))));
        return this;
    }

    public GoogleMainPage counterOfResultsShallBeMoreThanZero() {
        logger.log("Check the counter of the results");
        assertTrue("Счётчик результатов должен отображается на странице",
                standardWaiter.waitForCondition((
                        ExpectedConditions.visibilityOfAllElements(resultStats, resultCounter))));
        return this;
    }
}
