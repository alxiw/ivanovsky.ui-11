package ru.mail.track.ui11.hw02.task02;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс, экземпляр которого выполняет обрабатку список слов
 */
public class Checker {

    @Option(name="-n", usage="Number of words to read")
    private static int n = 0;

    @Option(name="-start", usage="Number of word at which to read")
    private static int start = 1;

    @Option(name="-size", usage="Minimal word length")
    private static int size = 1;

    private File file;

    private static ArrayList<String> exceptions;

    public Checker(File file) {
        this.file = file;
    }

    /**
     * Метод, выполняющий чтение файла со словами, которые нужно зацензурировать
     * и принимающий параметры для обработки списка слов
     * @param arguments массив аргументов
     * @throws IOException будет отловлен в случае неудачного чтения файла
     *                     со словами, которые нужно зацензурировать
     */
    public void accept(final String[] arguments) throws IOException {
        final CmdLineParser parser = new CmdLineParser(this);
        if (arguments.length < 1) {
            parser.printUsage(System.out);
            System.exit(-1);
        }
        try {
            parser.parseArgument(arguments);
        }
        catch (CmdLineException e) {
            System.out.println("ERROR DURING PARAMETERS PARSING\n" + e.getMessage());
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            exceptions = new ArrayList<>();
            while (reader.ready()) {
                exceptions.add(reader.readLine());
            }
        }
    }

    /**
     * Метод, выполняющий обработку списка слов
     * @param list список слов, который нужно обработать
     * @return обработанный список слов
     */
    public List<Item> handle(List<Item> list) {
        int z = start - 1 + n;
        if (z > list.size() - 1) {
            z = list.size();
        }
        System.out.println("Number of words: " + list.size());
        System.out.println("From word number: " + start);
        System.out.println("To word number: " + (z + 1));
        System.out.println("Minimal word length: " + size);

        return handleList(list.subList(start - 1, z), size);
    }

    private static List<Item> handleList(List<Item> list, int size) {
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
