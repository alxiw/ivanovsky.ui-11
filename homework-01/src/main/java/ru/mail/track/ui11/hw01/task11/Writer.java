package ru.mail.track.ui11.hw01.task11;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PipedInputStream;

public class Writer implements Runnable {

    private PipedInputStream pis;
    private File output;

    public Writer(PipedInputStream pis, File output) {
        this.pis = pis;
        this.output = output;
    }

    @Override
    public void run() {
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
    }
}
