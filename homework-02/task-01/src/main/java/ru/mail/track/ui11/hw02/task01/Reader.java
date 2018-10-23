package ru.mail.track.ui11.hw02.task01;

import com.opencsv.*;

import java.io.*;

/**
 * Класс, предназначенный для считывания данных из csv-файла
 * и передачи их в буфер с помощью сущности User
 */
public class Reader implements Runnable {

    private Buffer buffer;
    private File file;


    public Reader(Buffer buffer, File file) {
        this.buffer = buffer;
        this.file = file;
    }

    @Override
    public void run() {
        try (CSVReader reader = new CSVReaderBuilder(
                new FileReader(file)).withCSVParser(
                        new CSVParserBuilder().withSeparator('|').withQuoteChar('"').build())
                .build()) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line.length >= 3) {
                    User user = new User(line[0], line[1], line[2]);
                    buffer.addQueue(user);
                }
            }
            System.out.println("SOURCE FILE IS READ");
        } catch (IOException e) {
            System.out.println("ERROR DURING READING THE SOURCE FILE\n" + e.getMessage());
        }
    }

}
