package ru.mail.track.ui11.hw04.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.hw04.log.Logger;
import ru.mail.track.ui11.hw04.navigation.Domain;
import ru.mail.track.ui11.hw04.navigation.PageUrl;
import ru.mail.track.ui11.hw04.navigation.UrlPattern;

import static org.junit.Assert.assertTrue;

@Domain("https://www.google.com")
@PageUrl("/")
@UrlPattern("/(search\\?(&?.+=[\\w]*[^&])*&?q=([^&]+)(&.*)?)?")
public class GoogleMainPage extends AbstractPage<GoogleMainPage> {

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

    /*public GoogleMainPage open() {
        Logger.log("Open Google main page");
        return super.open();
    }*/

    public GoogleMainPage typeSearchText(String text) {
        Logger.log("Enter \"" + text + "\" in the search field");
        searchInputField.sendKeys(text);
        return this;
    }

    public GoogleMainPage submitInput(){
        Logger.log("Press enter button");
        searchInputField.submit();
        return this;
    }

    public GoogleMainPage resultsShallBeShowed() {
        Logger.log("Check availability of the results");
        assertTrue("Результаты должны отображаются на странице",
                standardWaiter.waitForCondition((
                        ExpectedConditions.visibilityOf(resultHeader))));
        return this;
    }

    public GoogleMainPage counterOfResultsShallBeMoreThanZero() {
        Logger.log("Check the counter of the results");
        assertTrue("Счётчик результатов должен отображается на странице",
                standardWaiter.waitForCondition((
                        ExpectedConditions.visibilityOfAllElements(resultStats, resultCounter))));
        return this;
    }

}
