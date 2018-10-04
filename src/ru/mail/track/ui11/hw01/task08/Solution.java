package ru.mail.track.ui11.hw01.task08;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Solution {

    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(2, 3, 1, 5, 6, 7, 8, 9, 12);

        int a = -4;

        nums.stream().filter(intFunc(a)).forEach(System.out::println);
    }

    private static Predicate<Integer> intFunc(int intFunc1) {
        Predicate<Integer> predicate1 = n -> n > 5;
        Predicate<Integer> predicate2 = n -> n <= 5;
        return intFunc1 > 0 ? predicate1 : predicate2;
    }

}
