package ru.mail.track.ui11.hw01.task08;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.track.ui11.hw01.SysOutCaptureAndAssertionAbility;

import java.util.Arrays;
import java.util.List;

/**
 * Тест-класс для Задачи №8 - функции возвращающей
 * различные предикаты в зависимости от параметра
 */
public class SolutionTest implements SysOutCaptureAndAssertionAbility {

    private static final String RN = "\r\n";

    public static final List<Integer> numbers = Arrays.asList(2, 3, 1, 5, 6, 7, 8, 9, 12);

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
        int a = -4;

        numbers.stream().filter(Solution.intFunc(a)).forEach(System.out::println);

        String result = 2 + RN + 3 + RN + 1 + RN + 5;

        assertSysOutEquals(result + RN);
    }

}