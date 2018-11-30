package ru.mail.track.ui11.hw04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.mail.track.ui11.hw04.data.BrowserFactory;
import ru.mail.track.ui11.hw04.drivers.WebDriverFactory;
import ru.mail.track.ui11.hw04.pages.NameSecretHoroMailPage;

public class NameSecretHoroMailPageTest {

    private WebDriver driver = null;

    @Before
    public void init() {
        driver = WebDriverFactory.getWebDriverInstance(BrowserFactory.getBrowser(System.getProperty("webdriver.driver")));
    }

    @After
    public void killSession() {
        driver.close();
        driver.quit();
    }

    @Test
    public void check_the_ability_to_find_name(){
        new NameSecretHoroMailPage(driver)
                .open()
                .typeSearchName("Арина")
                .submitInput()
                .clickFirstSuggestedItem()
                .checkInfoAboutSelectedName();
    }

    @Test
    public void check_the_ability_to_find_name_with_popup_suggestions(){
        new NameSecretHoroMailPage(driver)
                .open()
                .typeSearchName("Арин")
                .checkSuggestionsInPopUp()
                .pressSuggestedElementInPopUp()
                .submitInput()
                .clickFirstSuggestedItem()
                .checkInfoAboutSelectedName();
    }

    @Test
    public void check_the_ability_to_select_gender(){
        new NameSecretHoroMailPage(driver)
                .open()
                .typeSearchName("Саша")
                .openGenderPopUp()
                .selectGenderInPopUp()
                .submitInput()
                .clickFirstSuggestedItem()
                .checkInfoAboutSelectedName();
    }

    @Test
    public void check_letter_button(){
        String letter = "М";
        new NameSecretHoroMailPage(driver)
                .open()
                .pressLetterButton(letter)
                .checkActiveLetterButton(letter);
    }

}
