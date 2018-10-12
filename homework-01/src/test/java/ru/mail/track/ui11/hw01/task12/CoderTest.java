package ru.mail.track.ui11.hw01.task12;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.track.ui11.hw01.SysOutCaptureAndAssertionAbility;

/**
 * Тест-класс для задачи №12 - класса программы, который шифрует
 * и расшифровывает входную строку методом ROT1 + простая транспозиция
 */
public class CoderTest implements SysOutCaptureAndAssertionAbility {

    private static final String RN = "\r\n";

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
        Coder coder = new CoderImpl();

        String source = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        String encoded = coder.encode(source);
        System.out.println(encoded);
        String decoded = coder.decode(encoded);
        System.out.println(decoded);

        String result = "0987654321AZYXWVUTSRQPONMLKJIHGFEDCBazyxwvutsrqponmlkjihgfedcb" + RN +
                        "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

        assertSysOutEquals(result + RN);
    }

}