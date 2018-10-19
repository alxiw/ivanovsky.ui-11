package ru.mail.track.ui11.hw01.task01;

/**
 * Задача №1
 *
 * Вычислите сумму чисел от 1 до n без использования циклов и условий
 * n - натуральное число
 */
public class Solution {

    /**
     * Статическое поле, в которое записывается сумма
     */
    private static int sum;

    /**
     * Главный метод программы, подсчитывающей сумму чисел с помощью статического поля sum
     * @param args аргументы командной строки,
     *             массив, в нулевом элементе которого принимаем число n,
     *             от 0 до которого считаем сумму
     * @exception ArrayIndexOutOfBoundsException
     *            будет пойман, если число n не было задано
     *            с помощью аргумента командной строки
     */
    public static void main(String[] args) {
        try {
            recursion(Integer.parseInt(args[0]));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(sum);
        sum = 0;
    }

    /**
     * Рекурсивный метод, подсчитывающий сумму чисел с помощью статического поля sum
     * @param number число, сумму от 0 до которого нужно добавить в поле sum
     * @exception ArithmeticException
     *            будет пойман, когда метод на вход
     *            примет число равное 0
     */
    private static void recursion(int number) {
        try {
            /*
             * Неиспользуемая переменная, необходимая для проверки number на 0
             */
            int check = 1/number;
            sum += number;
            recursion(--number);
        } catch (ArithmeticException ignored) {}
    }

}
