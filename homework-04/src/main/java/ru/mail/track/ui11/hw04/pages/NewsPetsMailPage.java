package ru.mail.track.ui11.hw04.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.hw04.log.TestLogger;
import ru.mail.track.ui11.hw04.navigation.Domain;
import ru.mail.track.ui11.hw04.navigation.PageUrl;

import java.util.List;

import static org.junit.Assert.assertTrue;

@Domain("https://pets.mail.ru")
@PageUrl("/news")
public class NewsPetsMailPage extends AbstractPage<NewsPetsMailPage> {

    private List<WebElement> newsList = null;
    private List<WebElement> newsListAfterPressShowMore = null;

    @FindBy(css = "[class='pypo-item js-pgng_item']")
    private WebElement newsField;

    public NewsPetsMailPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> getNewsList() {
        TestLogger.log("Receive list of news");
        String newsFieldSelector = "[class='pypo-item js-pgng_item']";
        return driver.findElements(By.cssSelector(newsFieldSelector));
    }

    public NewsPetsMailPage checkNumberOfNewsInList() {
        TestLogger.log("Check size of news list");
        assertTrue("Новости должны отображаться на странице",
                standardWaiter.waitForCondition(ExpectedConditions.visibilityOf(newsField)));
        newsList = getNewsList();
        return this;
    }

    public NewsPetsMailPage pressShowMoreButton() {
        TestLogger.log("Press button \"Show More\"");
        String showMoreButtonSelector = "[class='button js-pgng_more_link']";
        driver.findElement(By.cssSelector(showMoreButtonSelector)).click();
        return this;
    }

    public NewsPetsMailPage checkNumberOfNewsInListAfterButtonPressing() {
        TestLogger.log("Check size of changed news list");
        String newsFieldSelector = "[class='pypo-item js-pgng_item']";
        assertTrue("Количество новостей должно измениться",
                standardWaiter.waitForCondition(ExpectedConditions
                        .numberOfElementsToBeMoreThan(By.cssSelector(newsFieldSelector),
                                newsList.size())));
        newsListAfterPressShowMore = getNewsList();
        return this;
    }

    public NewsPetsMailPage checkNewsAfterButtonPressing() {
        TestLogger.log("Compare two news lists");
        newsListAfterPressShowMore = getNewsList();
        assertTrue(newsListAfterPressShowMore.containsAll(newsList));
        return this;
    }
}
