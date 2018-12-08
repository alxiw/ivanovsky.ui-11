package ru.mail.track.ui11.hw04.task02;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.mail.track.ui11.seleniumtestcore.data.BrowserFactory;
import ru.mail.track.ui11.seleniumtestcore.drivers.WebDriverFactory;

public class NewsPetsMailPageTest {

    private WebDriver driver = null;

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
    public void check_show_more_button(){
        new NewsPetsMailPage(driver)
                .open()
                .checkNumberOfNewsInList()
                .pressShowMoreButton()
                .checkNumberOfNewsInListAfterButtonPressing()
                .checkNewsAfterButtonPressing();
    }
}
