package ru.mail.track.ui11.hw01.task02;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.track.ui11.hw01.SysOutCaptureAndAssertionAbility;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Тест-класс для Задачи №2 - реализации интерфейса очереди c использованием двух стеков
 */
public class DoubleStackQueueTest implements SysOutCaptureAndAssertionAbility {

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
    public void main() {
        /*
         * Тестирование реализации очереди c использованием двух стеков
         * Ожидаемый результат:
         * 4 5 6 7
         */
        DoubleStackQueueImpl dsq = new DoubleStackQueueImpl();
        dsq.add(4);
        dsq.add(5);
        System.out.print(dsq.poll() + " ");
        dsq.add(6);
        dsq.add(7);
        System.out.print(dsq.poll() + " ");
        System.out.print(dsq.poll() + " ");
        System.out.println(dsq.poll());

        /*
         * Тестирование эталонной очереди для сравнения
         * Ожидаемый результат:
         * 4 5 6 7
         */
        Queue queue = new LinkedList();
        queue.add(4);
        queue.add(5);
        System.out.print(queue.poll() + " ");
        queue.add(6);
        queue.add(7);
        System.out.print(queue.poll() + " ");
        System.out.print(queue.poll() + " ");
        System.out.println(queue.poll());

        assertSysOutEquals("4 5 6 7" + RN + "4 5 6 7" + RN);
    }

}