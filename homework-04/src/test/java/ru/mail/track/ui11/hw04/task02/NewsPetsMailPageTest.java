package ru.mail.track.ui11.hw04.task02;

import org.junit.Test;
import ru.mail.track.ui11.hw04.BaseTest;

public class NewsPetsMailPageTest extends BaseTest {

    @Test
    public void check_expand_button_functionality() {
        new NewsPetsMailPage(driver)
                .open()
                .captureInitialNewsItems()
                .pressExpandButton()
                .captureNewsItemsAfterExpansion()
                .checkThatNumberOfNewsItemsIncreased();
    }
}
