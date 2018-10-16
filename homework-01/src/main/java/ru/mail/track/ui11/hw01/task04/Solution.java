package ru.mail.track.ui11.hw01.task04;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Задача №4
 *
 * Написать рекурсивную функцию, которая осуществляет вывод на экран
 * всех элементов списка в обратном направлении, начиная с последнего элемента
 * Проход по списку нужно осуществлять только с помощью итератора
 */
public class Solution {

    /**
     * Реализация рекурсивного функции осуществляющей вывод на экран
     * всех элементов списка в обратном направлении
     * @param list список, элементы которого функция в обратном порядке выводит на экран
     */
    public static void printReverseList(List list) {
        if (list.iterator().hasNext()) {
            System.out.print(list.get(list.size()-1) + " ");
            printReverseList(list.subList(0, list.size()-1));
        }
    }

}
