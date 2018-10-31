package ru.mail.track.ui11.hw03;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import ru.mail.track.ui11.hw03.task01.SieveNegativeTest;
import ru.mail.track.ui11.hw03.task02.MatrixRowSortNegativeTest;
import ru.mail.track.ui11.hw03.task03.StudentMicroServiceNegativeTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        SieveNegativeTest.class,
        MatrixRowSortNegativeTest.class,
        StudentMicroServiceNegativeTest.class
})
public class NegativeTestSuite {
    //negative test suite
}
