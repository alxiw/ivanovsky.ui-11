package ru.mail.track.ui11.hw01.task11;

import java.io.*;
import java.nio.charset.Charset;

public class Reader implements Runnable {

    private PipedOutputStream pos;
    private File source;

    public Reader(PipedOutputStream pos, File source) {
        this.pos = pos;
        this.source = source;
    }

    @Override
    public void run() {
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
    }

    /**
     * Функция, заменяющая в строке каждый числовой символ на X
     * @param line строка
     * @return строка, в которой каждый числовой символ заменён на X
     */
    private String censor(String line) {
        char[] values = line.toCharArray();
        for (int i = 0; i < values.length; i++) {
            if (values[i] >= 48 && values[i] <= 57) values[i] = 'X';
        }
        return String.valueOf(values);
    }
}
