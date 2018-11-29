package ru.mail.track.ui11.hw04.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.hw04.log.Logger;
import ru.mail.track.ui11.hw04.navigation.Domain;
import ru.mail.track.ui11.hw04.navigation.PageUrl;
import ru.mail.track.ui11.hw04.navigation.UrlPattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertTrue;

@Domain("https://www.google.com")
@PageUrl("/")
@UrlPattern("/(search\\?(&?.+=[\\w]*[^&])*&?q=([^&]+)(&.*)?)?")
public class GoogleMainPage extends AbstractPage<GoogleMainPage> {

    @FindBy(css = "input[name='q']")
    private WebElement searchInputField;

    @FindBy(css = "div[id='search'] > div > h1")
    private WebElement resultHeader;

    @FindBy(css = "div[id='resultStats']")
    private WebElement resultStats;

    @FindBy(css = "div[id='navcnt']")
    private WebElement resultCounter;

    public GoogleMainPage(WebDriver driver) {
        super(driver);
    }

    public GoogleMainPage open() {
        Logger.log("Open Google main page");
        return super.open();
    }

    public GoogleMainPage typeSearchText(String text) {
        Logger.log("Enter \"" + text + "\" in the search field and submit");
        searchInputField.sendKeys(text);
        searchInputField.submit();
        return this;
    }

    public GoogleMainPage pageWithSearchShallBeOpened() {
        Logger.log("Check address of opened page");
        Pattern pattern = Pattern.compile(getDomain() + getPageUrlPattern());
        Matcher matcher = pattern.matcher(driver.getCurrentUrl());
        assertTrue(String.format("Должна быть открыта страница, содержащая в URL %s",
                getPageUrl()), matcher.find());
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
