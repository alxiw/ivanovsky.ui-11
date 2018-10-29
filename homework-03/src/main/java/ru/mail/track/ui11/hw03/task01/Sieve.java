package ru.mail.track.ui11.hw03.task01;

import java.util.Arrays;

/**
 * Задача №1 - Простые числа
 *
 * Дано целое число N
 * Необходимо вывести массив простых чисел от 0 до N
 */
public class Sieve {

    private Sieve() {
        //private constructor
    }

    public static void printAllPrimes(int n) {
        int[] primes = findAllPrimes(n);
        if (primes.length > 0) {
            for (int i = 0; i < primes.length - 1; i++) {
                System.out.print(primes[i] + " ");
            }
            System.out.println(primes[primes.length - 1]);
        }
    }

    private static int[] findAllPrimes(int n) {
        if (n < 0) {
            throw new ArithmeticException();
        } else if (n < 1) {
            return new int[0];
        } else {
            boolean[] primes = new boolean[n + 1];
            Arrays.fill(primes, true);
            primes[0] = false;
            primes[1] = false;
            for (int i = 2; i < primes.length; ++i) {
                if (primes[i]) {
                    for (int j = 2; i * j < primes.length; ++j) {
                        primes[i * j] = false;

                    }
                }
            }

            int count = 0;
            for (boolean prime : primes) {
                if (!prime) {
                    count++;
                }
            }

            int[] result = new int[primes.length - count];
            int j = 0;
            for (int i = 0; i < primes.length; i++) {
                if (primes[i]) {
                    result[j] = i;
                    j++;
                }
            }
            return result;
        }
    }
}
