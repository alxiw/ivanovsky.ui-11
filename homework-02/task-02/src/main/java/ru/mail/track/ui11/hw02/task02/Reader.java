package ru.mail.track.ui11.hw02.task02;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, экземпляр которого выполняет чтение списка слов из файла
 */
public class Reader {

    private File file;

    public Reader(File file) {
        this.file = file;
    }

    /**
     * Метод, выполняющий чтение слов из файла
     * @return список слов
     * @throws IOException в случае неудачного чтения слов из файла
     */
    public List<Item> read() throws IOException {
        StringBuilder sb;
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(this.file), StandardCharsets.UTF_8)) {
            sb = new StringBuilder();
            while (reader.ready()) {
                sb.append((char) reader.read());
            }
        }
        String line = sb.toString();
        ArrayList<Item> items = fillTheList(line);
        System.out.println("SOURCE FILE IS READ");
        return items;
    }

    private static ArrayList<Item> fillTheList(String line) {
        ArrayList<Item> list = new ArrayList<>();
        String word = "";
        String ending = "";
        char previous = '\u0000';
        int index = 0;
        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isWhitespace(c)) {
                ending += String.valueOf(c);
            } else {
                if (!Character.isWhitespace(previous)) {
                    word += String.valueOf(c);
                } else {
                    index = addLatestWordAndGetIndex(list, word, ending, index);
                    word = "";
                    ending = "";
                    word += String.valueOf(c);
                }
            }
            if (i == line.length() - 1) {
                index = addLatestWordAndGetIndex(list, word, ending, index);
                word = "";
                ending = "";
                previous = '\u0000';
            } else {
                previous = c;
            }
        }
        return list;
    }

    private static int addLatestWordAndGetIndex(ArrayList<Item> list, String word, String ending, int index) {
        if (!word.equals(String.valueOf('\uFEFF'))) {
            boolean hasWordLetters = false;
            char[] a = word.toCharArray();
            for (char b : a) {
                if (Character.isLetter(b) || Character.isDigit(b)) {
                    hasWordLetters = true;
                    break;
                }
            }
            if (hasWordLetters) {
                list.add(new Item(++index, word, ending));
            } else {
                Item item = list.get(list.size() - 1);
                item.setEnding(item.getEnding() + word + ending);
                list.set(list.size() - 1, item);
            }
        }
        return index;
    }
}
