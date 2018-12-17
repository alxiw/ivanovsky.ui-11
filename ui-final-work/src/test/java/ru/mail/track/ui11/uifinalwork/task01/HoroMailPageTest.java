package ru.mail.track.ui11.uifinalwork.task01;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.mail.track.ui11.uifinalwork.task01.enumeration.Capture;

public class HoroMailPageTest {

    @Test
    @DisplayName("Check Horo")
    public void check_articles_and_date_on_page() {
        new HoroMailPage()
                .open()
                .rememberTheDateOnThePage()
                .clickShowAllButton()
                .checkBirthday()
                .checkCaptions(Capture.NUMBER.getName(), Capture.RUNA.getName(), Capture.MOON.getName(), Capture.CARD.getName());
    }
}