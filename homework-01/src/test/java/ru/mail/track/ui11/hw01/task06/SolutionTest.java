package ru.mail.track.ui11.hw01.task06;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.track.ui11.hw01.SysOutCaptureAndAssertionAbility;

import java.util.ArrayList;
import java.util.List;

/**
 * Тест-класс для Задачи №6 - функции, выводящей имена студентов по алфавиту и
 * факультеты на которых они обучаются в формате <имя студента>: <название факультета>,
 * а также 3 самых популярных факультета среди студентов в формате
 * «Top 3: <факультет 1>, <факультет 2>, <факультет 3>»
 */
public class SolutionTest implements SysOutCaptureAndAssertionAbility {

    private static final String RN = "\r\n";

    /*
     * Создание списка студентов
     */
    public static List<Student> list = new ArrayList<>();

    /*
     * Заполнение списка студентов и его заполнение
     */
    static {
        list.add(new Student("Вася", "ФРТК"));
        list.add(new Student("Саша", "ФФКЭ"));
        list.add(new Student("Петя", "ФПФЭ"));
        list.add(new Student("Лена", "ФМБФ"));
        list.add(new Student("Жора", "ФИВТ"));
        list.add(new Student("Ашот", "ФФКЭ"));
        list.add(new Student("Миша", "ФИВТ"));
        list.add(new Student("Джек", "ФФКЭ"));
        list.add(new Student("Иван", "ФУПМ"));
        list.add(new Student("Анна", "ФРТК"));
        list.add(new Student("Лара", "ФФКЭ"));
        list.add(new Student("Дима", "ФИВТ"));
        list.add(new Student("Джон", "ФРТК"));
        list.add(new Student("Хосе", "ФРТК"));
        list.add(new Student("Маша", "ФРТК"));
        list.add(new Student("Катя", "ФРТК"));
        list.add(new Student("Зина", "ФИВТ"));
        list.add(new Student("Галя", "ФИВТ"));
        list.add(new Student("Таня", "ФРТК"));
        list.add(new Student("Коля", "ФФКЭ"));
        list.add(new Student("Олег", "ФАЛТ"));
        list.add(new Student("Ганс", "ФИВТ"));
    }

    @Before
    public void setUpSystemOut() {
        resetOut();
        captureSysOut();
    }

    @After
    public void tearDown() {
        resetOut();
    }

    @Test
    public void main() {
        /*
         * Вывод на экран отсортированного по именам списка студентов
         * c тремя самыми популярными факультетами
         */
        Solution.printListOfStudentsWithTopFaculties(list, 4);

        String result = "Анна: ФРТК" + RN +
                        "Ашот: ФФКЭ" + RN +
                        "Вася: ФРТК" + RN +
                        "Галя: ФИВТ" + RN +
                        "Ганс: ФИВТ" + RN +
                        "Джек: ФФКЭ" + RN +
                        "Джон: ФРТК" + RN +
                        "Дима: ФИВТ" + RN +
                        "Жора: ФИВТ" + RN +
                        "Зина: ФИВТ" + RN +
                        "Иван: ФУПМ" + RN +
                        "Катя: ФРТК" + RN +
                        "Коля: ФФКЭ" + RN +
                        "Лара: ФФКЭ" + RN +
                        "Лена: ФМБФ" + RN +
                        "Маша: ФРТК" + RN +
                        "Миша: ФИВТ" + RN +
                        "Олег: ФАЛТ" + RN +
                        "Петя: ФПФЭ" + RN +
                        "Саша: ФФКЭ" + RN +
                        "Таня: ФРТК" + RN +
                        "Хосе: ФРТК" + RN +
                        "Top 4: ФРТК (7 человек), ФИВТ (6 человек), ФФКЭ (5 человек), ФАЛТ (1 человек)";

        assertSysOutEquals(result + RN);
    }

}