package ru.mail.track.ui11.hw04.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

    private String newsFieldSelector = "[class='pypo-item js-pgng_item']";

    private String showMoreButtonSelector = "[class='button js-pgng_more_link']";

    public NewsPetsMailPage(WebDriver driver) {
        super(driver);
    }

    private List<WebElement> getNewsList(){
        return driver.findElements(By.cssSelector(newsFieldSelector));
    }

    public NewsPetsMailPage checkNumberOfNewsInList(){
        assertTrue("Новости должны отображаться на странице",
                standardWaiter.waitForCondition(ExpectedConditions.visibilityOf(newsField)));
        newsList = getNewsList();
        return this;
    }

    public NewsPetsMailPage pressShowMoreButton(){
        driver.findElement(By.cssSelector(showMoreButtonSelector)).click();
        return this;
    }

    public NewsPetsMailPage checkNumberOfNewsInListAfterButtonPressing(){
        assertTrue("Количество новостей должно измениться",
                standardWaiter.waitForCondition(ExpectedConditions
                        .numberOfElementsToBeMoreThan(By.cssSelector(newsFieldSelector),
                                newsList.size())));
        newsListAfterPressShowMore = getNewsList();
        return this;
    }

    public NewsPetsMailPage checkNewsAfterButtonPressing(){
        newsListAfterPressShowMore = getNewsList();
        assertTrue(newsListAfterPressShowMore.containsAll(newsList));
        return this;
    }

}
