package ru.mail.track.ui11.uifinalwork.task03;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class RecipeLadyMailPageTest {

    @Test
    @DisplayName("Check Recipes in List View")
    public void check_switching_recipes_list_view() {
        new RecipeLadyMailPage()
                .open()
                .checkPopViewIsActive()
                .clickNewButton()
                .checkNewViewIsActive()
                .clickPopButton()
                .checkPopViewIsActive();
    }
}