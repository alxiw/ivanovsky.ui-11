package ru.mail.track.ui11.hw01.task02;

/**
 * Задача №2
 *
 * Напишите класс, который реализует интерфейс очереди c использованием двух стеков
 */
public interface DoubleStackQueue<E> {
    boolean add(E e);
    E poll();
}
