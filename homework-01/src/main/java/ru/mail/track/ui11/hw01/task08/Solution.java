package ru.mail.track.ui11.hw01.task08;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Задача №8
 *
 * Даны функция intFunc и два предиката predicate1 и predicate2
 * Напишите функцию, которая вернет predicate1, если intFunc1 > 0
 * и вернет predicate2, если intFunc1 <= 0
 */
public class Solution {

    private static Function<Integer, Integer> intFunc1 = number -> number + 15;

    /**
     * Реализация функции, возвращающей различные предикаты в зависимости от параметра
     * @param predicate1 предиката, для случая intFunc > 0
     * @param predicate2 предиката, для случая intFunc <= 0
     * @return соответствующая предиката
     */
    public static Function<Integer, Predicate> getFunctionIntegerToPredicate(Predicate predicate1, Predicate predicate2) {
        return i -> intFunc1.apply(i) > 0 ? predicate1 : predicate2;
    }

}
