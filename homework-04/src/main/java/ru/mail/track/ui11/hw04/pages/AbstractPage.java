package ru.mail.track.ui11.hw04.pages;

import org.hamcrest.Matchers;
import org.hamcrest.core.StringContains;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ru.mail.track.ui11.hw04.log.Logger;
import ru.mail.track.ui11.hw04.navigation.*;
import ru.mail.track.ui11.hw04.wait.StandardWaiter;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public abstract class AbstractPage<T> {

    protected WebDriver driver = null;
    protected StandardWaiter standardWaiter = null;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        standardWaiter = new StandardWaiter(driver);
        PageFactory.initElements(driver, this);
    }

    public T open() {
        driver.get(getDomain() + getPageUrl());
        assertUrl();
        return (T) this;
    }

    public T open(String... args) {
        String url = buildPageUrl(getPageUrlWithParam(args[0]), args);
        driver.get(getDomain() + url);
        assertUrl();
        return (T) this;
    }

    protected String getDomain() {
        Class<? extends AbstractPage> clazz = getClass();
        if (clazz.isAnnotationPresent(Domain.class)) {
            Domain annotation = clazz.getAnnotation(Domain.class);
            return annotation.value();
        }
        return System.getProperty("webdriver.base.url");
    }

    protected String getPageUrl() {
        Class<? extends AbstractPage> clazz = getClass();
        if (clazz.isAnnotationPresent(PageUrl.class)) {
            PageUrl annotation = clazz.getAnnotation(PageUrl.class);
            return annotation.value();
        }
        return "";
    }

    protected String getPageUrlPattern() {
        Class<? extends AbstractPage> clazz = getClass();
        if (clazz.isAnnotationPresent(UrlPattern.class)) {
            UrlPattern annotation = clazz.getAnnotation(UrlPattern.class);
            return annotation.value();
        }
        return "";
    }

    public T pageWithSearchShallBeOpened() {
        Logger.log("Check address of opened page");
        Pattern pattern = Pattern.compile(getDomain() + getPageUrlPattern());
        Matcher matcher = pattern.matcher(driver.getCurrentUrl());
        assertTrue(String.format("Должна быть открыта страница, содержащая в URL %s",
                getPageUrl()), matcher.find());
        return (T) this;
    }

    private String buildPageUrl(String urlTemplate, String... args){
        String url = "";
        if (args.length > 1) {
            for (int i = 1; i < args.length; i++) {
                url = urlTemplate.replace("%" + (i), args[i]);
            }
        } else {
            url = urlTemplate.split("%")[0];
        }
        return url;
    }

    private String getPageUrlWithParam(String name){
        Class<? extends AbstractPage> clazz = getClass();
        if (clazz.isAnnotationPresent(UrlParam.class)) {
            UrlParam annotation = clazz.getAnnotation(UrlParam.class);
            for (Url url : annotation.value()){
                if (Objects.equals(url.name(), name)){
                    return url.url();
                }
            }
        }
        return "";
    }

    private T assertUrl() {
        Class<? extends AbstractPage> clazz = getClass();
        if (clazz.isAnnotationPresent(UrlPattern.class)) {
            UrlPattern annotation = clazz.getAnnotation(UrlPattern.class);
            assertThat("Адрес страницы должен быть валидным", driver.getCurrentUrl(), Matchers.matchesPattern(getDomain() + annotation.value()));
        } else {
            assertThat(String.format("Должна быть открыта страница %s", getPageUrl()),
                    driver.getCurrentUrl(),
                    StringContains.containsString(getDomain() + getPageUrl()));
        }
        return (T) this;
    }
}
