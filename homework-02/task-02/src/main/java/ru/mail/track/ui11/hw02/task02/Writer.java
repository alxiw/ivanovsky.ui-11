package ru.mail.track.ui11.hw02.task02;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Класс, экземпляр которого выполняет запись слов в файл
 */
public class Writer {

    private File file;

    public Writer(File file) {
        this.file = file;
    }

    /**
     * Метод, выполняющий запись списка слов в файл
     * @param list список слов, который необходимо записать
     * @throws IOException в случае неудачной записи в файл
     */
    public void write(List<Item> list) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(this.file))) {
            list.forEach(s -> writer.write(s.getWord() + s.getEnding()));
            System.out.println("RESULT FILE IS SAVED");
        }
    }
}
