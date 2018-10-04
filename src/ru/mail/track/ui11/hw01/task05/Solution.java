package ru.mail.track.ui11.hw01.task05;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(-1);
        list.add(1);
        list.add(2);
        list.add(-2);
        list.add(3);
        list.add(-20);
        list.add(4);
        list.add(5);
        list.add(-10);

        list.forEach(System.out::println);
        System.out.println();
        reversePositives(list).forEach(System.out::println);
    }

    private static List<Integer> reversePositives(List<Integer> list) {
        for (Integer itemFirst : list) {
            if (itemFirst > 0) {
                int a = list.indexOf(itemFirst);
                int b = 0;

                Collections.reverse(list);
                for (Integer itemLast : list) {
                    if (itemLast > 0) {
                        b = list.indexOf(itemLast);
                        int temp = list.get(list.size()-1-a);
                        list.set(list.size()-1-a, list.get(b));
                        list.set(b, temp);
                        break;
                    }
                }
                Collections.reverse(list);
                if (a + 1 < list.size()-1-b) {
                    reversePositives(list.subList(a + 1, list.size()-1-b));
                }
                break;
            }
        }
        return list;
    }
}
