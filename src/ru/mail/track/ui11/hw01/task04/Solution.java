package ru.mail.track.ui11.hw01.task04;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            list.add((int) (1 - 0.5 + Math.random() * (100 - 1 + 1)));
        }

        list.forEach(System.out::println);
        System.out.println();
        printReverse(list);

    }

    private static void printReverse(List list) {
        if (list.size() != 0) {
            System.out.println(list.get(list.size()-1));
            list.remove(list.size()-1);
            printReverse(list);
        }
    }

}
