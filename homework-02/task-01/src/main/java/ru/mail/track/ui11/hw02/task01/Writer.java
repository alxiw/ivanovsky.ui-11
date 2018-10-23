package ru.mail.track.ui11.hw02.task01;

import com.opencsv.CSVWriter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, предназначенный для принятия данных из буфера
 * с помощью сущности User и дальнейшей записи в csv-файл
 */
public class Writer implements Runnable {

    private Buffer buffer;
    private File file;

    public Writer(Buffer buffer, File file) {
        this.buffer = buffer;
        this.file = file;
    }

    @Override
    public void run() {
        List<String[]> data = new ArrayList<>();
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            CSVWriter writer = new CSVWriter(pw,
                    '|',
                    '"',
                    CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                    CSVWriter.RFC4180_LINE_END);
            User user;
            while (true) {
                user = buffer.getQueue();
                if (user != null) {
                    String[] array = new String[3];
                    array[0] = user.getName();
                    array[1] = user.getEmail();
                    array[2] = user.getPassword();
                    data.add(array);
                } else {
                    break;
                }
            }
            writer.writeAll(data);
            System.out.println("RESULT FILE IS SAVED");
        } catch (IOException e) {
            System.out.println("ERROR DURING WRITING THE RESULT FILE\n" + e.getMessage());
        }
    }
}
