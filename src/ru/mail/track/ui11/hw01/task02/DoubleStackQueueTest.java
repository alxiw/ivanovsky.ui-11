package ru.mail.track.ui11.hw01.task02;

public class DoubleStackQueueTest {
    public static void main(String[] args) {
        DoubleStackQueue<Integer> queue = new DoubleStackQueueImpl<>();

        queue.add(4);
        queue.add(5);
        System.out.println(queue.poll());
        queue.add(6);
        queue.add(7);
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }
}
