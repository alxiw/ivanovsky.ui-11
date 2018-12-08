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

import java.util.List;

import static org.junit.Assert.assertTrue;

@UrlPattern("/[a-z]+/")
@PageUrl("/news/")
@Domain("https://pets.mail.ru")
public class NewsPetsMailPage extends AbstractPage<NewsPetsMailPage> {

    TestLogger logger = new TestLogger();

    private List<WebElement> newsList = null;
    private List<WebElement> newsListAfterPressShowMore = null;

    @FindBy(css = "[class='pypo-item js-pgng_item']")
    private WebElement newsField;

    private String newsFieldSelector = "[class='pypo-item js-pgng_item']";
    private String showMoreButtonSelector = "[class='button js-pgng_more_link']";

    public NewsPetsMailPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> getNewsList() {
        logger.log("Receive list of news");
        return driver.findElements(By.cssSelector(newsFieldSelector));
    }

    public NewsPetsMailPage checkNumberOfNewsInList() {
        logger.log("Check size of news list");
        assertTrue("Новости должны отображаться на странице",
                standardWaiter.waitForCondition(ExpectedConditions.visibilityOf(newsField)));
        newsList = getNewsList();
        return this;
    }

    public NewsPetsMailPage pressShowMoreButton() {
        logger.log("Press button \"Show More\"");
        driver.findElement(By.cssSelector(showMoreButtonSelector)).click();
        return this;
    }

    public NewsPetsMailPage checkNumberOfNewsInListAfterButtonPressing() {
        logger.log("Check size of changed news list");
        assertTrue("Количество новостей должно измениться",
                standardWaiter.waitForCondition(ExpectedConditions
                        .numberOfElementsToBeMoreThan(By.cssSelector(newsFieldSelector),
                                newsList.size())));
        newsListAfterPressShowMore = getNewsList();
        return this;
    }

    public NewsPetsMailPage checkNewsAfterButtonPressing() {
        logger.log("Compare two news lists");
        newsListAfterPressShowMore = getNewsList();
        assertTrue(newsListAfterPressShowMore.containsAll(newsList));
        return this;
    }
}
