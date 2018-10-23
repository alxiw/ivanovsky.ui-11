package ru.mail.track.ui11.hw02.task01;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Класс, экземпляры которого предназначены
 * для передачи данных между потоками
 */
public class Buffer {

    private ConcurrentLinkedQueue<User> queue = new ConcurrentLinkedQueue<>();

    public void addQueue(User user){
        queue.add(user);
    }

    public User getQueue(){
        return queue.poll();
    }
}
