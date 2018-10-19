package ru.mail.track.ui11.hw01.task06;

import java.util.*;

/**
 * Задача №6
 *
 * Дан список студентов, которые обучаются на факультетах в МФТИ
 *
 * Необходимо, используя Stream API, вывести имена студентов по алфавиту и факультеты на
 * которых они обучаются в формате <имя студента>: <название факультета>
 *
 * Необходимо вывести 3 самых популярных факультета среди студентов в
 * формате «Top 3: <факультет 1>, <факультет 2>, <факультет 3>»
 */
public class Solution {

    /**
     * Реализация функции, выводящей на экран отсортированного по именам списка студентов,
     * и трёх самых популярных факультетов с количеством человек
     * @param list список студентов
     */
    public static void printListOfStudentsWithTopFaculties(List<Student> list, int... args) {
        /*
         * Количество самых популярных факультетов, которое необходимо вывести
         */
        int number = 3;

        if (args.length != 0 && args[0] > 0)
            number = args[0];

        /*
         * Вывод на экран отсортированного по именам списка студентов
         */
        printListOfStudents(list);

        /*
         * Вывод на экран трёх самых популярных факультетов
         */
        printTopFaculties(list, number);
    }

    /**
     * Функция, выводящая на экран отсортированного по именам списка студентов
     * @param list список студентов
     */
    private static void printListOfStudents(List<Student> list) {
        list.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(s -> System.out.println(s.getName() + ": " + s.getFaculty()));
    }

    /**
     * Вывод на экран трёх самых популярных факультетов с количеством человек
     * @param list список студентов
     * @param number количество наиболее популярных факультетов
     */
    private static void printTopFaculties(List<Student> list, int number) {

        /*
         * Map для хранения названий факультетов с количеством студентов на нём
         * key: название факультета
         * value: количество студентов
         */
        Map<String, Integer> map = new HashMap<>();

        list.forEach(s -> map.put(s.getFaculty(), map.containsKey(s.getFaculty()) ? map.get(s.getFaculty()) + 1 : 1));

        /*
         * List для хранения названий факультетов с количеством студентов на нём в одной строки,
         * в порядке уменьшения количества студентов
         */
        List<String> top = new ArrayList<>();

        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> top.add(e.getKey() + " (" + e.getValue() + " человек)"));

        /*
         * Формирование строки с тремя самыми популярными факультетами и вывод её на экран
         */
        StringBuilder sb = new StringBuilder();
        top.stream().limit(number).forEach(s -> sb.append(s).append(", "));
        if (sb.toString().length() != 0)
            sb.insert(0, "Top " + number + ": ").delete(sb.toString().length() - 2, sb.toString().length());
        System.out.println(sb.toString());
    }

}
