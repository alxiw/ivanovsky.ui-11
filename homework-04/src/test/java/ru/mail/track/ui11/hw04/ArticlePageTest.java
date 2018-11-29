package ru.mail.track.ui11.hw04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.mail.track.ui11.hw04.data.BrowserFactory;
import ru.mail.track.ui11.hw04.drivers.WebDriverFactory;
import ru.mail.track.ui11.hw04.pages.ArticlePage;

public class ArticlePageTest {

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
    public void check_url_of_article_page() {
        new ArticlePage(driver)
                .open("articles", "economic")
                .checkPageUrl();
    }

}
