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

    /**
     * Метод, выводящий все простые числа от 0 до n
     * @param n число от 0 до которого необходимо вывести все простые числа
     * @return строка, содержащая все простые числа от 0 до n
     */
    public static String printAllPrimes(int n) {
        int[] primes = findAllPrimes(n);
        StringBuilder sb = new StringBuilder();
        if (primes.length > 0) {
            for (int i = 0; i < primes.length; i++) {
                sb.append(primes[i] + " ");
            }
            sb.deleteCharAt(sb.toString().length()-1);
            System.out.println(sb.toString());
        }
        return sb.toString();
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
