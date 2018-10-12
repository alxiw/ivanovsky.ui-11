package ru.mail.track.ui11.hw01.task10;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Задача №10
 *
 * Организовать канал передачи сообщений из источника в приемник в несколько потоков
 * Сообщения должны поступать в канал передачи каждую секунду
 * Каждое сообщение должно содержать id виде кеша объекта сообщения
 *
 * Чтение данных из источника и запись их в приемник, должны осуществляться в разных потоках
 * Можно использовать ExecutorService
 */
public class Solution {

    public static void main(String[] args) throws IOException, InterruptedException {

        final PipedInputStream pis = new PipedInputStream();
        final PipedOutputStream pos = new PipedOutputStream();

        pis.connect(pos);

        /*
         * Поток для записи данных в трубу
         */
        Thread pipeWriter = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    pos.write(new Object().hashCode());
                    Thread.sleep(1000);
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        /*
         * Поток для чтения данных из трубы
         */
        Thread pipeReader = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    System.out.print((char)pis.read());
                    Thread.sleep(1000);
                } catch (InterruptedException | IOException e) {
                    e.printStackTrace();
                }
            }
        });

        /*
         * Старт потоков
         */
        pipeWriter.start();
        pipeReader.start();

        /*
         * Ожидание потоков
         */
        pipeWriter.join();
        pipeReader.join();

        /*
         * Закрытие потоков
         */
        pos.close();
        pis.close();

    }

}
