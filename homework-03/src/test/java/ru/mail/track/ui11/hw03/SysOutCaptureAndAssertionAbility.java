package ru.mail.track.ui11.hw03;

import org.hamcrest.Matchers;
import org.junit.Assert;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public interface SysOutCaptureAndAssertionAbility {

    String RN = "\r\n";
    ByteArrayOutputStream OUT = new ByteArrayOutputStream();

    default void captureSysOut() {
        System.setOut(new PrintStream(OUT));
    }

    default void assertSysOutEquals(String expected) {
        Assert.assertEquals(OUT.toString(), expected);
    }

    default void assertSysOutContains(String expected) {
        Assert.assertThat(OUT.toString(), Matchers.containsString(expected));
    }

    default void resetOut() {
        OUT.reset();
    }

}
