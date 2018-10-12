package ru.mail.track.ui11.hw01.task11;

import java.io.*;
import java.nio.charset.Charset;

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
    public static void sendMessageThroughPipeFromFileToFile(File source, File output) throws IOException, InterruptedException {
        final PipedInputStream pis = new PipedInputStream();
        final PipedOutputStream pos = new PipedOutputStream();

        pis.connect(pos);

        /*
         * Поток для записи данных в трубу
         */
        Thread pipeWriter = new Thread(() -> {
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(source), Charset.forName("UTF-8")));
                String line;
                while ((line = reader.readLine()) != null) {
                    char[] values = censor(line).toCharArray();
                    for (char value : values)
                        pos.write(value);
                    pos.write('\r');
                    pos.write('\n');
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        });

        /*
         * Поток для чтения данных из трубы и записи данных в файл
         */
        Thread pipeReader = new Thread(() -> {
            try {
                FileWriter writer = new FileWriter(output);
                StringBuilder sb = new StringBuilder();
                while (pis.available() != 0) {
                    char y = (char) pis.read();
                    if (y != '\n') {
                        sb.append(String.valueOf(y));
                    } else {
                        writer.write(sb.toString());
                        writer.write("\n");
                        sb = new StringBuilder();
                    }
                    Thread.sleep(10);
                }
                writer.close();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
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

    /**
     * Функция, заменяющая в строке каждый числовой символ на X
     * @param line строка
     * @return строка, в которой каждый числовой символ заменён на X
     */
    private static String censor(String line) {
        char[] values = line.toCharArray();
        for (int i = 0; i < values.length; i++) {
            if (values[i] >= 48 && values[i] <= 57) values[i] = 'X';
        }
        return String.valueOf(values);
    }

}
