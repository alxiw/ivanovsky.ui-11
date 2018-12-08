package ru.mail.track.ui11.hw04.task01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.mail.track.ui11.seleniumtestcore.data.BrowserFactory;
import ru.mail.track.ui11.seleniumtestcore.drivers.WebDriverFactory;

public class GoogleMainPageTest {

    private WebDriver driver = null;

    @Before
    public void init() {
        driver = WebDriverFactory.getWebDriverInstance(BrowserFactory.getBrowser(System.getProperty("webdriver.driver")));
    }

    @After
    public void killBrowser() {
        driver.close();
        driver.quit();
    }

    @Test
    public void type_text_in_search_field_check_counter() {
        new GoogleMainPage(driver)
                //Открываем главную страницу Google
                .open()
                //Вводим текст в поле поиска
                .typeSearchText("Hello, World!")
                //Жмём кнопку ввода
                .submitInput()
                //Проверяем наличие результатов
                .resultsShallBeShowed()
                //Проверяем счётчик результатов
                .counterOfResultsShallBeMoreThanZero();
    }
}
