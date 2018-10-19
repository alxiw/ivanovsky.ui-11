package ru.mail.track.ui11.hw01.task11;

import java.io.File;
import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * Задача №11
 *
 * Организовать канал передачи сообщений и обработку строк, прочитанных из txt-файла
 *
 * Дан текстовый файл
 * Необходимо его прочитать построчно и передать на обработку строк
 * В каждой прочитанной строке необходимо заменить все числа на символы XXX
 * Обработанную строку необходимо передать через канал на запись в файл отчета
 *
 * Программу нужно написать с использованием многопоточности
 * Можно использовать ExecutorService
 */
public class Solution {

    /**
     * Главный метод программы, организующей канал передачи сообщений и обработку строк
     * @param args аргументы командной строки, массив, в котором
     *             первый элемент - путь к исходному файлу
     *             второй элемент - путь к файлу, в который будет осуществлена передача
     * @throws IOException исключение, отлавливаесое при неправильном закрытии потоков
     *                     или неправильном подключении труб
     * @throws InterruptedException исключение, отлавливаесое при неправильном ожидании потоков
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        sendMessageThroughPipeFromFileToFile(new File(args[0]), new File(args[1]));
    }

    /**
     * Функция, организующая канал передачи сообщений и обработку строк
     * @param source файл, из которого считываются данные
     * @param output файл, в который передаются данные
     * @throws IOException исключение, отлавливаесое при неправильном закрытии потоков
     *                     или неправильном подключении труб
     * @throws InterruptedException исключение, отлавливаесое при неправильном ожидании потоков
     */
    public static void sendMessageThroughPipeFromFileToFile(File source, File output) throws InterruptedException, IOException {

        try (PipedInputStream pis = new PipedInputStream();
             PipedOutputStream pos = new PipedOutputStream()) {

            /*
             * Соединение труб
             */
            pis.connect(pos);

            /*
             * Поток для записи данных в трубу
             */
            Reader reader = new Reader(pos, source);
            Thread one = new Thread(reader);

            /*
             * Поток для чтения данных из трубы и записи данных в файл
             */
            Writer writer = new Writer(pis, output);
            Thread two = new Thread(writer);

            one.start();
            one.join();

            two.start();
            two.join();
        }
    }
}
