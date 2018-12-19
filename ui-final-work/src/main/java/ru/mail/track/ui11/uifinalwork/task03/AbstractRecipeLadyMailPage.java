package ru.mail.track.ui11.uifinalwork.task03;

import com.codeborne.selenide.CollectionCondition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import ru.mail.track.ui11.selenidetestcore.PageObject;
import ru.mail.track.ui11.uifinalwork.task03.enumeration.Tab;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static org.junit.Assert.assertTrue;

public abstract class AbstractRecipeLadyMailPage<T extends AbstractRecipeLadyMailPage<T>> extends PageObject<AbstractRecipeLadyMailPage<T>> {

    private List recipes;

    private final String buttonSelectorFormat = "//span[contains(text(), '%s')]/ancestor::a";
    private final String recipesSelector = "//div[contains(@class, 'cols')]/div[contains(@class, 'block')]//a";

    public AbstractRecipeLadyMailPage() {
        super();
    }

    public AbstractRecipeLadyMailPage(List recipes) {
        checkPageUrl();
        this.recipes = recipes;
    }

    public T open() {
        super.open();
        return (T) this;
    }

    @Step("Проверяем наличие изменений в списке рецептов")
    public T checkRecipesList() {
        if (recipes != null && !recipes.isEmpty()) {
            List newRecipes = $$(By.xpath(recipesSelector)).shouldHave(CollectionCondition.sizeGreaterThan(0)).texts();
            assertTrue("Список рецептов не изменился", !newRecipes.equals(recipes));
            recipes = newRecipes;
        } else {
            recipes = $$(By.xpath(recipesSelector)).shouldHave(CollectionCondition.sizeGreaterThan(0)).texts();
        }
        return (T) this;
    }

    @Step("Проверяем соответствие активного вида адресу страницы и активной кнопке")
    public T checkActiveView() {
        String current = "";
        T a = (T) this;
        if (a instanceof RatingRecipeLadyMailPage) {
            current = Tab.POP.getName();
        } else if (a instanceof RecipeLadyMailPage) {
            current = Tab.NEW.getName();
        }
        assertTrue("Рецепты отображаются не в соответствии с выбранным видом", $(By.xpath(String.format(buttonSelectorFormat, current))).attr("class").contains("active"));
        return (T) this;
    }

    @Step("Переключаем вид списка рецептов с помощью кнопки")
    public AbstractRecipeLadyMailPage<? extends AbstractRecipeLadyMailPage> switchViewByButton(Tab tab) {
        T a = (T) this;
        if (a instanceof RatingRecipeLadyMailPage && tab.equals(Tab.NEW)) {
            $(By.xpath(String.format(buttonSelectorFormat, tab.getName()))).click();
            return new RecipeLadyMailPage(recipes);
        } else if (a instanceof RecipeLadyMailPage && tab.equals(Tab.POP)) {
            $(By.xpath(String.format(buttonSelectorFormat, tab.getName()))).click();
            return new RatingRecipeLadyMailPage(recipes);
        } else if (a instanceof RatingRecipeLadyMailPage && tab.equals(Tab.POP)) {
            $(By.xpath(String.format(buttonSelectorFormat, tab.getName()))).click();
            return new RatingRecipeLadyMailPage();
        } else if (a instanceof RecipeLadyMailPage && tab.equals(Tab.NEW)) {
            $(By.xpath(String.format(buttonSelectorFormat, tab.getName()))).click();
            return new RecipeLadyMailPage();
        }
        return (T) this;
    }
}
