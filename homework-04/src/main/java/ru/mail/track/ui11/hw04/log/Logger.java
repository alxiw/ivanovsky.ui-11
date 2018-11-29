package ru.mail.track.ui11.hw04.log;

import org.apache.logging.log4j.LogManager;

public class Logger {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getRootLogger();

    public static void log(String message) {
        logger.info(message);
    }
}
