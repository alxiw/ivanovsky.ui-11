package ru.mail.track.ui11.selenidetestcore;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import ru.mail.track.ui11.selenidetestcore.navigation.Domain;
import ru.mail.track.ui11.selenidetestcore.navigation.PageUrl;
import ru.mail.track.ui11.selenidetestcore.navigation.UrlPattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public abstract class PageObject<T> {

    static {
        Configuration.browser = "chrome";
    }

    @Step("Открываем страницу")
    public T open() {
        Selenide.open(getDomain() + getPageUrl());
        checkPageUrl();
        return (T) this;
    }

    @Step("Проверяем адрес страницы")
    public T checkPageUrl(String pattern) {
        assertTrue("Адрес страницы не валиден по паттерну", WebDriverRunner.url().matches(pattern));
        return (T) this;
    }

    @Step("Проверяем адрес страницы")
    protected T checkPageUrl() {
        Class<? extends PageObject> clazz = getClass();
        if (clazz.isAnnotationPresent(UrlPattern.class)) {
            UrlPattern annotation = clazz.getAnnotation(UrlPattern.class);
            assertThat("Адрес страницы должен быть валидным", WebDriverRunner.url().matches(annotation.value()));
        }
        return (T) this;
    }

    private String getDomain() {
        Class<? extends PageObject> clazz = getClass();
        if (clazz.isAnnotationPresent(Domain.class)) {
            Domain annotation = clazz.getAnnotation(Domain.class);
            return annotation.value();
        }
        return Configuration.baseUrl;
    }

    private String getPageUrl() {
        Class<? extends PageObject> clazz = getClass();
        if(clazz.isAnnotationPresent(PageUrl.class)) {
            PageUrl annotation = clazz.getAnnotation(PageUrl.class);
            return annotation.value();
        }
        return "";
    }
}
