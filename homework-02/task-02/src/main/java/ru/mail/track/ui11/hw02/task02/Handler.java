package ru.mail.track.ui11.hw02.task02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, экземпляр которого выполняет обрабатку список слов
 */
public class Handler {

    private File file;

    public Handler(File file) {
        this.file = file;
    }

    /**
     * Метод, выполняющий обработку списка слов
     * @param list список слов, который нужно обработать
     * @return обработанный список слов
     */
    public List<Item> handle(List<Item> list, int n, int start, int size) {
        List<String> exceptions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(this.file))) {
            while (reader.ready()) {
                exceptions.add(reader.readLine());
            }
        } catch (IOException e) {
            System.out.println("ERROR DURING EXCEPTION FILE PARSING\n" + e.getMessage());
        }

        n = n < 0 ? 0 : n;
        start = (start < 1 || start > list.size() - 1) ? 1 : start;
        size = size < 1 ? 1 : size;
        int z = (start + n > list.size()) ? list.size() : start - 1 + n;

        System.out.println("Number of words: " + list.size());
        System.out.println("From word number: " + start);
        System.out.println("To word number: " + (z + 1));
        System.out.println("Minimal word length: " + size);

        return handleList(list.subList(start - 1, z), exceptions, size);
    }

    private static List<Item> handleList(List<Item> list, List<String> exceptions, int size) {
        if (!list.isEmpty()) {
            for (Item item : list) {
                String word = item.getWord();
                for (String exception : exceptions) {
                    String w = word.toLowerCase();
                    if (w.contains(exception)) {
                        String a = word.substring(0, w.indexOf(exception) );
                        String b = word.substring(w.indexOf(exception) + exception.length());
                        item.setWord(a + "[18+]" + b);
                    }
                }
                if (word.length() < size) {
                    item.setWord("[L<" + size + "]");
                }
            }
            Item item = list.get(list.size() - 1);
            if (Character.isLetter(item.getWord().charAt(0))) {
                item.setEnding("\n");
            }
        }
        return list;
    }
}
