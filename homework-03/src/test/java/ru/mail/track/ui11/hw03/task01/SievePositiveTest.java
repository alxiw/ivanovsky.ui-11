package ru.mail.track.ui11.hw03.task01;

import org.hamcrest.Matchers;
import org.junit.*;

/**
 * Тест-класс позитивных тестов к задаче №1
 */
public class SievePositiveTest {

    @Test
    public void printPrimesToTwo() {
        String actual = Sieve.printAllPrimes(2);
        String expected = "2";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printPrimesToTen() {
        String actual = Sieve.printAllPrimes(10);
        String expected = "2 3 5 7";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printPrimesToOneHundred() {
        String actual = Sieve.printAllPrimes(100);
        String expected = "2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void printPrimesToOneMillion() {
        String actual = Sieve.printAllPrimes(1_000_000);
        String start = "2 3 5 7 11 13 17 19 23 29";
        String end = "999863 999883 999907 999917 999931 999953 999959 999961 999979 999983";
        Assert.assertThat(actual, Matchers.containsString(start));
        Assert.assertThat(actual, Matchers.containsString(end));
    }
}
