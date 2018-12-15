package ru.mail.track.ui11.hw05.task05;

import org.junit.Test;
import ru.mail.track.ui11.hw05.BaseTest;
import ru.mail.track.ui11.hw05.task05.enumeration.Article;

public class ArticlePetsMailPageTest extends BaseTest {

    @Test
    public void check_that_an_article_have_a_date_of_publication() {
        new ArticlePetsMailPage(driver)
                .open("how-to", Article.RAZ.getName())
                .checkExistenceOfPublicationTime();
    }
}
