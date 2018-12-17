package ru.mail.track.ui11.hw04.task03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.mail.track.ui11.seleniumtestcore.AbstractPage;
import ru.mail.track.ui11.seleniumtestcore.log.TestLogger;
import ru.mail.track.ui11.seleniumtestcore.navigation.*;

import static org.junit.Assert.assertTrue;

@UrlPattern("/namesecret/[a-z]+/")
@UrlParam({
        @Url(name = "namesecret-name", url = "/namesecret/%1/")
})
@Domain("https://horo.mail.ru")
public class NameHoroMailPage extends AbstractPage<NameHoroMailPage> {

    private final TestLogger logger = new TestLogger();

    private String name;

    private final String nameHeaderSelector = "//h1[contains(text(), '%s')]";

    public NameHoroMailPage(WebDriver driver, String name) {
        super(driver);
        this.name = name;
        checkPageUrl();
    }

    public NameHoroMailPage checkInfoAboutSelectedName() {
        logger.log("Check presence of information about suggested name");
        assertTrue("Должна появиться информация об имени",
                standardWaiter.waitForCondition(ExpectedConditions.
                        presenceOfAllElementsLocatedBy(By.xpath(String.format(nameHeaderSelector, name)))));
        return this;
    }
}
