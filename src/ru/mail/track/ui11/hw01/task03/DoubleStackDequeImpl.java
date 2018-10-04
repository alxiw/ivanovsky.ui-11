package ru.mail.track.ui11.hw01.task03;

import java.util.EmptyStackException;
import java.util.Stack;

public class DoubleStackDequeImpl<E> implements DoubleStackDeque {
    private Stack<E> one = new Stack<>();
    private Stack<E> two = new Stack<>();

    //true = first

    @Override
    public boolean add(Object o, boolean first) {
        if (first) {
            try {
                if (!two.isEmpty()) {
                    while (!two.isEmpty())
                        one.push(two.pop());
                }
                one.push((E) o);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            try {
                while (!one.isEmpty())
                    two.push(one.pop());
                two.push((E) o);
                return true;
            } catch (Exception e) {
                return false;
            }
        }

    }

    @Override
    public Object poll(boolean first) {
        if (first) {
            if (!two.isEmpty()) {
                while (!two.isEmpty())
                    one.push(two.pop());
            }
            return one.pop();
        } else {
            if (one.isEmpty() && two.isEmpty()) {
                throw new EmptyStackException();
            } else {
                while (!one.isEmpty())
                    two.push(one.pop());
                return two.pop();
            }

        }
    }
}
