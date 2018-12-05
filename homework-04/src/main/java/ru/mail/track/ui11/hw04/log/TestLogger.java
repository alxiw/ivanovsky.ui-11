package ru.mail.track.ui11.hw04.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogger {

    private static final Logger TEST_LOGGER = LogManager.getRootLogger();

    public static void log(String message) {
        TEST_LOGGER.info(message);
    }
}
