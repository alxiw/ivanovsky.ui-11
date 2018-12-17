package ru.mail.track.ui11.hw05.task01;

import org.junit.Test;
import ru.mail.track.ui11.hw05.BaseTest;

public class PogodaMailPageTest extends BaseTest {

    @Test
    public void check_adding_city_to_favorites() {
        new DefaultCityPogodaMailPage(driver)
                .open()
                .moveCursorToCityDropdown()
                .checkCurrentCity()
                .onlyCurrentCityShallBeInFavorites()
                .typeSearchText("Берлин")
                .clickFirstSuggestedCity()
                .moveCursorToCityDropdown()
                .checkCurrentCity()
                .addCityToFavorites()
                .moveCursorToCityDropdown()
                .cityShallBePresentedInDropdown();
    }
}
