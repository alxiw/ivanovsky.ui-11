package ru.mail.track.ui11.hw01.task08;

import java.util.function.Predicate;

/**
 * Задача №8
 *
 * Даны функция intFunc и два предиката predicate1 и predicate2
 * Напишите функцию, которая вернет predicate1, если intFunc1 > 0
 * и вернет predicate2, если intFunc1 <= 0
 */
public class Solution {

    /**
     * Реализация функции, возвращающей различные предикаты в зависимости от параметра
     * @param intFunc1 параметр, являющийся целым числом
     * @return predicate1 если параметр > 0
     *         predicate2 если параметр <=0
     */
    public static Predicate<Integer> intFunc(int intFunc1) {
        Predicate<Integer> predicate1 = n -> n > 5;
        Predicate<Integer> predicate2 = n -> n <= 5;
        return intFunc1 > 0 ? predicate1 : predicate2;
    }

}
