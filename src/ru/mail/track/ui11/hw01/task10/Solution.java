package ru.mail.track.ui11.hw01.task10;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException {

        final PipedInputStream pis = new PipedInputStream();
        final PipedOutputStream pos = new PipedOutputStream();

        pis.connect(pos);

        /*Thread for writing data to pipe*/
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

        /*Thread for reading data from pipe*/
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

        /*Start thread*/
        pipeWriter.start();
        pipeReader.start();

        /*Join Thread*/
        pipeWriter.join();
        pipeReader.join();

        /*Close stream*/
        pos.close();
        pis.close();

    }
}
