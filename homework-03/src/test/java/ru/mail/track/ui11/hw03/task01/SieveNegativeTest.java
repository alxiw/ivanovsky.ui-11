package ru.mail.track.ui11.hw03.task01;

import org.hamcrest.Matchers;
import org.junit.*;

/**
 * Тест-класс негативных тестов к задаче №1
 */
public class SieveNegativeTest {

    @Test(expected = ArithmeticException.class)
    public void printPrimesToMinusTwo() {
        String actual = Sieve.printAllPrimes(-2);
    }

    @Test
    public void printPrimesToZero() {
        String actual = Sieve.printAllPrimes(0);
        String expected = "";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printPrimesToOne() {
        String actual = Sieve.printAllPrimes(1);
        String expected = "";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printPrimesToChar() {
        String actual = Sieve.printAllPrimes('a');
        String end = "97";
        Assert.assertThat(actual, Matchers.containsString(end));
    }
}
