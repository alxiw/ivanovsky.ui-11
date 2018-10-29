package ru.mail.track.ui11.hw03.task01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.track.ui11.hw03.SysOutCaptureAndAssertionAbility;

/**
 * Тест-класс позитивных тестов к задаче №1
 */
public class SievePositiveTest implements SysOutCaptureAndAssertionAbility {

    @Before
    public void setUpSystemOut() {
        captureSysOut();
    }

    @After
    public void tearDown() {
        resetOut();
    }

    @Test
    public void printPrimesToTwo() {
        Sieve.printAllPrimes(2);
        assertSysOutEquals("2" + RN);
    }

    @Test
    public void printPrimesToTen() {
        Sieve.printAllPrimes(10);
        assertSysOutEquals("2 3 5 7" + RN);
    }

    @Test
    public void printPrimesToOneHundred() {
        Sieve.printAllPrimes(100);
        assertSysOutEquals("2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97" + RN);
    }

    @Test
    public void printPrimesToTenMillions() {
        Sieve.printAllPrimes(10_000_000);
        String start = "2 3 5 7 11 13 17 19 23 29";
        String end = "9999889 9999901 9999907 9999929 9999931 9999937 9999943 9999971 9999973 9999991";
        assertSysOutContains(start);
        assertSysOutContains(end);
    }

}
