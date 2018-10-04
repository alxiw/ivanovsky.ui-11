package ru.mail.track.ui11.hw01.task12;

public class CoderImpl implements Coder {

    private static final int STEP = 1;

    @Override
    public String encode(String str) {
        char[] values = str.toCharArray();
        for (int i = 0; i < values.length; i++) {
            char current = values[i];
            if (current >= 65 && current <= 90) {
                values[i] = current + STEP <= 90 ? (char) (current + STEP) : (char) (current + STEP - 26);
            } else if (current >= 97 && current <= 122) {
                values[i] = current + STEP <= 122 ? (char) (current + STEP) : (char) (current + STEP - 26);
            }
        }
        return String.valueOf(reverse(values));
    }

    @Override
    public String decode(String str) {
        char[] values = str.toCharArray();
        for (int i = 0; i < values.length; i++) {
            char current = values[i];
            if (current >= 65 && current <= 90) {
                values[i] = current - STEP >= 65 ? (char) (current - STEP) : (char) (current - STEP + 26);
            } else if (current >= 97 && current <= 122) {
                values[i] = current - STEP >= 97 ? (char) (current - STEP) : (char) (current - STEP + 26);
            }
        }
        return String.valueOf(reverse(values));
    }

    private char[] reverse(char[] values) {
        for (int i = 0; i < values.length / 2; i++) {
            char temp = values[i];
            values[i] = values[values.length - 1 - i];
            values[values.length - 1 - i] = temp;
        }
        return values;
    }
}
