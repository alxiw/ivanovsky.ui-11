package ru.mail.track.ui11.hw01.task11;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class Solution {

    public static void main(String[] args) throws IOException, InterruptedException {

        final PipedInputStream pis = new PipedInputStream();
        final PipedOutputStream pos = new PipedOutputStream();

        pis.connect(pos);

        ArrayList<String> list = new ArrayList<>();

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(args[0])), Charset.forName("UTF-8")));
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(censor(line));
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

        /*Thread for writing data to pipe*/
        Thread pipeWriter = new Thread(() -> {
            try {
                for (String item : list) {
                    char[] values = item.toCharArray();
                    for (char value : values)
                        pos.write(value);
                    pos.write('\n');
                }
                Thread.sleep(50);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });

        /*Thread for reading data from pipe*/
        Thread pipeReader = new Thread(() -> {
            try {
                FileWriter writer = new FileWriter(args[1]);
                StringBuilder sb = new StringBuilder();
                while (pis.available() != 0) {
                    char y = (char) pis.read();
                    if (y != '\n') {
                        sb.append(String.valueOf(y));
                    } else {
                        writer.write(sb.toString());
                        writer.write("\r\n");
                        System.out.println(sb.toString());
                        sb = new StringBuilder();
                    }
                    Thread.sleep(10);
                }
                writer.close();
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
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

    private static String censor(String line) {
        char[] values = line.toCharArray();
        for (int i = 0; i < values.length; i++) {
            if (values[i] >= 48 && values[i] <= 57) values[i] = 'X';
        }
        return String.valueOf(values);
    }
}
