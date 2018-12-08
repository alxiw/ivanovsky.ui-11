package ru.mail.track.ui11.seleniumtestcore.log;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogger {

    private final static Logger rootLogger = LogManager.getRootLogger();

    public void log(String message) {
        rootLogger.info(message);
    }
}
