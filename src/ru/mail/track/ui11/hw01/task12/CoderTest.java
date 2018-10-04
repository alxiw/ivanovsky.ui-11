package ru.mail.track.ui11.hw01.task12;

public class CoderTest {

    public static void main(String[] args) {
        Coder coder = new CoderImpl();
        String encoded = coder.encode("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890");
        System.out.println(encoded);
        String decoded = coder.decode(encoded);
        System.out.println(decoded);
    }


}
