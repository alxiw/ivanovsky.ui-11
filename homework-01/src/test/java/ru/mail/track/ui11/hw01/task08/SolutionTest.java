package ru.mail.track.ui11.hw01.task08;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.track.ui11.hw01.SysOutCaptureAndAssertionAbility;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Тест-класс для Задачи №8 - функции возвращающей
 * различные предикаты в зависимости от параметра
 */
public class SolutionTest implements SysOutCaptureAndAssertionAbility {

    private static final String RN = "\r\n";

    private static Predicate predicate1 = x -> true;
    private static Predicate predicate2 = x -> false;
    private static Function<Integer, Integer> intFunc = number -> number - 15;

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
        System.out.println(Solution.getFunctionIntegerToPredicate(predicate1, predicate2).apply(intFunc.apply(10)).test(""));
        System.out.println(Solution.getFunctionIntegerToPredicate(predicate1, predicate2).apply(intFunc.apply(-10)).test(""));

        assertSysOutEquals(true + RN + false + RN);
    }

}