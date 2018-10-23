package ru.mail.track.ui11.hw02.task02;

import java.io.*;
import java.util.List;

/**
 * Задача №2 - Слова и их цензура
 *
 * Есть 2 файла:
 * Первый с текстом (небольшой по объему)
 * Второй со словами исключениями - exception.txt, лежит в resources
 *
 * Необходимо прочитать из первого файла слова в соответствии
 * со следующими входными параметрами программы:
 * -n - количество слов, которые необходимо прочитать в тексте
 * -start - номер слова, с какого слова в тексте необходимо читать
 * -size - минимальный размер длины слова, который должен быть прочитан
 *
 * Если длина слова меньше, чем указано значение в параметре -size, то необходимо
 * это слово заменить строкой "размер меньше чем <указать значение параметра -size>"
 *
 * Если прочитанное слово является исключением, то необходимо его заменить словом "цензура"
 *
 * Пример запуска: java -jar homework-02.task-02-1.0-SNAPSHOT.jar -n 107 -start 1 -size 3
 * Программа прочитает подряд 107 слов из текста, начиная с 1 слова, заменив
 * подстрокой "[L<3]" все слова, у которых длина меньше 3 символов,
 * или словом "[18+]" если слово содержится в файле exception.txt
 */
public class WordCensor {

    private static final String SLASH = "/";

    private static final String SOURCES_DIR = "resources";
    private static final String RESULTS_DIR = "results";

    private static final String SOURCE_FILE = "source.txt";
    private static final String RESULT_FILE = "result.txt";
    private static final String EXCEPTION_FILE = "exception.txt";

    private WordCensor() {
        // private constructor
    }

    public static void main(String[] args) throws IOException {

        String source = SOURCES_DIR + SLASH + SOURCE_FILE;
        String exception = SOURCES_DIR + SLASH + EXCEPTION_FILE;
        String result = RESULTS_DIR + SLASH + RESULT_FILE;

        Checker checker = new Checker(args);

        Reader reader = new Reader(new File(source));
        List<Item> list = reader.read();

        Handler handler = new Handler(new File(exception));
        List<Item> handled = handler.handle(list, checker.getN(), checker.getStart(), checker.getSize());

        new File(RESULTS_DIR).mkdir();
        Writer writer = new Writer(new File(result));
        writer.write(handled);

    }
}
