package ru.mail.track.ui11.uifinalwork.task05;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

public class PogodaMailPageTest {

    @Test
    @DisplayName("Check Articles List View")
    public void check_articles_list_view() {
        new PogodaMailPage()
                .open()
                .clickAnyNewsItem()
                .closeArticleWindow();
    }

}