package ru.mail.track.ui11.hw01.task06;

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        List<String> top = new ArrayList<>();

        list.add(new Student("Вася", "ФРТК"));
        list.add(new Student("Петя", "ФПФЭ"));
        list.add(new Student("Лена", "ФМБФ"));
        list.add(new Student("Жора", "ФИВТ"));
        list.add(new Student("Ашот", "ФФКЭ"));
        list.add(new Student("Джек", "ФФКЭ"));
        list.add(new Student("Иван", "ФУПМ"));
        list.add(new Student("Дима", "ФИВТ"));
        list.add(new Student("Джон", "ФРТК"));
        list.add(new Student("Маша", "ФРТК"));
        list.add(new Student("Катя", "ФРТК"));
        list.add(new Student("Таня", "ФРТК"));
        list.add(new Student("Олег", "ФАЛТ"));
        list.add(new Student("Ганс", "ФИВТ"));

        list.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(s -> map.put(s.getFaculty(), map.containsKey(s.getFaculty()) ? map.get(s.getFaculty()) + 1 : 1));

        map.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(e -> top.add(e.getKey() + " (" + e.getValue() + ")"));

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < top.size(); i++) {
            if (i >= 3)
                break;
            else
                sb.append(top.get(i)).append(", ");
        }

        if (sb.toString().length() != 0)
            sb.insert(0, "Top 3: ").delete(sb.toString().length() - 2, sb.toString().length() - 1);

        System.out.println(sb.toString());

    }
}
