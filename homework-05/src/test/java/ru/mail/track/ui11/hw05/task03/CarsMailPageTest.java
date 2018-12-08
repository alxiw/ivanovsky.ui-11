package ru.mail.track.ui11.hw05.task03;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.mail.track.ui11.seleniumtestcore.data.BrowserFactory;
import ru.mail.track.ui11.seleniumtestcore.drivers.WebDriverFactory;

public class CarsMailPageTest {

    private WebDriver driver;

    @Before
    public void init() {
        driver = WebDriverFactory.getWebDriverInstance(BrowserFactory.getBrowser(System.getProperty("webdriver.driver")));
    }

    @After
    public void killSession() {
        driver.close();
        driver.quit();
    }

    @Test
    public void open_and_close_cars_mail_popup() {
        new CarsMailPage(driver)
                .open("catalog", "ford", "focus", "iii_restailing", "sedan")
                .clickFirstPosAssessment()
                .popupShallBePresent()
                .checkPopupTitle()
                .closePopup()
                .popupShallBeDisabled();
    }
}
