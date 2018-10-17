package ru.mail.track.ui11.hw01.task07;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.opencsv.CSVWriter;

/**
 * Задача №7
 *
 * Дан список строк
 *
 * Необходимо вывести в файл .csv через сепаратор | строки длинами от 3 до 5 символов
 * В первой строке необходимо вывести все строки длиной 3 в формате <длина строки>|<строки>
 * Во второй строке аналогично, только со словами длиной 4 и так далее
 * Использовать нужно Stream API
 *
 * Пример вывода:
 * 3 | tes | srt | gfd | yut
 * 4 | test | dfgs | uioy | yter
 */
public class Solution {

    /**
     * Функция, выводящая в csv-файл строки длинами, указанными в массиве LENGTH
     * @param list список строк
     * @param lengths длины строк, которые функция выведет
     * @param path файл, в который функция выведет строки
     * @throws FileNotFoundException исключениеЮ которое будет поймано в случае, если файл не будет найден
     */
    public static void printStringsToCsv(List<String> list, File path, int... lengths) throws IOException {
        PrintWriter pw = new PrintWriter(path);

        CSVWriter writer = new CSVWriter(pw, '|',
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.RFC4180_LINE_END);

        Map<Integer, List<String>> map = new HashMap<>();

        for (String item : list) {
            int key = item.length();
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            List<String> check = map.get(key);
            check.add(item);
            map.put(key, check);
        }

        List<String[]> data = Arrays.stream(lengths)
                .filter(length -> !getStringsOfSameLength(map, length).isEmpty())
                .mapToObj(length -> getStringsOfSameLength(map, length))
                .map(str -> {
                    String[] array = new String[str.size() + 1];
                    array[0] = String.valueOf(str.get(0).length());
                    IntStream.range(1, array.length)
                            .forEach(index -> array[index] = str.get(index - 1));
                    return array;
                }).collect(Collectors.toList());

        writer.writeAll(data);
        writer.close();
        pw.close();
    }

    private static List<String> getStringsOfSameLength(Map<Integer, List<String>> strings, int length) {
        Optional<Map.Entry<Integer, List<String>>> options = strings.entrySet().stream()
                .filter(entry -> entry.getKey() == length)
                .findFirst();
        return options.isPresent() ? options.get().getValue() : new ArrayList<>();
    }

}
