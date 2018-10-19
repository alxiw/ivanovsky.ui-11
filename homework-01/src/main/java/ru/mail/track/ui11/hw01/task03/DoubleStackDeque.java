package ru.mail.track.ui11.hw01.task03;

/**
 * Задача №3
 *
 * Напишите класс, который реализует интерфейс двусторонней очереди c использованием стеков
 */
public interface DoubleStackDeque<E> {
    boolean add(E e, boolean first);
    E poll(boolean first);
}
