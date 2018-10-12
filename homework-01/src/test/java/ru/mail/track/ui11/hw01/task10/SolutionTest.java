package ru.mail.track.ui11.hw01.task10;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.track.ui11.hw01.SysOutCaptureAndAssertionAbility;

/**
 * Тест-класс для Задачи №10 - канала передачи сообщений
 * из источника в приемник в несколько потоков, причём
 * сообщения должны поступать в канал передачи каждую секунду
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