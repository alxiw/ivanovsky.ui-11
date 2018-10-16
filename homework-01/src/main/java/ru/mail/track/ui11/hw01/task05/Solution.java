package ru.mail.track.ui11.hw01.task05;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Задача №5
 *
 * Имеется список действительных чисел
 * Продублировать в нем все положительные числа в обратном порядке их следования в списке
 * Использовать можно только Iterator и реализовать необходимо при помощи рекурсии
 */
public class Solution {

    /**
     * Реализация функции, дублирующей в списке действительных чисел все положительные в обратном порядке
     * @param list список, положительные элементы которого функция переставляет в обратном порядке
     * @return тот же список, положительные элементы которого переставлены в обратном порядке
     */
    public static List<Double> reversePositivesInList(List<Double> list) {
        Iterator<Double> iteratorFirst = list.iterator();
        while (iteratorFirst.hasNext()) {
            Double itemFirst = iteratorFirst.next();
            if (itemFirst > 0) {
                int a = list.indexOf(itemFirst);
                int b = 0;

                Collections.reverse(list);
                Iterator<Double> iteratorLast = list.iterator();
                while (iteratorLast.hasNext()) {
                    Double itemLast = iteratorLast.next();
                    if (itemLast > 0) {
                        b = list.indexOf(itemLast);
                        double temp = list.get(list.size()-1-a);
                        list.set(list.size()-1-a, list.get(b));
                        list.set(b, temp);
                        break;
                    }
                }
                Collections.reverse(list);
                if (a + 1 < list.size()-1-b) {
                    reversePositivesInList(list.subList(a + 1, list.size()-1-b));
                }
                break;
            }
        }
        return list;
    }

}
