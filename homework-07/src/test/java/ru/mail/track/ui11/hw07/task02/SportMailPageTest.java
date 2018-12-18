package ru.mail.track.ui11.hw07.task02;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class SportMailPageTest {

    @Test
    @DisplayName("Check Remark Popup")
    public void check_remark_popup_on_page() {
        new SportMailPage()
                .open()
                .clickMainArticleOnThePage()
                .selectText()
                .pressControlAndEnter()
                .closePopup()
                .checkThatPopupIsClosed();
    }
}