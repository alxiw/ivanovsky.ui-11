package ru.mail.track.ui11.hw02.task01;

import java.io.File;

/**
 * Задача №1 - Шифрование
 *
 * Есть csv файл с паролями и email пользователей (разделитель | )
 *
 * Необходимо зашифровать:
 * пароль с помощью base64,
 * email с помощью шифрования RSA с данным открытым ключом
 *
 * Организовать нужно следующим образом:
 * Первый поток получает данные из входного файла с emails и паролямии и передает их второму потоку
 * Второй поток шифрует эти данные, затем второй поток передает эти данные третьему потоку
 * Третий поток записывает результат шифрования в выходной csv файл (разделитель | )
 *
 * Программа должна уметь шифровать и расшифровывать данные
 *
 * Входной csv файл должен лежать в папке resources maven проекта
 * А выходной в создаваемой в корне проекта папке results
 */
public class Scrambler {

    private Scrambler() {
        // private constructor
    }

    public static void scrambleDataFromSourceFileAndSaveToResultFile(File source, File result, boolean isToEncode) throws InterruptedException {
        Buffer firstBuffer = new Buffer();
        Buffer secondBuffer = new Buffer();

        Reader reader = new Reader(firstBuffer, source);
        Coder coder = new Coder(firstBuffer, secondBuffer, isToEncode);
        Writer writer = new Writer(secondBuffer, result);

        Thread one = new Thread(reader);
        Thread two = new Thread(coder);
        Thread three = new Thread(writer);

        one.start();
        one.join();

        two.start();
        two.join();

        three.start();
        three.join();
    }
}
