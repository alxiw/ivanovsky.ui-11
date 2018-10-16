package ru.mail.track.ui11.hw01.task09;

import static java.lang.Thread.sleep;

public class Notification implements Runnable {

    private long duration;
    private String message;

    public Notification(long duration, String message) {
        this.duration = duration;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                sleep(duration);
                printNotification(message);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception in main thread: " + e.getMessage());
        }
    }

    /*
     * Вывод сообщения
     */
    private void printNotification(String message) {
        System.out.println(message);
    }
}
