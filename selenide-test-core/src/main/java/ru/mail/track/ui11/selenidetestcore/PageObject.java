package ru.mail.track.ui11.selenidetestcore;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import ru.mail.track.ui11.selenidetestcore.navigation.*;

import java.util.Objects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
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

    @Step("Открываем страницу по параметрам")
    public T open(String... args) {
        String url = buildPageUrl(fetchParameters(args[0]), args);
        Selenide.open(getDomain() + url);
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

    @Step("Проверяем заголовок страницы")
    public T checkPageHeader(String header) {
        $("h1").shouldBe(text(header));
        return (T) this;
    }

    @Step("Получаем заголовок страницы")
    public String getPageHeader() {
        return $("h1").shouldBe(Condition.enabled).getText();
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

    private String fetchParameters(String name) {
        Class<? extends PageObject> clazz = getClass();
        if (clazz.isAnnotationPresent(PageUrlPath.class)) {
            PageUrlPath annotation = clazz.getAnnotation(PageUrlPath.class);
            for (Path path : annotation.value()){
                if (Objects.equals(path.name(), name)){
                    return path.parameter();
                }
            }
        }
        return "";
    }

    private String buildPageUrl(String template, String... args){
        String url;
        if (args.length > 1) {
            url = template;
            for (int i = 1; i < args.length; i++) {
                url = url.replace("%" + (i), args[i]);
            }
        } else {
            url = template.split("%")[0];
        }
        return url;
    }
}
