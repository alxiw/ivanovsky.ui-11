package ru.mail.track.ui11.hw05.task03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.hw05.task03.enumeration.Assessement;
import ru.mail.track.ui11.seleniumtestcore.navigation.*;
import ru.mail.track.ui11.seleniumtestcore.AbstractPage;

import static org.junit.Assert.assertTrue;

@UrlPattern("/catalog/[\\w_\\-]+/[\\w_\\-]+/[\\w_\\-]+/[\\w_\\-]+/")
@UrlParam({
        @Url(name = "catalog", url = "/catalog/%1/%2/%3/%4/")
})
@Domain("https://auto.mail.ru")
public class CarsMailPage extends AbstractPage<CarsMailPage> {

    private String parameter;

    private final String popupCheckerSelector = "//div[@data-module='Tabs.CustomersMarks']";
    private final String assessmentSelectorFormat = "//*[text()='%s']/following::*[text()='%s']";
    private final String popupHeaderSelectorFromPopupChecker = "//div[@data-module='Tabs.CustomersMarks']//*[contains(@class, 'block')]/*[contains(@class, 'text')]";
    private final String popupCloseButtonSelectorFromPopupChecker = "//div[@data-module='Tabs.CustomersMarks']//*[contains(@class, 'close')]";

    public CarsMailPage(WebDriver driver) {
        super(driver);
    }

    public CarsMailPage checkThatThereAreNoOnePopupOnThePage() {
        assertTrue("Выпадающее окно открыто на странице",
                standardWaiter.waitForCondition(ExpectedConditions
                        .invisibilityOfElementLocated(By.xpath(popupCheckerSelector))));
        return this;
    }

    public CarsMailPage checkThatThePopupIsClosed() {
        assertTrue("Выпадающее окно открыто на странице",
                standardWaiter.waitForCondition(ExpectedConditions
                        .attributeContains(By.xpath(popupCheckerSelector), "class", "hidden_all")));
        return this;
    }

    public CarsMailPage clickAssessment(Assessement assessement, String parameter) {
        assertTrue("Оценка по параметру недоступна для выбора",
                standardWaiter.waitForCondition(ExpectedConditions
                        .elementToBeClickable(driver.findElement(By.xpath(String.format(assessmentSelectorFormat, 
                                assessement.getName(), parameter))))));
        driver.findElement(By.xpath(String.format(assessmentSelectorFormat,
                assessement.getName(), parameter))).click();
        this.parameter = parameter;
        return this;
    }

    public CarsMailPage popupShallBePresent() {
        assertTrue("Выпадающее окно не открыто",
                standardWaiter.waitForCondition(ExpectedConditions.not(ExpectedConditions
                        .attributeContains(By.xpath(popupCheckerSelector), "class", "hidden_all"))));
        return this;
    }

    public CarsMailPage checkPopupTitle() {
        assertTrue(String.format("Заголовок выпадающего окна не содержит названия параметра '%s'", parameter),
                driver.findElement(By.xpath(popupHeaderSelectorFromPopupChecker)).getText().contains(parameter));
        return this;
    }

    public CarsMailPage closePopup() {
        assertTrue("Кнопка закрытия выпадающего окна недоступна",
                standardWaiter.waitForCondition(ExpectedConditions
                        .elementToBeClickable(driver.findElement(By.xpath(popupCloseButtonSelectorFromPopupChecker)))));
        driver.findElement(By.xpath(popupCloseButtonSelectorFromPopupChecker)).click();
        return this;
    }
}
