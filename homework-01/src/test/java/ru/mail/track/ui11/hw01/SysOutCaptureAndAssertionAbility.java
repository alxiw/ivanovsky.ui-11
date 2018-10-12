package ru.mail.track.ui11.hw01;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.fest.assertions.Assertions.*;

/**
 * Интерфейс, реализующий возможность подмены объекта out в классе System
 * и возвращаеине его назад для проверки тестами выводы в консоль
 */
public interface SysOutCaptureAndAssertionAbility {

    /*
     * Объект, которым выполняется подмена объекта out в классе System
     */
    ByteArrayOutputStream OUT = new ByteArrayOutputStream();

    /*
     * Метод, выполняющий подмену объекта out в классе System
     */
    default void captureSysOut() {
        System.setOut(new PrintStream(OUT));
    }

    /*
     * Метод, позволяющий сравнить входящую строку с выводом в консоль на эквивалентность
     */
    default void assertSysOutEquals(String expected) {
        assertThat(OUT.toString()).isEqualTo(expected);
    }

    /*
     * Метод, позволяющий сравнить входящую строку с выводом в консоль на содержание
     */
    default void assertSysOutContains(String expected) {
        assertThat(OUT.toString()).contains(expected);
    }

    /*
     * Метод, выполняющий возвращение исходного объекта out в классе System
     */
    default void resetOut() {
        OUT.reset();
    }
}
