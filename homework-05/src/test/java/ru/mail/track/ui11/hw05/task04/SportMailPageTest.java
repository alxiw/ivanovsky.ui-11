package ru.mail.track.ui11.hw05.task04;

import org.junit.Test;
import ru.mail.track.ui11.hw05.BaseTest;
import ru.mail.track.ui11.hw05.task04.enumeration.Article;
import ru.mail.track.ui11.hw05.task04.enumeration.Сhampionship;

public class SportMailPageTest extends BaseTest {

    @Test
    public void check_error_on_news_sport_page() {
        new SportMailPage(driver)
                .open()
                .checkAbsenceOfErrorTextOnPage();
        new NewsSportMailPage(driver)
                .open("news", Сhampionship.WC.getName(), Article.RUS_TEAM.getName())
                .checkAbsenceOfErrorTextOnPage();
    }
}
