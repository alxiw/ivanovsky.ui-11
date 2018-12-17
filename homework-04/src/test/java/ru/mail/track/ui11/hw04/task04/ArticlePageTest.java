package ru.mail.track.ui11.hw04.task04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.mail.track.ui11.seleniumtestcore.data.BrowserFactory;
import ru.mail.track.ui11.seleniumtestcore.drivers.WebDriverFactory;

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

    @Test
    public void check_url_of_article_page() {
        new ArticlePage(driver)
                .open("articles", "some")
                .open("articles-economic", "64")
                .open("prognoz", "boston", "4-july", "1970", "full");
    }
}
