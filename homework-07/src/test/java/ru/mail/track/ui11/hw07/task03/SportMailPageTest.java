package ru.mail.track.ui11.hw07.task03;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class SportMailPageTest {

    @Test
    @DisplayName("Check Search Button")
    public void check_remark_popup_on_page() {
        new SportMailPage()
                .open()
                .clickSearchButton()
                .clickYellowSearchButton()
                .checkThatPageRemainsTheSameWithoutRefreshing();
    }
}