package ru.mail.track.ui11.hw01.task01;

public class Solution {
    public static void main(String[] args) {
        int a = 10;
        recursion(a);
    }

    private static void recursion(int a) {
        try {
            int b = 1/a;
            System.out.println(a);
            recursion(--a);
        } catch (ArithmeticException e) {
            return;
        }

    }
}
