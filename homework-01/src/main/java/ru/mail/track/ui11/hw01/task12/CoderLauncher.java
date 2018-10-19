package ru.mail.track.ui11.hw01.task12;

/**
 * Реализация программы, шифрующей и расшифровывающей входную строку методом ROT1 + транспозиция
 */
public class CoderLauncher {

    private static final String ENCODE = "en";
    private static final String DECODE = "de";

    private static final String UNKNOWN = "UNKNOWN COMMAND";

    public static void main(String[] args) {
        Coder coder = new CoderImpl();
        switch (args[0].toLowerCase()) {
            case ENCODE:
                System.out.println(coder.encode(args[1]));
                break;
            case DECODE:
                System.out.println(coder.decode(args[1]));
                break;
            default:
                System.out.println(UNKNOWN);
                break;
        }
    }

}
