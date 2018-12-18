package ru.mail.track.ui11.hw07.task01;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import ru.mail.track.ui11.hw07.task01.enumeration.Section;
import ru.mail.track.ui11.hw07.task01.enumeration.Service;

public class NewsMailPageTest {

    @Test
    @DisplayName("Check Share Buttons")
    public void check_share_buttons_on_page() {
        new NewsMailPage()
                .open()
                .clickArticleInSection(Section.ECONIMICS, 1)
                .clickShareButton(Service.TWITTER)
                .closeShareWindow();
    }
}