package ru.mail.track.ui11.hw04.task03;

import org.junit.Test;
import ru.mail.track.ui11.hw04.BaseTest;
import ru.mail.track.ui11.hw04.task03.enumeration.Gender;

public class NameSecretHoroMailPageTest extends BaseTest {

    @Test
    public void check_search_names_by_letter(){
        new NameSecretHoroMailPage(driver)
                .open()
                .clickLetter("м")
                .checkPresenceOfNamesStartsWithChosenLetter()
                .clickName("Моисей")
                .checkInfoAboutSelectedName();
    }

    @Test
    public void check_search_the_name_directly(){
        new NameSecretHoroMailPage(driver)
                .open()
                .enterNameInInputField("Арина")
                .submitInput()
                .clickItemCompletelyMatchesTheName()
                .checkInfoAboutSelectedName();
    }

    @Test
    public void check_search_the_name_using_suggestions(){
        new NameSecretHoroMailPage(driver)
                .open()
                .enterNameInInputField("Арин")
                .clickFirstElementStartsWithEnteredNameInSuggestions()
                .submitInput()
                .clickItemCompletelyMatchesTheName()
                .checkInfoAboutSelectedName();
    }

    @Test
    public void check_search_the_name_by_gender(){
        new NameSecretHoroMailPage(driver)
                .open()
                .enterNameInInputField("Саша")
                .openGenderMenu()
                .selectGender(Gender.FEMALE)
                .submitInput()
                .clickItemCompletelyMatchesTheName()
                .checkInfoAboutSelectedName();
    }
}
