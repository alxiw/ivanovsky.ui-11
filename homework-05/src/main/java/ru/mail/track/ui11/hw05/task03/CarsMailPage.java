package ru.mail.track.ui11.hw05.task03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.hw04.navigation.Domain;
import ru.mail.track.ui11.hw04.navigation.PageUrl;
import ru.mail.track.ui11.hw04.navigation.UrlPattern;
import ru.mail.track.ui11.hw04.pages.AbstractPage;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;

@UrlPattern("/catalog/ford/focus/.*")
@PageUrl("/catalog/ford/focus/iii_restailing/sedan/")
@Domain("https://auto.mail.ru")
public class CarsMailPage extends AbstractPage<CarsMailPage> {

    @FindBy(xpath = "//a[@data-type-tag = 'plus']")
    private WebElement assessmentElement;

    @FindBy(xpath = "//div[contains(@class,'popup__wrapper')]/div/span[contains(@class, 'text')]")
    private WebElement popupTitle;

    @FindBy(xpath = "//span[contains(@class,'popup__close')]")
    private WebElement closePopupButton;

    private final String popup = "//div[contains(@class,'popup__wrapper')]";

    private String assessment;

    public CarsMailPage(WebDriver driver) {
        super(driver);
    }

    public CarsMailPage clickFirstPosAssessment() {
        assessmentElement.click();
        assessment = assessmentElement.findElement(By.xpath("//span[contains(@class, 'link__text margin_right_5')]")).getText();
        return this;
    }

    public CarsMailPage popupShallBePresent() {
        assertTrue("Выпадающее окно не появилось",
                standardWaiter.waitForCondition(
                        ExpectedConditions.visibilityOf(driver.findElement(By.xpath(popup)))));
        return this;
    }

    public CarsMailPage checkPopupTitle() {
        assertTrue("Заголовок выпадающего окна не содержит названия параметра \"" + assessment + "\"",
                popupTitle.getText().contains(assessment));
        return this;
    }

    public CarsMailPage closePopup() {
        closePopupButton.click();
        return this;
    }

    public CarsMailPage popupShallBeDisabled() {
        assertTrue("Выпадающее окно не закрыто",
                standardWaiter.waitForCondition(
                        not(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(popup))))));
        return this;
    }
}
