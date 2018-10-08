package ru.mail.track.ui11.hw01.task03;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Класс, реализующий интерфейс двусторонней очереди c использованием стеков
 */
public class DoubleStackDequeImpl<E> implements DoubleStackDeque {

    /**
     * Два стека для хранения элементов
     */
    private Stack<E> one = new Stack<>();
    private Stack<E> two = new Stack<>();

    /**
     * Метод, добавляющий элемент в двустороннюю очередь
     * @param item элемент, который добавляется в очередь
     * @param first параметр, определяющий сторону очереди для добавления элемента
     *              true если элемент нужно поместить в начало,
     *              false если элемент нужно поместить в конец
     * @return true если элемент успешно помещён в очередь,
     *         false в противном случае
     * @exception Exception будет пойман в случае неудачного помещения элемента в очередь
     */
    @Override
    public boolean add(Object item, boolean first) {
        if (first) {
            try {
                if (!two.isEmpty()) {
                    while (!two.isEmpty())
                        one.push(two.pop());
                }
                one.push((E) item);
                return true;
            } catch (Exception e) {
                return false;
            }
        } else {
            try {
                while (!one.isEmpty())
                    two.push(one.pop());
                two.push((E) item);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
    }

    /**
     * Метод, удаляющий элемент из двусторонней очереди и возвращающий его
     * @param first параметр, определяющий сторону очереди для забора элемента
     *              true если элемент нужно забрать из начала,
     *              false если элемент нужно забрать с конца
     * @return элемент, находящийся в очереди (самый первый элемент или самый последний в зависимости от параметра)
     * @throws EmptyStackException будет выброшен, если в очереди нет элементов
     */
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
