package ru.mail.track.ui11.hw01.task03;

public interface DoubleStackDeque<E> {
    boolean add(E e, boolean first);
    E poll(boolean first);
}
