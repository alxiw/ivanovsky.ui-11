package ru.mail.track.ui11.uifinalwork.task01;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.mail.track.ui11.uifinalwork.task01.enumeration.Capture;

public class HoroMailPageTest {

    @Test
    @DisplayName("Check Sign By Date of Birth and Titles of Articles")
    public void check_sign_date_and_captions_on_page() {
        new HoroMailPage()
                .open()
                .parseSigns()
                .rememberTheDateOnThePage()
                .clickShowButton()
                .checkBirthday()
                .checkSign()
                .checkTitles(Capture.NUMBER.getName(), Capture.RUNA.getName(), Capture.MOON.getName(), Capture.CARD.getName());
    }
}