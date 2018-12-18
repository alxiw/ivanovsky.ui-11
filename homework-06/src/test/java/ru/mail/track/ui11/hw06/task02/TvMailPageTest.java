package ru.mail.track.ui11.hw06.task02;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class TvMailPageTest {

    @Test
    @DisplayName("Check TV Channels List View")
    public void check_switching_tv_channels_list_view() {
        new TvMailPage()
                .open()
                .checkGridViewIsActive()
                .clickListButton()
                .checkListViewIsActive()
                .clickGridButton()
                .checkGridViewIsActive();
    }
}