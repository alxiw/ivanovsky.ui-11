package ru.mail.track.ui11.hw06.task03;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class OpenOtvetMailPageTest {

    @Test
    @DisplayName("Check Ability to Open User Profile")
    public void check_ability_to_open_user_profile() {
        new OpenOtvetMailPage()
                .open()
                .moveToUserpic(1)
                .rememberUsername()
                .clickTheUserpic()
                .checkTheUsernamePresentedOnThePage();
    }
}