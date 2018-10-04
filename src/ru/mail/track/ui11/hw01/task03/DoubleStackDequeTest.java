package ru.mail.track.ui11.hw01.task03;

import java.util.ArrayDeque;
import java.util.Deque;

public class DoubleStackDequeTest {


    public static void main(String[] args) {
        DoubleStackDeque<Integer> deque = new DoubleStackDequeImpl<>();

        deque.add(4, true);
        deque.add(5, true);
        System.out.println(deque.poll(true));
        deque.add(6, false);
        deque.add(7, false);
        System.out.println(deque.poll(false));
        System.out.println(deque.poll(false));
        deque.add(8, true);
        deque.add(9, true);
        deque.add(100, false);
        deque.add(200, false);
        System.out.println(deque.poll(true));
        System.out.println(deque.poll(false));
        System.out.println(deque.poll(true));
        System.out.println(deque.poll(false));
        System.out.println(deque.poll(true));
        //576920081004

        System.out.println();

        Deque<Integer> realDeque = new ArrayDeque<>();
        realDeque.addFirst(4);
        realDeque.addFirst(5);
        System.out.println(realDeque.pollFirst());
        realDeque.addLast(6);
        realDeque.addLast(7);
        System.out.println(realDeque.pollLast());
        System.out.println(realDeque.pollLast());
        realDeque.addFirst(8);
        realDeque.addFirst(9);
        realDeque.addLast(100);
        realDeque.addLast(200);
        System.out.println(realDeque.pollFirst());
        System.out.println(realDeque.pollLast());
        System.out.println(realDeque.pollFirst());
        System.out.println(realDeque.pollLast());
        System.out.println(realDeque.pollFirst());
        //576920081004
    }


}
