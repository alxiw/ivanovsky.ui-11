package ru.mail.track.ui11.hw01.task09;

import java.time.Duration;
import java.time.LocalTime;

import static java.lang.Thread.sleep;

/**
 * Задача №9
 *
 * Напишите программу, которая каждые 2 секунды отображает на экране данные о времени,
 * прошедшем от начала сессии, а другой ее поток выводит сообщение каждые 10 секунд
 */
public class Stopwatch {

    /*
     * Временной интервал в мс, через который выводятся данные о времени, прошедшем от начала сессии
     */
    private static final long SHORT_TIME = 2000L;

    /*
     * Временной интервал в мс, через который выводится сообщение
     */
    private static final long LONG_TIME = 10000L;

    public static void main(String[] args) {

        /*
         * Создание и инициализация потока, выводящее время с начала сессии каждые 2 секунды
         */
        Thread thread = new Thread(() -> {
            LocalTime startTime = LocalTime.now();
            try {
                while (!Thread.currentThread().isInterrupted()) {
                    sleep(SHORT_TIME);
                    Duration duration = Duration.between(startTime, LocalTime.now());
                    System.out.println(duration.getSeconds() + " seconds passed");
                }
            } catch (InterruptedException e) {
                System.out.println("Interrupted Exception in secondary thread: " + e.getMessage());
            }
        });

        /*
         * Запуск потока, выводящее время с начала сессии каждые 2 секунды
         */
        thread.setDaemon(true);
        thread.start();

        /*
         * Вывод сообщения основным потоком каждые 10 секунд
         */
        try {
            while (!Thread.currentThread().isInterrupted()) {
                sleep(LONG_TIME);
                System.out.println("Welcome to the Machine!");
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted Exception in main thread: " + e.getMessage());
        }
    }

}
