package ru.mail.track.ui11.hw01.task09;

/**
 * Задача №9
 *
 * Напишите программу, которая каждые 2 секунды отображает на экране данные о времени,
 * прошедшем от начала сессии, а другой ее поток выводит сообщение каждые 10 секунд
 */
public class Solution {

    /*
     * Временной интервал в мс, через который выводятся данные о времени, прошедшем от начала сессии
     */
    private static final long SHORT_TIME = 2000L;

    /*
     * Временной интервал в мс, через который выводится сообщение
     */
    private static final long LONG_TIME = 10000L;

    private static final String MESSAGE = "Welcome to the Machine!";

    public static void main(String[] args) {
        /*
         * Создание и инициализация потоков
         */
        Stopwatch stopwatch = new Stopwatch(SHORT_TIME);
        Notification notification = new Notification(LONG_TIME, MESSAGE);

        Thread one = new Thread(stopwatch);
        Thread two = new Thread(notification);

        /*
         * Запуск потоков
         */
        one.start();
        two.start();
    }

}
