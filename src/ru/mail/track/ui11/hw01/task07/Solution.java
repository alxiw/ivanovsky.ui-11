package ru.mail.track.ui11.hw01.task07;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;

import com.opencsv.CSVWriter;

public class Solution {

    private static final int[] LENGTHS = {3, 4, 5};

    public static void main(String[] args) throws FileNotFoundException {

        PrintWriter pw = new PrintWriter(new File(args[0]));

        CSVWriter writer = new CSVWriter(pw, '|',
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.RFC4180_LINE_END);

        List<String> list = new ArrayList<>();

        list.add("tes");
        list.add("moo");
        list.add("moo");
        list.add("moo");
        list.add("moo");
        list.add("moo");
        list.add("tes");
        list.add("srt");
        list.add("gfd");
        list.add("yut");
        list.add("test");
        list.add("dfgs");
        list.add("uioy");
        list.add("yter");
        list.add("story");
        list.add("katze");
        list.add("joint");
        list.add("stack");
        list.add("poopoo");
        list.add("python");
        list.add("garbage collector");
        list.add("yo");
        list.add("cat");

        Map<Integer, List<String>> map = new HashMap<>();

        for (String item : list) {
            int key = item.length();
            if (!map.containsKey(key))
                map.put(key, new ArrayList<>());
            List<String> check = map.get(key);
            check.add(item);
            map.put(key, check);
        }

        List<String[]> data = new ArrayList<>();

        for (int l : LENGTHS) {
            List<String> string = new ArrayList<>();
            for (Map.Entry entry : map.entrySet()) {
                if (entry.getKey().equals(l)) {
                    string = map.get(l);
                }
            }
            String[] array = new String[string.size() + 1];
            array[0] = String.valueOf(l);
            for (int i = 1; i < array.length; i++) {
                array[i] = string.get(i - 1);
            }
            data.add(array);

            /*
            StringBuilder sb = new StringBuilder();

            for (String item : string) {
                sb.append(item).append(" | ");
            }

            if (sb.toString().length() != 0) {
                sb.insert(0, l + " | ").delete(sb.toString().length() - 3, sb.toString().length() - 1);
            }

            System.out.println(sb.toString());
            pw.print(sb.toString());
            pw.print("\r\n");
            */
        }

        writer.writeAll(data);
        pw.close();

    }

}
