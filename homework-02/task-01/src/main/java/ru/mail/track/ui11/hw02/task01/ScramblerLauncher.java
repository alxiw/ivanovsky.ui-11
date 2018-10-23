package ru.mail.track.ui11.hw02.task01;

import java.io.File;

/**
 * Main-класс, предназначенный для запуска программы
 *
 * При сборке рядом с jar-файлом помещается папка resources
 * с файлом sources.csv, предназначенным для шифрования
 *
 * Файлы ключей шифрования private.key и public.key должны находиться в папке keys,
 * которая должна располагаться рядом с jar-файлом
 * Если её нет, то программа автоматически сгенерирует новые ключи и поместит в папку
 *
 * Результат - файл results.csv, аналогичен по структуре sources.csv,
 * с зашифрованными e-mail адресами 2048-битным алгоритмом RSA, и паролями,
 * закодированными с помощью Base64
 *
 * Программа позволяет дешифровать файл result.csv, находящийся в папке results,
 * результатом чего будет файл reverse.csv в папке reverses
 *
 *
 * Запуск программы производится в коммандной строке из папки,
 * в которой лежит jar-файл следующим образом:
 *
 * В режиме шифрования файла source.csv из папки resources:
 * java -jar homework-02.task-01-1.0-SNAPSHOT.jar en
 *
 * В режиме дешифрования файла result.csv из папки results:
 * java -jar homework-02.task-01-1.0-SNAPSHOT.jar de
 */
public class ScramblerLauncher {

    private static final String SLASH = "/";

    private static final String SOURCES_DIR = "resources";
    private static final String RESULTS_DIR = "results";
    private static final String REVERSES_DIR = "reverses";

    private static final String SOURCE_FILE = "source.csv";
    private static final String RESULT_FILE = "result.csv";
    private static final String REVERSE_FILE = "reverse.csv";

    private ScramblerLauncher() {
        // private constructor
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 0) {
            if ("encode".startsWith(args[0].toLowerCase())) {
                new File(RESULTS_DIR).mkdir();
                Scrambler.scrambleDataFromSourceFileAndSaveToResultFile(new File(SOURCES_DIR + SLASH + SOURCE_FILE), new File(RESULTS_DIR + SLASH + RESULT_FILE), true);
            } else if ("decode".startsWith(args[0].toLowerCase())) {
                new File(REVERSES_DIR).mkdir();
                Scrambler.scrambleDataFromSourceFileAndSaveToResultFile(new File(RESULTS_DIR + SLASH + RESULT_FILE), new File(REVERSES_DIR + SLASH + REVERSE_FILE), false);
            }
        } else {
            System.out.println("Use command line arguments (first significant letters):");
            System.out.println("encode - to encrypt file source.csv from resources");
            System.out.println("decode - to decrypt file result.csv from results");
        }
    }
}
