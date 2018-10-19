package ru.mail.track.ui11.hw01.task03;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.track.ui11.hw01.SysOutCaptureAndAssertionAbility;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Тест-класс для Задачи №3 - реализации интерфейса двусторонней очереди c использованием стеков
 */
public class DoubleStackDequeTest implements SysOutCaptureAndAssertionAbility {

    private static final String RN = "\r\n";

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
    public void one() {
        /*
         * Тестирование реализации двусторонней очереди c использованием стеков
         * Ожидаемый результат:
         * 9 0 3 2
         */
        DoubleStackDeque dsd = new DoubleStackDequeImpl();
        dsd.add(2, true);
        dsd.add(3, true);
        dsd.add(0, true);
        dsd.add(9, true);
        System.out.print(dsd.poll(true) + " ");
        System.out.print(dsd.poll(true) + " ");
        System.out.print(dsd.poll(true) + " ");
        System.out.println(dsd.poll(true));

        /*
         * Тестирование эталонной двусторонней очереди для сравнения
         * Ожидаемый результат:
         * 9 0 3 2
         */
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(0);
        deque.addFirst(9);
        System.out.print(deque.pollFirst() + " ");
        System.out.print(deque.pollFirst() + " ");
        System.out.print(deque.pollFirst() + " ");
        System.out.println(deque.pollFirst());

        assertSysOutEquals("9 0 3 2" + RN + "9 0 3 2" + RN);
    }

    @Test
    public void two() {
        /*
         * Тестирование реализации двусторонней очереди c использованием стеков
         * Ожидаемый результат:
         * 9 0 3 2
         */
        DoubleStackDeque dsd = new DoubleStackDequeImpl();
        dsd.add(3, false);
        dsd.add(4, false);
        dsd.add(5, false);
        System.out.print(dsd.poll(false) + " ");
        System.out.print(dsd.poll(false) + " ");
        System.out.println(dsd.poll(false));

        /*
         * Тестирование эталонной двусторонней очереди для сравнения
         * Ожидаемый результат:
         * 9 0 3 2
         */
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        System.out.print(deque.pollLast() + " ");
        System.out.print(deque.pollLast() + " ");
        System.out.println(deque.pollLast());

        assertSysOutEquals("5 4 3" + RN + "5 4 3" + RN);
    }

    @Test
    public void three() {
        /*
         * Тестирование реализации двусторонней очереди c использованием стеков
         * Ожидаемый результат:
         * 5 7 6 9 200 8 100 4
         */
        DoubleStackDeque dsd = new DoubleStackDequeImpl();
        dsd.add(4, true);
        dsd.add(5, true);
        System.out.print(dsd.poll(true) + " ");
        dsd.add(6, false);
        dsd.add(7, false);
        System.out.print(dsd.poll(false) + " ");
        System.out.print(dsd.poll(false) + " ");
        dsd.add(8, true);
        dsd.add(9, true);
        dsd.add(100, false);
        dsd.add(200, false);
        System.out.print(dsd.poll(true) + " ");
        System.out.print(dsd.poll(false) + " ");
        System.out.print(dsd.poll(true) + " ");
        System.out.print(dsd.poll(false) + " ");
        System.out.println(dsd.poll(true));

        /*
         * Тестирование эталонной двусторонней очереди для сравнения
         * Ожидаемый результат:
         * 5 7 6 9 200 8 100 4
         */
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(4);
        deque.addFirst(5);
        System.out.print(deque.pollFirst() + " ");
        deque.addLast(6);
        deque.addLast(7);
        System.out.print(deque.pollLast() + " ");
        System.out.print(deque.pollLast() + " ");
        deque.addFirst(8);
        deque.addFirst(9);
        deque.addLast(100);
        deque.addLast(200);
        System.out.print(deque.pollFirst() + " ");
        System.out.print(deque.pollLast() + " ");
        System.out.print(deque.pollFirst() + " ");
        System.out.print(deque.pollLast() + " ");
        System.out.println(deque.pollFirst());

        assertSysOutEquals("5 7 6 9 200 8 100 4" + RN + "5 7 6 9 200 8 100 4" + RN);
    }
}