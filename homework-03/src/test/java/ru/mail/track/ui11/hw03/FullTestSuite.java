package ru.mail.track.ui11.hw03;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * mvn install -P full-test -Dthread.count=8
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        PositiveTestSuite.class,
        NegativeTestSuite.class
})
public class FullTestSuite {
    //full test suite
}