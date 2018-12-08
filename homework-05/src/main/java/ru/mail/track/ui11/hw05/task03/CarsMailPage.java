package ru.mail.track.ui11.hw05.task03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.seleniumtestcore.navigation.*;
import ru.mail.track.ui11.seleniumtestcore.AbstractPage;

import static org.junit.Assert.assertTrue;
import static org.openqa.selenium.support.ui.ExpectedConditions.not;

@UrlPattern("/catalog/[\\w_\\-]+/[\\w_\\-]+/[\\w_\\-]+/[\\w_\\-]+/")
@UrlParam({
        @Url(name = "catalog", url = "/catalog/%1/%2/%3/%4")
})
@Domain("https://auto.mail.ru")
public class CarsMailPage extends AbstractPage<CarsMailPage> {

    @FindBy(xpath = "//span[contains(text(), 'Плюсы')]/following::span[contains(text(), 'Управляемость')][1]")
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
        assessment = assessmentElement.getText();
        return this;
    }

    public CarsMailPage popupShallBePresent() {
        assertTrue("Выпадающее окно не появилось",
                standardWaiter.waitForCondition(
                        ExpectedConditions.visibilityOf(driver.findElement(By.xpath(popup)))));
        return this;
    }

    public CarsMailPage checkPopupTitle() {
        assertTrue(String.format("Заголовок выпадающего окна не содержит названия параметра \"%s\"", assessment),
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
