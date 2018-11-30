package ru.mail.track.ui11.hw04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.mail.track.ui11.hw04.data.BrowserFactory;
import ru.mail.track.ui11.hw04.drivers.WebDriverFactory;
import ru.mail.track.ui11.hw04.pages.GoogleMainPage;

/**
 * Автоматизировать следующий сценарий:
 * 1. Открываем страницу https://google.ru
 * 2. Ввести в строку поиска “Hello World”
 * 3. Проверить, что открылась страниица результатов поиска
 * 4. Проверить, что на странице отображаются результаты
 * 5. Проверить, что счетчик результатов больше 0
 *
 * -Dthread.count=1 -Dwebdriver.driver=chrome -Dwebdriver.chrome.driver=/Users/trueman/Documents/java/chromedriver -DforkCount=0 test -f pom.xml
 */
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

    //Тест проверяет счетчик результатов поиска и выдачу самих результатов
    @Test
    public void type_text_in_search_field_check_counter() {
        new GoogleMainPage(driver)
                //Открываем главную страницу гугл
                .open()
                //Вводим текст в поле поиска
                .typeSearchText("Hello, World!")
                //Жмём кнопку ввода
                .submitInput()
                //Проверяем открытие страницы с результатами
                .pageWithSearchShallBeOpened()
                //Проверяем наличие результатов
                .resultsShallBeShowed()
                //Проверяем счётчик результатов
                .counterOfResultsShallBeMoreThanZero();
    }
}
