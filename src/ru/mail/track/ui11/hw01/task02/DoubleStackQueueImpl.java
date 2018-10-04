package ru.mail.track.ui11.hw01.task02;

import java.util.EmptyStackException;
import java.util.Stack;

public class DoubleStackQueueImpl<E> implements DoubleStackQueue {
    private Stack<E> a = new Stack<>();
    private Stack<E> b = new Stack<>();

    @Override
    public boolean add(Object o) {
        try {
            if (!b.isEmpty()) {
                while (!b.isEmpty()) {
                    a.push(b.pop());
                }
            }
            a.push((E) o);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public E poll() {
        if (a.isEmpty() && b.isEmpty()) {
            throw new EmptyStackException();
        } else {
            while (!a.isEmpty()) {
                b.push(a.pop());
            }
            return b.pop();
        }
    }
}
