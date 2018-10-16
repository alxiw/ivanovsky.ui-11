package ru.mail.track.ui11.hw01.task07;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.track.ui11.hw01.SysOutCaptureAndAssertionAbility;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Тест-класс для Задачи №7 - функции, выводящей в csv-файл
 * через сепаратор строки длинами символов, заданным в массиве
 */
public class SolutionTest implements SysOutCaptureAndAssertionAbility {

    private static final String RN = "\r\n";

    private static final int[] LENGTHS = {1, 3, 4, 5, 18};

    public static List<String> list = new ArrayList<>();

    private File file;

    static {
        list.add("tea");
        list.add("moo");
        list.add("cow");
        list.add("exam");
        list.add("dog");
        list.add("chu");
        list.add("general motors");
        list.add("row");
        list.add("cat");
        list.add("story");
        list.add("queue");
        list.add("sir");
        list.add("pow");
        list.add("you");
        list.add("test");
        list.add("goal");
        list.add("whoa");
        list.add("year");
        list.add("zoo");
        list.add("joint");
        list.add("stack");
        list.add("kotlin");
        list.add("python");
        list.add("garbage collector");
        list.add("yo");
        list.add("cat");
    }

    @Before
    public void setUpSystemOut() {
        resetOut();
        captureSysOut();
        file = new File("result.csv");
    }

    @After
    public void tearDown() {
        resetOut();
        file.delete();
    }

    @Test
    public void main() throws IOException {
        try {
            Solution.printStringsToCsv(list, file, LENGTHS);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }

        BufferedReader fin = new BufferedReader(new FileReader(file));
        String line;
        while ((line = fin.readLine()) != null) System.out.println(line);

        String result = "3|tea|moo|cow|dog|chu|row|cat|sir|pow|you|zoo|cat" + RN +
                        "4|exam|test|goal|whoa|year" + RN +
                        "5|story|queue|joint|stack";

        fin.close();

        assertSysOutEquals(result + RN);
    }

}