package ru.mail.track.ui11.uifinalwork.task02;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class DetiMailPageTest {

    @Test
    @DisplayName("Check News")
    public void check_news_on_page() {
        new DetiMailPage()
                .open()
                .findSmartBand()
                .clickNewsItem(1)
                .checkHeader();
    }
}