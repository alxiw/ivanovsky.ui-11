package ru.mail.track.ui11.hw01.task04;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.track.ui11.hw01.SysOutCaptureAndAssertionAbility;

import java.util.*;

/**
 * Тест-класс для Задачи №4 - рекурсивной функции осуществляющей
 * вывод на экран всех элементов списка в обратном направлении
 */
public class SolutionTest implements SysOutCaptureAndAssertionAbility {

    private static final String RN = "\r\n";

    /*
     * Список для тестирования рекурсивной функции printReverseList
     */
    public static List<Integer> list = new ArrayList<>();

    static {
        /*
         * Диапазон и количество случайных значений для заполнения списка
         */
        int min = 1;
        int max = 100;
        int length = 10;

        /*
         * Создание и заполнение массива случайными числами от 1 до 100 для заполнения списка
         */
        int[] random = new int[length];
        for (int i = 0; i < length; i++) {
            random[i] = (int) (min - 0.5 + Math.random() * (max - min + 1));
        }

        /*
         * Заполняем список случайными числами, осуществляя проход по нему только с помощью Iterator
         */
        for (Integer i : random) {
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
         * Обработка списка функцией printReverseList и его вывод ею
         */
        Solution.printReverseList(list);
        System.out.println();

        Collections.reverse(list);

        StringBuilder sb = new StringBuilder();
        for (Integer integer : list) {
            String s = integer + " ";
            sb.append(s);
        }

        assertSysOutEquals(sb.toString() + RN);
    }

}