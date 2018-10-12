package ru.mail.track.ui11.hw01.task02;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Класс, реализующий интерфейс очереди c использованием двух стеков
 */
public class DoubleStackQueueImpl<E> implements DoubleStackQueue {

    /**
     * Два стека для хранения элементов
     */
    private Stack<E> one = new Stack<>();
    private Stack<E> two = new Stack<>();

    /**
     * Метод, добавляющий элемент в конец очереди
     * @param item элемент, который добавляется в конец очереди
     * @return true если элемент успешно помещён в очередь,
     *         false в противном случае
     * @exception Exception будет пойман в случае неудачного помещения элемента в очередь
     */
    @Override
    public boolean add(Object item) {
        try {
            if (!two.isEmpty()) {
                while (!two.isEmpty()) {
                    one.push(two.pop());
                }
            }
            one.push((E) item);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Метод, удаляющий элемент из начала очереди и возвращающий его
     * @return элемент, находящийся в начале очереди (самый первый элемент)
     * @throws EmptyStackException будет выброшен, если в очереди нет элементов
     */
    @Override
    public E poll() {
        if (one.isEmpty() && two.isEmpty()) {
            throw new EmptyStackException();
        } else {
            while (!one.isEmpty()) {
                two.push(one.pop());
            }
            return two.pop();
        }
    }

}
