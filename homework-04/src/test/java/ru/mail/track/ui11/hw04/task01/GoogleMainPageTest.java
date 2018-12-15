package ru.mail.track.ui11.hw04.task01;

import org.junit.Test;
import ru.mail.track.ui11.hw04.BaseTest;

public class GoogleMainPageTest extends BaseTest {

    @Test
    public void type_text_in_search_field_check_counter() {
        new GoogleMainPage(driver)
                //Открываем главную страницу Google
                .open()
                //Вводим текст в поле поиска
                .typeSearchText("Hello, World!")
                //Жмём кнопку ввода
                .submitInput()
                //Проверяем наличие результатов
                .resultsShallBeShowed()
                //Проверяем счётчик результатов
                .counterOfResultsShallBeMoreThanZero();
    }
}
