package ru.mail.track.ui11.hw03;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.mail.track.ui11.hw03.task01.SievePositiveTest;
import ru.mail.track.ui11.hw03.task02.MatrixRowSortPositiveTest;
import ru.mail.track.ui11.hw03.task03.StudentMicroServicePositiveTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SievePositiveTest.class,
        MatrixRowSortPositiveTest.class,
        StudentMicroServicePositiveTest.class
})
public class PositiveTestSuite {
    //positive test suite
}
