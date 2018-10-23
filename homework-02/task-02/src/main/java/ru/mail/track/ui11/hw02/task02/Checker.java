package ru.mail.track.ui11.hw02.task02;

import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;

/**
 * Класс, экземпляр которого выполняет обрабатку аргументов коммандной строки
 */
public class Checker {

    @Option(name="-n", usage="Number of words to read", required = true)
    private int n = 0;

    @Option(name="-start", usage="Number of word at which to read", required = true)
    private int start = 1;

    @Option(name="-size", usage="Minimal word length", required = true)
    private int size = 1;

    public Checker(String[] args) throws IOException {
        this.accept(args);
    }

    public int getN() {
        return n;
    }

    public int getStart() {
        return start;
    }

    public int getSize() {
        return size;
    }

    /**
     * Метод, выполняющий чтение файла со словами, которые нужно зацензурировать
     * и принимающий параметры для обработки списка слов
     * @param arguments массив аргументов
     * @throws IOException будет отловлен в случае неудачного чтения файла
     *                     со словами, которые нужно зацензурировать
     */
    private void accept(final String[] arguments) throws IOException {
        final CmdLineParser parser = new CmdLineParser(this);
        if (arguments.length < 3) {
            exitWithPrintUsage(parser);
        }
        try {
            parser.parseArgument(arguments);
            System.out.println("ARGUMENTS ARE ACCEPTED");
        }
        catch (CmdLineException e) {
            System.out.println("ERROR DURING ARGUMENTS PARSING\n" + e.getMessage());
            exitWithPrintUsage(parser);
        }
    }

    private void exitWithPrintUsage(CmdLineParser parser) {
        parser.printUsage(System.out);
        System.exit(-1);
    }
}
