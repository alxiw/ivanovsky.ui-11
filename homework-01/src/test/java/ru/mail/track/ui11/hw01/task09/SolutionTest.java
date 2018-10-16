package ru.mail.track.ui11.hw01.task09;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.track.ui11.hw01.SysOutCaptureAndAssertionAbility;

/**
 * Тест-класс для Задачи №9 - программы, которая каждые 2 секунды
 * отображает на экране данные о времени, прошедшем от начала сессии,
 * а другой ее поток выводит сообщение каждые 10 секунд
 */
public class SolutionTest implements SysOutCaptureAndAssertionAbility {

    @Before
    public void setUpSystemOut() {
        resetOut();
        captureSysOut();
    }

    @After
    public void tearDown() {
        resetOut();
    }

    @Test
    public void main() {
        //TODO
    }

}