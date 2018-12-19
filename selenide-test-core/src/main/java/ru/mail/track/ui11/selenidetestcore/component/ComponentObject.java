package ru.mail.track.ui11.selenidetestcore.component;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public abstract class ComponentObject<T> {

    protected SelenideElement component = null;

    public ComponentObject() {
        validate();
    }

    private void validate() {
        Class<? extends ComponentObject> clazz = getClass();
        if (clazz.isAnnotationPresent(Component.class)) {
            Component component = clazz.getAnnotation(Component.class);
            ComponentLocator locator = new ComponentLocator();
            if (!component.xpath().isEmpty()) {
                locator.setXpath(component.xpath());
            }
            if (!component.css().isEmpty()) {
                locator.setCss(component.css());
            }
            this.component = $(locator.buildBy()).should(Condition.visible);
        }
    }
}
