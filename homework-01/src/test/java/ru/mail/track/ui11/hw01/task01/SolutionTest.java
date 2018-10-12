package ru.mail.track.ui11.hw01.task01;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.mail.track.ui11.hw01.SysOutCaptureAndAssertionAbility;

/**
 * Тест-класс для Задачи №1
 */
public class SolutionTest implements SysOutCaptureAndAssertionAbility {

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
        Solution.main(new String[]{"10"});
        Solution.main(new String[]{"5"});
        Solution.main(new String[]{"0"});
        Solution.main(new String[]{"20"});
        assertSysOutEquals(55 + RN + 15 + RN + 0 + RN + 210 + RN);
    }
}