package ru.mail.track.ui11.uifinalwork.task03;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.mail.track.ui11.uifinalwork.task03.enumeration.Tab;

public class RecipeLadyMailPageTest {

    @Test
    @DisplayName("Check Recipes in List View")
    public void check_switching_recipes_list_view() {
        new RatingRecipeLadyMailPage()
                .open("new", "week", "rating")
                .checkActiveView()
                .checkRecipesList()
                .switchViewByButton(Tab.NEW)
                .checkActiveView()
                .checkRecipesList()
                .switchViewByButton(Tab.POP)
                .checkActiveView()
                .checkRecipesList();
    }
}