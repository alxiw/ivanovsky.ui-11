package ru.mail.track.ui11.hw01.task05;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.track.ui11.hw01.SysOutCaptureAndAssertionAbility;

import java.util.*;

/**
 * Тест-класс для Задачи №5 - функции, дублирующей в списке
 * действительных чисел все положительные в обратном порядке
 */
public class SolutionTest implements SysOutCaptureAndAssertionAbility {

    private static final String RN = "\r\n";

    /*
     * Список для тестирования рекурсивной функции printReverseList
     */
    public static List<Double> list = new ArrayList<>();

    private static final double[] random = new double[]{-0.05, 2.12, 3.24, 0.08, 0.82, 0.05, 8.30, -0.03, -3.58, -8.76};

    static {
        for (Double i : random) {
            list.add(i);
        }
    }

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
        /*
         * Обработка списка функцией reversePositivesInList и его вывод ею
         */
        Solution.reversePositivesInList(list).stream().map(d -> String.format("%.2f", d) + " ").forEach(System.out::print);
        System.out.println();

        String result = "-0,05 8,30 0,05 0,82 0,08 3,24 2,12 -0,03 -3,58 -8,76 ";

        assertSysOutEquals(result + RN);
    }

}