package ru.mail.track.ui11.hw03.task01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.track.ui11.hw03.SysOutCaptureAndAssertionAbility;

/**
 * Тест-класс негативных тестов к задаче №1
 */
public class SieveNegativeTest implements SysOutCaptureAndAssertionAbility {

    @Before
    public void setUpSystemOut() {
        captureSysOut();
    }

    @After
    public void tearDown() {
        resetOut();
    }

    @Test(expected = ArithmeticException.class)
    public void printPrimesToMinusTwo() {
        Sieve.printAllPrimes(-2);
    }

    @Test
    public void printPrimesToZero() {
        Sieve.printAllPrimes(0);
        assertSysOutEquals("");
    }

    @Test
    public void printPrimesToOne() {
        Sieve.printAllPrimes(1);
        assertSysOutEquals("");
    }

    @Test
    public void printPrimesToChar() {
        Sieve.printAllPrimes('a');
        assertSysOutContains("97");
    }
}
